package kaeseth.tools.dfa;

import java.util.List;
import java.util.Map;
import java.util.Set;
import kaeseth.tools.dfa.exception.StateMachineStatusErrorException;
import java.util.HashMap;

/**
 * DFA工具
 * @author kaeseth
 *
 */
public class DFAUtil {
	
	private static HashMap<String,Object> source=null;//原状态机
	private static HashMap<String, Object> backUp=null;//备份状态机
	private static boolean disabled=true;//原状态机是否可用
	
	/**
	 * 初始化原状态机
	 * 原状态机只能初始化，且每次初始化都要分配新的内存，不处理原有内存，
	 * 因为原有内存可能正在被匹配算法使用，等所有匹配算法释放掉所有内存后，
	 * 再由GC收回内存。
	 * @param datasource 数据源
	 */
	@SuppressWarnings("unchecked")
	public static void initStateMachine(List<String> datasource){
		DFAUtil.disabled=true;
		DFAUtil.source=null;
		DFAUtil.source=new HashMap<>(datasource.size());
        for(String loop:datasource){
            Map<String,Object> nowMap=DFAUtil.source;
            for(int i=0;i<loop.length();i++){
                char letter=loop.charAt(i);
				Map<String,Object> letterMap=(Map<String,Object>)nowMap.get(letter+"");
                if(letterMap==null){
                    letterMap=new HashMap<>();
                    letterMap.put("isEnd","0");
                    nowMap.put(letter+"",letterMap);
                }
                nowMap=(Map<String,Object>)nowMap.get(letter+"");
            }
            nowMap.put("isEnd","1");
        }
        DFAUtil.disabled=false;
        //备份状态机，只是一个指针，当原状态机不可用时，则使用备份状态机，以防止业务中断。
        DFAUtil.backUp=source;
    }
	
	/**
	 * 最大匹配算法
	 * @param stateMachine 状态机
	 * @param text 要检查的文本
	 * @return 检查结果 key:出现的文本，value:出现的次数
	 */
	public static Map<String,Integer> getMatchWordsByMax(Map<String,Object> stateMachine,String text){
		if(stateMachine==null) {
			return null;
		}
        HashMap<String,Integer> resultMap=new HashMap<>();
        Map<String,Object> nowMap=stateMachine;
        char letter;
        int count=text.length();
        int i=0;
        StringBuilder matchPath=new StringBuilder();
        do{
            if(i==count){
                letter='#';
            }else{
                letter=text.charAt(i);
            }
            @SuppressWarnings("unchecked")
			Map<String,Object> letterMap=(Map<String,Object>)nowMap.get(letter+"");
            if(letterMap!=null){
                //匹配到字
                nowMap=letterMap;//状态指针后移
                matchPath.append(letter);//将匹配到的字加到路径里
                i++;//文本指针后移
            }else{
                //未匹配到字
                //路径中是否有值
                String pathStr=matchPath.toString();
                if(pathStr==null||pathStr.length()<1){
                    i++;//文本指针后移
                }else{
                    //路径中有值
                    //上一个匹配到的值的状态是不是终点 如果为空，则逻辑错
                    Map<String,Object> matchState=nowMap;
                    String isEnd=(String)matchState.get("isEnd");
                    if(isEnd==null||isEnd.equals("")){
                        //逻辑错误
                    	throw new StateMachineStatusErrorException();
                    }else{
                        if(isEnd.equals("1")){
                            //该状态是终点
                            Integer tempCount=(Integer)resultMap.get(pathStr);//匹配结果中是否已有该键
                            if(tempCount==null){
                                //匹配结果集中没有该键 赋初值
                                tempCount=0;
                            }
                            tempCount=tempCount+1;
                            resultMap.put(pathStr,tempCount);//将匹配到的字符串加入到结果集中。
                        }else if(isEnd.equals("0")){
                        }
                    }
                    matchPath=null;
                    matchPath=new StringBuilder();//请空路径，做下一次匹配
                    nowMap=stateMachine;//将状态重置
                }
            }
        }while(i<=count);
        return resultMap;
    }
	
	/**
	 * 最小匹配算法
	 * @param stateMachine 状态机
	 * @param text 需要匹配的文本
	 * @return 匹配结果
	 */
	public static Map<String,Integer> getMatchWordsByMin(Map<String, Object> stateMachine,String text){
		if(stateMachine==null) {
			return null;
		}
		HashMap<String,Integer> resultMap=new HashMap<>();
        Map<String,Object> nowMap=stateMachine;
        char letter;
        int count=text.length();
        int i=0;
        StringBuilder matchPath=new StringBuilder();
        do{
            if(i==count){
                letter='#';
            }else{
                letter=text.charAt(i);
            }
            @SuppressWarnings("unchecked")
			Map<String,Object> letterMap=(Map<String,Object>)nowMap.get(letter+"");
            if(letterMap!=null){
                //匹配到字
            	i++;//文本指针后移
                nowMap=letterMap;//状态指针后移
                matchPath.append(letter);//将匹配到的字加到路径里
                String pathStr=matchPath.toString();
                if(pathStr!=null&&pathStr.length()>0){
                    //路径中有值
                    //上一个匹配到的值的状态是不是终点 如果为空，则逻辑错
                    Map<String,Object> matchState=nowMap;
                    String isEnd=(String)matchState.get("isEnd");
                    if(isEnd==null||isEnd.equals("")){
                        //逻辑错误
                    	throw new StateMachineStatusErrorException();
                    }else{
                        if(isEnd.equals("1")){
                            //该状态是终点
                            Integer tempCount=(Integer)resultMap.get(pathStr);//匹配结果中是否已有该键
                            if(tempCount==null){
                                //匹配结果集中没有该键 赋初值
                                tempCount=0;
                            }
                            tempCount=tempCount+1;
                            resultMap.put(pathStr,tempCount);//将匹配到的字符串加入到结果集中。
                            matchPath=null;
                            matchPath=new StringBuilder();//请空路径，做下一次匹配
                            nowMap=stateMachine;//将状态重置
                        }else if(isEnd.equals("0")){
                        }
                    }
                }
            }else{
                //未匹配到字
            	String pathStr=matchPath.toString();
            	if(pathStr!=null&&pathStr.length()>0) {
            		//路径不为空，清空路径
            		matchPath=null;
            		matchPath=new StringBuilder();
            	}else {
            		i++;//文本指针后移
            	}
            	nowMap=stateMachine;//将状态重置
            }
        }while(i<=count);
        return resultMap;
	}
	
	/**
	 * 获取当前可用的状态机
	 * @return 状态机
	 */
	public static Map<String, Object> getStateMachine(){
		if(DFAUtil.disabled) {
			return DFAUtil.backUp;
		}else {
			return DFAUtil.source;
		}
	}
	
	/**
	 * 匹配文本
	 * @param text 要检查的文本
	 * @param method 匹配方法 MAX:最大匹配,MIN:最小匹配.
	 * @return 匹配结果
	 */
	public static Map<String, Integer> Match(String text,DFAMatchMethod method){
		Map<String, Object> stateMachine=DFAUtil.getStateMachine();
		switch (method) {
		case MAX:
			return DFAUtil.getMatchWordsByMax(stateMachine, text);
		case MIN:
			return DFAUtil.getMatchWordsByMin(stateMachine, text);
		default:
			return DFAUtil.getMatchWordsByMax(stateMachine, text);
		}
	}
	/**
	 * 匹配文本
	 * @param text 要检查的文本
	 * @param method 匹配方法 MAX:最大匹配,MIN:最小匹配.
	 * @param pick 是否需要去除文本中标点，空格等字符。true：去掉，false：不去掉。
	 * @return 命中的单词总长度和文本总长度的比值
	 */
	public static Double Match(String text,DFAMatchMethod method,boolean pick) {
		String temp=text;
		if(pick) {
			temp=text.replaceAll("\\s*","").replaceAll("[\\pP\\p{Punct}]","");
		}
		Map<String, Integer> resultMap=DFAUtil.Match(text, method);
		if(resultMap==null||resultMap.isEmpty()) {
			return 0.0;
		}else {
			Set<String> keys=resultMap.keySet();
			if(keys!=null&&!keys.isEmpty()) {
				double length=0;
				for(String loop:keys) {
					length+=(loop.length()*resultMap.get(loop));
				}
				return length/temp.length();
			}else {
				return 0.0;
			}
		}
	}
	
}

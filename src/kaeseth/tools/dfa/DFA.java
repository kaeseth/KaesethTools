package kaeseth.tools.dfa;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.support.TransactionSynchronization;

import kaeseth.tools.dfa.exception.StateMachineNotEmptyException;
import kaeseth.tools.dfa.exception.StateMachineStatusErrorException;

import java.util.HashMap;

public class DFA {
	
	private HashMap<String,Object> stateMachine;
	
	@SuppressWarnings("unchecked")
	public void initStateMachine(List<String> datasource){
		if(this.stateMachine!=null||!this.stateMachine.isEmpty()) {
    		throw new StateMachineNotEmptyException();
    	}
		this.stateMachine=new HashMap<>(datasource.size());
        for(String loop:datasource){
            Map<String,Object> nowMap=this.stateMachine;
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
    }
	
	public Map<String,Integer> getMatchWordsByMax(String text){
        HashMap<String,Integer> resultMap=new HashMap<>();
        Map<String,Object> nowMap=this.stateMachine;
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
                    nowMap=this.stateMachine;//将状态重置
                }
            }
        }while(i<=count);
        return resultMap;
    }
	
}

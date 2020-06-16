package yuan_code;

import java.util.Stack;

/**
 *  1.栈排序：对栈进行排序使最小元素位于栈顶。
 *    最多只能使用一个其他的临时栈存放数据，但不得将元素复制到别的数据结构（如数组）中。
 */
public class Question001 {

    Stack<Integer> datas;
    public Question001(){
        datas = new Stack<>();
    }

    public void push(int val){
        Stack<Integer> temp = new Stack<>();
        while(!datas.isEmpty()){
            if(datas.peek()<val){
                temp.push(datas.pop());
            }else{
                break;
            }
        }
        datas.push(val);
        while(!temp.isEmpty()){
            datas.push(temp.pop());
        }
    }

    public void pop(){
        if(datas.isEmpty()){
            return;
        }
        datas.pop();
    }

    public int peek(){
        if(datas.isEmpty()){
            return -1;
        }
        return datas.peek();
    }

    public boolean isEmpty(){
        return datas.isEmpty();

    }

}

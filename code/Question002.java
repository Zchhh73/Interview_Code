package yuan_code;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 2.链表实现队列
 * 使用带头指针front和尾指针rear的单链表实现
 * front指向第一个元素
 * rear指向最后一个元素
 * <p>
 * 操作：空队列:front=rear=null。front==null && rear==null队列空
 * 出队操作：单链表头部删除
 * 入队操作：单链表尾部添加
 */
public class Question002 {
    public class Node {
        int val;
        Node next;
        Node prev;

        Node(int data) {
            val = data;
            next = null;
            prev = null;
        }
    }

    private Node front, rear;
    private int size;
    private int maxSize = 128;

    public Question002() {
        this.front = null;
        this.rear = null;
    }

    /**
     * 大小
     *
     * @return
     */
    public int size() {
        return size;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    /**
     * 是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return front == null && rear == null;
    }

    /**
     * 入队
     *
     * @return
     */
    public boolean add(int data) {
        Node temp = new Node(data);
        if (front == null) {
            front = temp;
        } else {
            rear.next = temp;
        }
        this.rear = temp;
        size++;
        return true;
    }

    /**
     * 出队
     *
     * @return
     */
    public Node poll() {
        if(this.isEmpty()) return null;
        Node temp = this.front;
        this.front = this.front.next;
        if(this.front==null)
            this.rear = null;
        size--;
        return temp;

    }

    public int peek() {
        return this.isEmpty() ? 0 : this.front.val;
    }

    public void clearQueue(){
        front=rear=null;
        size=0;
    }


}

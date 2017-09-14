import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Stream;

/**
 *
 * 两个栈实现队列
 *
 */
public class NO7_QueueWithTwoStack {

    public static void main(String[] args) {
        MyQueue<String> myQueue = new MyQueue<>();
        myQueue.appendTail("1");
        myQueue.appendTail("2");
        myQueue.appendTail("3");

        System.out.println(myQueue.deleteHead());
        System.out.println(myQueue.deleteHead());


        MyStack<String> myStack = new MyStack<>();
        myStack.appendTail("1");
        myStack.appendTail("2");
        myStack.appendTail("3");

        System.out.println(myStack.deleteTail());
        System.out.println(myStack.deleteTail());
    }

    //两个栈实现队列
    static class MyQueue<T> {
        //插入栈
        private Stack<T> stack1 = new Stack<>();
        //弹出栈
        private Stack<T> stack2 = new Stack<>();

        public void appendTail(T t) {
            stack1.add(t);
        }

        public T deleteHead() {
            //判断弹出栈是否为空，若为空则将插入栈的所有数据弹出插入栈
            //并且将弹出的数据压入弹出栈
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.add(stack1.pop());
                }
            }
            //如果弹出栈中还没有数据就抛出异常
            if (stack2.isEmpty()) {
                throw new RuntimeException("No more element");
            }
            return stack2.pop();
        }
    }

    //两个队列实现栈
    static class MyStack<T> {
        private Queue<T> queue1 = new LinkedBlockingQueue<>();
        private Queue<T> queue2 = new LinkedBlockingQueue<>();

        public void appendTail(T t) {
            if (queue2.isEmpty()) {
                queue1.add(t);
            } else {
                queue2.add(t);
            }
        }

        public T deleteTail() {
            if (queue2.isEmpty() && queue1.isEmpty()) {
                throw new RuntimeException("No more element");
            }
            if (queue1.isEmpty()) {
                int size = queue2.size() -1;
                for (int i=0;i<size;i++) {
                    queue1.add(queue2.poll());
                }
                return queue2.poll();
            }
            if (queue2.isEmpty()) {
                int size = queue1.size() -1;
                for (int i=0;i<size;i++) {
                    queue2.add(queue1.poll());
                }
                return queue1.poll();
            }
            return null;
        }

    }
}

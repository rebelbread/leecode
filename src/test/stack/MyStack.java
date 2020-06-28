package test.stack;


/**
 * @author zhiwj
 * @Description:
 * @date 2020-06-26 13:34
 */
public class MyStack<T> {

    private int maxSize;

    private int top;

    private Object[] arr;

    public MyStack(int maxSize) {
        this.maxSize = maxSize;
        this.top = -1;
        this.arr = new Object[maxSize];
    }

    public void push(T num) {
        if (top == maxSize - 1) {
            throw new RuntimeException("满了啊");
        }
        arr[++top] = num;
    }

    public T pop() {
        if (top == -1) {
            throw new RuntimeException("没了啊");
        }
        T t = (T) arr[top];
        arr[top] = null;
        top--;
        return t;
    }

    public T peek() {
        if (top == -1) {
            throw new RuntimeException("没了啊");
        }
        return (T) arr[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

}

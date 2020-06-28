package test.stack;

/**
 * @author zhiwj
 * @Description:
 * @date 2020-06-26 16:46
 */
public class Tran {

    public static void main(String[] args) {
        // 中缀表达式转后缀

        // 多位数和小数点的话 其实就是用双指针去分割 为了方便这里只写了单位数的
        String exp = "1+((2+3)*4)-5";
        // 1 2 3 + 4 * + 5 -
        char[] expArr = exp.toCharArray();

        MyStack stack1 = new MyStack(100);
        MyStack stack2 = new MyStack(100);

        for (int i = 0; i < expArr.length; i++) {
            char c = expArr[i];
            if (c >= '0' && c <= '9') {
                stack2.push(c);
            } else if (stack1.isEmpty() || (char)stack1.peek() == '(') {
                stack1.push(c);
            } else if (c == ')') {
                whenBrackets(stack1, stack2);
            } else if (getPriority((char) stack1.peek()) < getPriority(c)) {
                stack1.push(c);
            } else if (getPriority((char) stack1.peek()) >= getPriority(c)) {
                whenPriority(stack1, stack2, c);
            }
        }

        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        print(stack2);

    }

    private static void print(MyStack stack2) {
        while (!stack2.isEmpty()) {
            Object pop = stack2.pop();
            print(stack2);
            System.out.print(pop + "\t");
        }
    }

    private static void whenPriority(MyStack stack1, MyStack stack2, char c) {
        boolean b = (char) stack1.peek() != '(';
        boolean b1 = getPriority((char) stack1.peek()) >= getPriority(c);
        while (!stack1.isEmpty() && (char)stack1.peek() != '(' && getPriority((char) stack1.peek()) >= getPriority(c)) {
            stack2.push(stack1.pop());
        }
        stack1.push(c);
    }

    private static void whenBrackets(MyStack stack1, MyStack stack2) {
        while ((char)stack1.peek() != '(') {
            stack2.push(stack1.pop());
        }
        stack1.pop();
    }


    public static int getPriority(char c) {
        if (c == '+' || c == '-') {
            return 1;
        } else {
            return 2;
        }
    }

}

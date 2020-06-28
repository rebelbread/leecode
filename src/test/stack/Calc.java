package test.stack;

/**
 * @author zhiwj
 * @Description:
 * @date 2020-06-26 14:17
 */
public class Calc {
    public static void main(String[] args) {
        String calc =  "7*2*2-5+1*5+3-4";

        MyStack<Integer> numStack = new MyStack<>(10);
        MyStack<Character> symbolStack = new MyStack<>(10);

        for (int i = 0; i < calc.length(); i++) {
            char c = calc.charAt(i);
            if (c >= '0' && c <= '9') {
                numStack.push(c - '0');
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                if (symbolStack.isEmpty()) {
                    symbolStack.push(c);
                } else {
                    Character symbol = symbolStack.peek();
                    if (getPriority(symbol) >= getPriority(c)) {
                        calcOnce(numStack, symbolStack);
                    }
                    symbolStack.push(c);
                }
            } else {
                throw new RuntimeException();
            }
        }

        while (!symbolStack.isEmpty()) {
            calcOnce(numStack, symbolStack);
        }

        System.out.println(numStack.pop());

    }

    private static void calcOnce(MyStack<Integer> numStack, MyStack<Character> symbolStack) {
        Integer a = numStack.pop();
        Integer b = numStack.pop();
        Character symbol = symbolStack.pop();

        Integer result;

        switch (symbol) {
            case '+': result = b + a; break;
            case '-': result = b - a; break;
            case '*': result = b * a; break;
            case '/': result = b / a; break;
            default: throw  new RuntimeException();
        }
        numStack.push(result);
    }

    public static int getPriority(char c) {
        if (c == '+' || c == '-') {
            return 1;
        } else {
            return 2;
        }
    }

}

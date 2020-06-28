package test.stack;

/**
 * @author zhiwj
 * @Description:
 * @date 2020-06-26 15:42
 */
public class PolandNotation {

    public static void main(String[] args) {
        //        (3 + 4 ) * 5 - 6  ------->   3 4 + 5 * 6 -
        String exp = "3 4 + 5 * 6 -";
        String[] arr = exp.split("\\s+");

        MyStack<Integer> numStack = new MyStack<>(10);

        for (String s : arr) {
            if (s.matches("[0-9]+")) {
                // 是数字
                numStack.push(Integer.valueOf(s));
            } else {
                Integer a = numStack.pop();
                Integer b = numStack.pop();
                Integer result;
                switch (s) {
                    case "+": result = b + a; break;
                    case "-": result = b - a; break;
                    case "*": result = b * a; break;
                    case "/": result = b / a; break;
                    default: throw  new RuntimeException();
                }
                numStack.push(result);
            }
        }

        System.out.println(numStack.pop());
    }

}

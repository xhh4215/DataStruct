public class Main {
    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();
        // 入栈的测试
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }
        // 出栈的测试
        stack.pop();
        System.out.println(stack);

    }
}

package com.macro.mall;

/**
 * @program: Sunline App Server
 * @author: ShyBlue
 * @create: 2020-06-16 10:01
 **/


/**
 * // 1. 不需要参数,返回值为 5
 * () -> 5
 * <p>
 * // 2. 接收一个参数(数字类型),返回其2倍的值
 * x -> 2 * x
 * <p>
 * // 3. 接受2个参数(数字),并返回他们的差值
 * (x, y) -> x – y
 * <p>
 * // 4. 接收2个int型整数,返回他们的和
 * (int x, int y) -> x + y
 * <p>
 * // 5. 接受一个 string 对象,并在控制台打印,不返回任何值(看起来像是返回void)
 * (String s) -> System.out.print(s)
 * <p>
 * Lambda 表达式，也可称为闭包，它是推动 Java 8 发布的最重要新特性。
 * Lambda 允许把函数作为一个方法的参数（函数作为参数传递进方法中）。
 */
public class Java8Tester {

    /**
     * lambda 表达式的语法格式如下：
     * (parameters) -> expression
     * 或
     * (parameters) ->{ statements; }
     * <p>
     * 可选类型声明：不需要声明参数类型，编译器可以统一识别参数值。
     * 可选的参数圆括号：一个参数无需定义圆括号，但多个参数需要定义圆括号。
     * 可选的大括号：如果主体包含了一个语句，就不需要使用大括号。
     * 可选的返回关键字：如果主体只有一个表达式返回值则编译器会自动返回值，大括号需要指定明表达式返回了一个数值
     *
     * @param args
     */
    public static void main(String[] args) {
        Java8Tester tester = new Java8Tester();

        // 类型声明
        MathOperation addition = (int a, int b) -> {
            System.out.println("哈哈哈哈");
            return a+b;
        };

        // 不用类型声明
        MathOperation subtraction = (a, b) -> a - b;

        // 大括号中的返回语句
        MathOperation multiplication = (int a, int b) -> {
            return a * b;
        };
        // 没有大括号及返回语句
        MathOperation division = (int a, int b) -> a / b;


        MathOperation additionJava = new MathOperation() {
            @Override
            public int operation(int a, int b) {
                return a + b;
            }
        };


        System.out.println(tester.operate(10, 5, additionJava));
        System.out.println(tester.operate(10, 5, new MathOperation() {
            @Override
            public int operation(int a, int b) {
                return a + b;
            }
        }));

        System.out.println(tester.operate(10, 5, addition));
        System.out.println(tester.operate(10, 5, subtraction));


        new GreetingService() {
            @Override
            public void sayMessage(String message) {
                System.out.println("Hello " + message);
            }
        }.sayMessage("Google");


        ((GreetingService) message -> System.out.println("Hello " + message)).sayMessage("Apple");

        GreetingService service = new GreetingService() {
            @Override
            public void sayMessage(String message) {
                System.out.println("Hello " + message);
            }
        };

        service.sayMessage("Runoob");

        GreetingService greetingService = message -> System.out.println("Hello " + message);
        GreetingService greetingService2 = (message) -> System.out.println("Hello " + message);
        GreetingService greetingService3 = (message) -> {
            System.out.println("Hello " + message);
        };

    }

    interface MathOperation {
        int operation(int a, int b);
    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }


    interface GreetingService {
        void sayMessage(String message);
    }
}
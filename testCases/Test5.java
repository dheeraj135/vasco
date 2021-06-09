public class Test5 {
    public static void main(String[] args) {
        performTask1();
        performTask2();
        performTask3();
    }
    static void performTask1() {
        Factorial fact = new Factorial();
        int x = fact.calculate(6);
    }

    static void performTask2() {
        Fibbonacci fib = new Fibbonacci();
        int y = fib.calculate(7);
    }

    static void performTask3() {
        Node nd = new Node();
        int z = nd.second(10);
    }
}

class Node {
    public int op(int a, int b) {
        if (a<b)
            return a*b;
        else
            return a+b;
    }
    public int second(int a) {
        return this.op(a, 2222222);
    }
}


class Factorial{
    int calculate(int x) {
        if (x==1) 
            return 1;
        return x*calculate(x-1);
    }
}

class Fibbonacci {
    int calculate(int x) {
        if (x==0)
            return 1;
        else if (x==1)
            return 1;
        return calculate(x-1) + calculate(x-2);
    }
}
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

public class Test2 {
    public static void main(String[] args) {
        Node a= new Node();
        int val1 = 1000000;
        int val2 = 100000;
        int x2 = a.op(val1, val2);
        int x3 = a.op(-111111, -222222);
        int x4 = a.second(111112);
        int x5 = a.op(0,0);
        int x6 = a.op(0,2);
    }
}
public class Test4 {
    public static int infiniteRecur(int a) {
        if (a==0)
           return 0;
        return infiniteRecur(a-1);
    }
    public static void main(String[] args) {
        int a = 1000000;
        int x = infiniteRecur(a);
    }
}

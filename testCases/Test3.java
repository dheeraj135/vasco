public class Test3 {
	static int P, Q, R;
	
	public static void main(String... args) {
		int p = 100000;
		// int q = f(p, -3);
        // int r = g(-q);
        P = p;
        int x = recurNeg(p);
        int a = staticField(p);
        P = -p;
        int b = staticField(p);
        int y = recurNeg(-p);
        int c = staticField(0);
    }
    

	
	static int returnNeg() {
        return -1;
    }

    static int recurNeg(int a) {
        if (a < 0) {
            return a * returnNeg();
        }
        return -1;
    }

    static int staticField(int p) {
        return p*P;
    }
}

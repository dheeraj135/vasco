public class Test1{
    static int P, Q, R;
	
	public static void main(String... args) {
        int x = -55000;
		int p = five(x);
		int q = process(x, p);
		int l = q*p;
		x += l;
    }
    
    public static int neg() {
        return -1;
    }
	
	public static int five(int a) {
        return 5;
	}
	
	public static int process(int a, int b) {
		if (a < 0) {
			int x = process(b, a);
			return x;
		}
		return 1;
	}

}

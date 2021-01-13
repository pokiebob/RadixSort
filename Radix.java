public class Radix {

	public static int nth(int n, int col) {
		String number = "" + n;
		return Character.getNumericValue(number.charAt(number.length() - col - 1));
	}

	public static int length(int n) {
		String number = "" + Math.abs(n);
		return number.length();
	}

	public static void main(String[] args) {
		System.out.println(nth(123, 1));
		System.out.println(nth(-123, 1));
		System.out.println(nth(123, 2));
		System.out.println(nth(123, 2));

		System.out.println(length(0));
		System.out.println(length(15));
		System.out.println(length(-10));
		System.out.println(length(5112));
	}

}
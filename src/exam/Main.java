//1번 문제

package exam;

public class Main {
	public static void main(String [] args) {
		int 가로=3;
		int 세로=4;
		
		별구하기(세로,가로);

	}
	
	public static void 별구하기(int a, int b) {
		System.out.println(b +" "+a);
		
		for(int i=0; i<a; i++) {
			for (int j=0; j<b; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}


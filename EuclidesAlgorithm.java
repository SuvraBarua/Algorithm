import java.util.Scanner;

public class EuclidesAlgorithm{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		int b = input.nextInt();
		System.out.println(euclide(a, b));
	}
	public static int euclide(int a, int b){
		if(a == 0)
			return b;
		if(b == 0)
			return a;
		if(a > b)
			return euclide(b, a%b);
		return euclide(a, b%a);
	}
}
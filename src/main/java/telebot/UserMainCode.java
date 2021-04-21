package telebot;
import java.util.Scanner;
class UserMainCode {
    public static double nthterm(double input1, double input2, int input3)
    {
        double[] arr = new double[input3+1];
        double cd = input2 / input1;
        double firstterm = input1 / input2;
        double sum = firstterm;
        arr[0] = firstterm;
        for(int i = 1;i < input3;i++)
        {
            arr[i] = arr[i-1] * cd;
            sum += arr[i];
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double input1 = sc.nextDouble();  
        double input2 = sc.nextDouble();  
        int input3 = sc.nextInt();  
        System.out.println(nthterm(input1, input2, input3));
    }
}

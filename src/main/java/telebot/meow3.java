package telebot;
import java.util.Scanner;
public class meow3 {
    static Scanner sc = new Scanner(System.in);
    public static void factors()
    {
        System.out.print("Enter a number : ");
        int num = sc.nextInt();
        int[] arr = new int[num];
        for(int i = 1;i < num;i++)
        {
            if(num % i == 0) {arr[i] = i;}
        }
        System.out.print("Factors of "+num+" is : ");
        for(int i = 0;i < arr.length;i++)
        {
            if(arr[i] != 0) {System.out.print(arr[i]+" ");}
        }
    }
    public static void Factorial()
    {
        System.out.print("Enter a number : ");
        int num = sc.nextInt();
        int res = 1;
        for(int i = num;i >= 1;i--)
        {
            res *= i;
        }
        System.out.println("Factorial of "+num+" is : "+res);
    }
    public static void main(String[] args) {
        System.out.println("1. Factors of a number");
        System.out.println("2. Factorial of a nmber");
        System.out.print("Enter your choice : ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                factors();
                break;
            case 2:
                Factorial();
                break;
            default:
                System.out.println("Wrong Choice !!");
                break;
        }
    }
}

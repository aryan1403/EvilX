package telebot;
import java.util.Scanner;
public class meow1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        int[] marks;
        String[] name;
        int[] rno;
        int[] marks1;
        int[] marks2;
        System.out.print("Enter the Number of Students : ");
        int n = sc.nextInt();
        name = new String[n];
        marks = new int[n];
        marks1 = new int[n];
        marks2 = new int[n];
        rno  = new int[n];
        for(int i = 0;i < n;i++)
        {
            System.out.print("Enter the Name of "+(i+1)+" Student : ");
            name[i] = sc1.nextLine();
            System.out.print("Enter the Roll no. of "+(i+1)+" Student : ");
            rno[i] = sc.nextInt();
            System.out.print("Enter the Marks of 1 Subject : ");
            marks[i] = sc.nextInt();
            System.out.print("Enter the Marks of 2 Subject : ");
            marks1[i] = sc.nextInt();
            System.out.print("Enter the Marks of 3 Subject : ");
            marks2[i] = sc.nextInt();
        }
        int total = 0;
        for(int i = 0;i < n;i++)
        {
            total += marks[i] + marks2[i] + marks1[i];
        }
        double average = total/3;
        if(average < 40) System.out.println("POOR");
        else if(average >= 40 && average < 60) System.out.println("PASS");
        else if(average >= 60 && average < 75) System.out.println("FIRST CLASS");
        else if(average >= 75 && average < 85) System.out.println("DISTINCTION");
        else if(average >= 85 && average <= 100) System.out.println("EXCELLENT");
    }
}

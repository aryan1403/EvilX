package telebot;
import java.util.Scanner;
public class meow4 {
    public static int breakandcount(String name)
    {
        int counter = 0;
        int length = name.length();
        for(int i = 0;i < length;i++)
        {
            counter += (int)(name.charAt(i));
        }
        return counter;
    }
    public static void main(String[] args) {
        String[] arr = new String[20];
        Scanner sc = new Scanner(System.in);
        for(int i = 0;i < 20;i++)
        {
            System.out.print("Enter "+i+" String : ");
            arr[i] = sc.nextLine();
        }
        for(int i = 0;i < 20;i++)
        {
            for(int j = 0;j < 20 - i;j++)
            {
                int counter1 = breakandcount(arr[i]);
                int counter2 = breakandcount(arr[j]);
                if(counter1 < counter2)
                {
                    String temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        for(int i = 0;i < 20;i++)
        {
            System.out.println(arr[i]);
        }
    }
}

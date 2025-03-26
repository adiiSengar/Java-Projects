
import java.util.Random;
import java.util.Scanner;

class Exercise_2_Game
{
    public static void main(String s[])
    {

        System.out.println("1 for Rock, 2 for Paper, 3 for Scissor");
        
        for (int i = 1; i <= 3; i++) {
            System.out.println("Round " + i + ":");

        

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your choice: ");
        int a = sc.nextInt();

        switch(a)
        {
            case 1:
            System.out.println("Rock");
            break;

            case 2:
            System.out.println("Paper");
            break;

            case 3:
            System.out.println("Scissor");
            break;

            default:
            System.out.println("Invalind Input!");
        }

        Random rd = new Random();
        System.out.println("Computer's Answer: ");
        int x = rd.nextInt(1,4);
        System.out.println(x);

        switch(x)
        {
            case 1:
            System.out.println("Rock");
            break;

            case 2:
            System.out.println("Paper");
            break;

            case 3:
            System.out.println("Scissor");
            break;

            default:
            System.out.println("Invalind Input!");
        }

        if(a==1 && x==2)
        {
            System.out.println("Comp won!");
        }else if(a==2 && x==3)
        {
            System.out.println("Comp won!");
        }else if(a==3 && x == 1)
        {
            System.out.println("Comp won!");
        }else if(a==1 && x==3)
        {
            System.out.println("You won!");
        }else if(a==2 && x==1)
        {
            System.out.println("You won!");
        }else if (a==3 && x==2)
        {
            System.out.println("You won!");
        }else if(a==x)
        {
            System.out.println("Tie!");
        }else
        {
            System.out.println("entered numbers between 1-3...");
        }


    }
    }
}


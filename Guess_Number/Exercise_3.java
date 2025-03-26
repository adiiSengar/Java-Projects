import java.util.Random;
import java.util.Scanner;

class Game{
    public int number;
    public int inputnum;
    public int noOfGuesses = 0;

    public int getnoOfGuesses(){
        return noOfGuesses;
    }
    public void setnoOfGuesses(int noOfGuesses){
        this.noOfGuesses = noOfGuesses;
    }
    Game(){
        Random rand = new Random();
        this.number = rand.nextInt(100);
    }
    void takeInput(){
        System.out.println("Guess Number...");
        Scanner sc = new Scanner(System.in);
        this.inputnum = sc.nextInt();
    }
    boolean isCorrectNumber(){
        noOfGuesses++;
        if(inputnum==number){
            System.out.format("You guessed right! it was %d\nYou guessed in %d attempts.", number, noOfGuesses);
            return true;
        }else if(inputnum<number){
            System.out.println("Too low...");
        }else if(inputnum>number){
            System.out.println("Too high...");
        }
        return false;
    } 
}

public class Exercise_3{
    public static void main(String[] args){
        

        Game g = new Game();
        boolean b = false;
        while(!b){
        g.takeInput();
        b = g.isCorrectNumber();
        }

    }
}
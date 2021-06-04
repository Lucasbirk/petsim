package lucasbirk;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        //Setting name and gender to nothing so the user can define them.
        String name = "", gender = "";
        //Setting each int to default at 0 as each case messed with these values.
        int input = 0, hunger = 0, hygine = 0, fun = 0, health = 0, tries = 0, love = 0, age = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Welcome to cat simulator.\n");
        //Makes the name the next line entered by user.
        System.out.print("Enter your cats name!" + "\n");
        name = br.readLine();
        System.out.print("Great! \n");
        //Delay between text.
        Thread.sleep(800);
        //Sets the gender of the animal by the string given from the next line.
        System.out.print("Enter the cats gender!\n");
        gender = br.readLine();
        //Sets the age of the animal.
        System.out.print("Enter the cats age!\n");
        int ageinput = Integer.parseInt(br.readLine());
        //Checks if the animals age is too old to physically exist in the world.
        if(ageinput > 12) {
            System.out.print("I'm so sorry, the cat died on site.");
            System.exit(0);
        } else {
            //If everything is good, then set the age to the inputed age.
            age = ageinput;
        }

        do {
            //Displays the stats of the animal and the main menu.
            displayStats(name, hunger, hygine, fun, health, love);
            DisplayMenu(name);
            System.out.print("Input");
            input = Integer.parseInt(br.readLine());
            switch(input) {
                //If the input is 1, then the animal gets fed.
                case 1:
                    System.out.print(name + " is fed.\n");
                    hunger +=2;
                    hygine -=1;
                    fun -=1;
                    health +=1;
                    love +=3;
                    break;
                case 2:
                    //If the input is 2 then the anime gets affection
                    System.out.print("You gave " + name + " affection!");
                    hunger -=1;
                    hygine -=3;
                    fun +=3;
                    health -=2;
                    love +=4;
                    break;
                case 3:
                    //If the input is 3 the animal gets a bath.
                    System.out.print("You gave " + name + " a bath!");
                    hygine +=3;
                    fun -=1;
                    health +=3;
                    love -=2;
                    break;
                case 4:
                    //If the imput is 4, then the animal gets played with
                    System.out.print("You played with " + name);
                    hygine -=3;
                    fun +=3;
                    health +=2;
                    love += 3;
                    break;
                case 5:
                    //If the input is 5, then the animal gets chemotherapy.
                    System.out.print("You gave " + name + " chemotherapy!");
                    hunger -=1;
                    hygine -=1;
                    fun -=4;
                    health +=10;
                    love -=5;
                    break;
                case 6:
                    //If the input is 6 then the animal is put down.
                    System.out.print("Putting down " + name + "\n");
                    Thread.sleep(1300);
                    System.out.print("A little hesitation...\n");
                    Thread.sleep(1500);
                    System.out.print("The deed is done.\n");
                    Thread.sleep(800);
                    health -=10000;
                    break;
                case 7:
                    //Exits the application.
                    System.exit(0);
                default:
                    //Invalid input.
                    System.out.print("invalid\n");
                    break;
            }

        }while(checkNeed(name, age, hunger, hygine, fun, health, love) == false);
    }

    //Displays the menu
    public static void DisplayMenu(String name) {
        System.out.print("[1] Feed " + name + "\n" +
                "[2] Give " + name + " affection\n" +
                "[3] Wash " + name + " \n" +
                "[4] Play with " + name + "\n" +
                "[5] Give " + name + " chemo! \n" +
                "[6] Put " + name + " down!\n" +
                "[7] Exit\n");
    }

    //Displays the updated stats of the anima.
    public static void displayStats(String name, int hunger, int hygine, int fun, int health, int love) {
        System.out.print(name + " stats: Hunger: " + hunger + " Hygine: " + hygine + " Fun: " + fun
                + " Health: " + health + " Love: " + love + "\n");
    }

    //Checks weither or not the needs have depleted. If so then they die and prints out a reason.
    public static boolean checkNeed(String name, int age, int hunger, int hygine, int fun, int health, int love) {
        if(hunger < -7 || hygine < -7 || fun < -7 || health < -7 || love < -7) {
            System.out.print("\nYou killed your cat.\n");
            if(hunger < -7) {
                System.out.print(name + " died from starvation! They were "  + age + " years old\n");
            }
            if(hygine < -7) {
                System.out.print(name + " died from being too dirty!! They were "+ age + " years old\n");
            }
            if(fun < -7 || love < -7) {
                System.out.print(name + " died from depression! They were "+ age + " years old\n");
            }
            if(health < -7) {
                System.out.print(name + " died from natural causes They were "+ age + " years old\n" );
            }

            return true;
        }
        return false;
    }
}
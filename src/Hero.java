/**
 * Created by Luke on 8/24/2016.
 */
import java.util.Random;
import java.util.Scanner;

public class Hero {

    public String name;
    public int armor;
    public int accuracy;
    public int hp;
    public int strength;
    public int intelligence;
    public int damage;
    public boolean defend;

    public static int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) +1) + min;
        return randomNum;
    }

    public int attack(int strength) {
        damage = (strength*2)+1;
        return damage;
    }

    public int magic(int magic) {
        damage = (magic*3)-(magic/2);
        return damage;
    }

    public boolean defend() { //HAVE MONSTER LOOK AT TARGET TO SEE IF HERO.DEFEND = TRUE. IF IT IS, DAMAGE = DAMAGE/4
        defend=true;
        return defend;
    }

    public void run() { // SET BATTLE END TEST CASE IF SUCCESSFUL
        if (randInt(1,3) == 2) {
            System.out.print(" got away.\n\n");
        } else {
            System.out.print(" was not able to escape\n\n");
        }

    }

    public void heroStats(String name, int hp, int strength, int armor, int accuracy, int intelligence) {
        System.out.println("== " + name + "'S STATS ==\n\n\tHP : " + hp + "\n\tStrength : " + strength + "\n\tArmor : " + armor + "\n\tAccuracy: " + accuracy + "\n\tIntelligence: " + intelligence + "\n\n");
    }

    public void heroCommands (String name) {
        System.out.println("It is the " + name + "'s turn. You can use ATTACK, MAGIC, DEFEND, or RUN. Please input your action now. (case sensitive)\n");
    }

    public void heroTurn(String name, int hp, int strength, int armor, int accuracy, int intelligence) {
        Scanner input = new Scanner(System.in);
        boolean testCase1;

        heroCommands(name);
        heroStats(name, hp, strength, armor, accuracy, intelligence);

        do {
            defend = false;
            String action = input.next();
            switch (action) {
                case "ATTACK":
                    attack(strength);
                    System.out.println("\n" + name + " Swung their weapon and did " + attack(strength) + " damage.\n");
                    testCase1 = true;
                    break;
                case "MAGIC":
                    magic(intelligence);
                    System.out.println("\n" + name + " Cast a spell and did " + magic(intelligence) + " damage.\n");
                    testCase1 = true;
                    break;
                case "DEFEND":
                    defend();
                    System.out.println("\n" + name + " is defending...\n");
                    testCase1 = true;
                    break;
                case "RUN": //MAKE SURE RUN IS PULLING NEW NUMBER EVERY TIME
                    System.out.println("\n" + name + " is attempting to run away...");
                    System.out.print(name);
                    run();
                    testCase1 = true;
                    break;
                default:
                    testCase1 = false;
                    System.out.println("That was not valid input. Enter your command again please.");
            }
        } while (!testCase1);
    }

    public Hero(String name, int strength, int armor, int accuracy, int intelligence, int hp) {
        this.name=name;
        this.strength=strength;
        this.armor=armor;
        this.accuracy=accuracy;
        this.intelligence=intelligence;
        this.hp=hp;
    }
}
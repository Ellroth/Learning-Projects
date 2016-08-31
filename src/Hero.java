/**
 * Created by Luke on 8/24/2016.
 */
import java.util.Random;
import java.util.Scanner;

public class Hero {

    public String getName() {
        return name;
    }
    public int getArmor() {
        return armor;
    }
    public int getAccuracy() {
        return accuracy;
    }
    public int getRemainingHp() {
        return remainingHp;
    }
    public int getTotalHp() {
        return totalHp;
    }
    public int getStrength() {
        return strength;
    }
    public int getIntelligence() {
        return intelligence;
    }
    public int getDamage() {
        return damage;
    }
    public boolean isDefend() {
        return defend;
    }
    public boolean isHeroStatus() {
        return heroStatus;
    }


    public void setName(String name) {
        this.name = name;
    }
    public void setArmor(int armor) {
        this.armor = armor;
    }
    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }
    public void setRemainingHp(int remainingHp) {
        this.remainingHp = remainingHp;
    }
    public void setStrength(int strength) {
        this.strength = strength;
    }
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public void setDefend(boolean defend) {
        this.defend = defend;
    }
    public void setHeroStatus(boolean heroStatus) {
        this.heroStatus = heroStatus;
    }

    private String name;
    private int armor;
    private int accuracy;
    private int strength;
    private int intelligence;
    private int damage;
    private int totalHp;
    private int remainingHp;
    private boolean defend;
    private boolean heroStatus;


    public static int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) +1) + min;
        return randomNum;
    }

    public int attack(int strength) {
        damage = (strength*2)+1;
        return damage;
    }

    public int magic(int intelligence) {
        damage = (intelligence*3)-(intelligence/2);
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

    public boolean heroStatus() {
        if (remainingHp == 0) {
            heroStatus = false;
        }
        else {
            heroStatus = true;
        }
        return heroStatus;
    }

    public void heroStats(String name, int remainingHp, int strength, int armor, int accuracy, int intelligence) {
        System.out.println("== " + name + "'S STATS ==\n\n\tHP : " + remainingHp + "\n\tStrength : " + strength + "\n\tArmor : " + armor + "\n\tAccuracy: " + accuracy + "\n\tIntelligence: " + intelligence + "\n\n");
    }

    public void heroCommands (String name) {
        System.out.println("It is the " + name + "'s turn. You can use ATTACK, MAGIC, DEFEND, or RUN. Please input your action now. (case sensitive)\n");
    }

    public void heroTurn(String name, int remainingHp, int strength, int armor, int accuracy, int intelligence) {
        Scanner input = new Scanner(System.in);
        boolean testCase1;

        heroStats(name, remainingHp, strength, armor, accuracy, intelligence);
        heroCommands(name);

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
                case "RUN":
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

    public void takeDamage(int tempDamage) {

        remainingHp = (remainingHp - (tempDamage/armor));

        if (remainingHp <= 0) {
            setRemainingHp(0);
        }
    }

    public Hero(String name, int strength, int armor, int accuracy, int intelligence, int totalHp) {
        this.name=name;
        this.strength=strength;
        this.armor=armor;
        this.accuracy=accuracy;
        this.intelligence=intelligence;
        this.totalHp=totalHp;
    }
}
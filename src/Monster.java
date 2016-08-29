import java.util.Random;

/**
 * Created by Luke on 8/24/2016.
 */
public class Monster {

    private String name;
    private int armor;
    private int accuracy;
    private int hp;
    private int strength;
    private int intelligence;
    private int damage;
    private int heroNumber;
    private int target;

    public String getName() {
        return name;
    }
    public int getArmor() {
        return armor;
    }
    public int getAccuracy() {
        return accuracy;
    }
    public int getHp() {
        return hp;
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
    public int getHeroNumber() {
        return heroNumber;
    }
    public int getTarget() {
        return target;
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
    public void setHp(int hp) {
        this.hp = hp;
    }
    public void setStrength(int strength) {
        this.strength = strength;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }
    public void setTarget(int target) {
        this.target = target;
    }

    public void setHeroNumber(int heroNumber) {
        this.heroNumber = heroNumber;
    }

    public static int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public Monster(String name) {
        this.name=name;
        this.hp=randInt(1000,1500);
        this.armor=randInt(1,80); // number = % reduction
        this.accuracy=randInt(1,50); // hit chance% = 100 - accuracy.
    }

    public void target() {
        setHeroNumber(randInt(1,4));

        switch(heroNumber) {
            case 1: target = 1;
            case 2: target = 2;
            case 3: target = 3;
            case 4: target = 4;
        }


    }

    public Monster (String name, int armor, int accuracy, int hp, int strength, int intelligence) {
        this.name=name;
        this.armor=armor;
        this.accuracy=accuracy;
        this.hp=hp;
        this.strength=strength;
        this.intelligence=intelligence;


    }
}

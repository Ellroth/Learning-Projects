import java.util.Random;

/**
 * Created by Luke on 8/24/2016.
 */
public class Monster {

    private String name;
    private String monsterAction;
    private int armor;
    private int accuracy;
    private int totalHp;
    private int remainingHp;
    private int strength;
    private int intelligence;
    private int damage;
    private int heroNumber;
    private int target;
    private int monsterMove;
    private boolean monsterStatus;

    public String getName() {
        return name;
    }
    public String getMonsterAction() {
        return monsterAction;
    }
    public int getArmor() {
        return armor;
    }
    public int getAccuracy() {
        return accuracy;
    }
    public int getTotalHp() {
        return totalHp;
    }
    public int getRemainingHp() {
        return remainingHp;
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
    public int getMonsterMove() {
        return monsterMove;
    }
    public boolean getMonsterStatus() {
        return monsterStatus;
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
    public void setTotalHp(int totalHp) {
        this.totalHp = totalHp;
    }
    public void setRemainingHp(int remainingHp) {
        this.remainingHp=remainingHp;
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
    public void isMonsterStatus(boolean monsterStatus) {
        this.monsterStatus=monsterStatus;
    }
    public void setMonsterMove(int monsterMove) {
        this.monsterMove=monsterMove;
    }
    public void setMonsterAction(String monsterAction) {
        this.monsterAction=monsterAction;
    }

    public boolean monsterStatus() {
        if (remainingHp == 0) {
            monsterStatus = false;
        }
        else {
            monsterStatus = true;
        }
        return monsterStatus;
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
        this.totalHp=randInt(1000,1500);
        this.armor=randInt(1,80); // number = % reduction
        this.accuracy=randInt(1,50); // hit chance% = 100 - accuracy.
        this.strength=randInt(1,150);
        this.intelligence=randInt(1,150);
    }

    public void takeDamage(int tempDamage) {

        remainingHp = (remainingHp - tempDamage);
        if (remainingHp < 0) {
            remainingHp = 0;
        }
    }

    public void target() {
        setHeroNumber(randInt(1,4));

        switch(heroNumber) {
            case 1:
                target = 1;
                break;
            case 2:
                target = 2;
                break;
            case 3:
                target = 3;
                break;
            case 4:
                target = 4;
                break;
        }


    }

    public void monsterTurn() {  // KEEPS GOING TO CASE 3 EVERY TIME.
        monsterMove=randInt(1,11);
        switch (monsterMove) {
            case 1: case 2:case 3: case 4: case 5: //basic attack
                damage = (strength*2)+1;
                monsterAction="bruteForce()";
                break;
            case 6: case 7: case 8: case 9: case 10: //magic attack
                damage = (intelligence*3)-(intelligence/2);
                monsterAction="stackOverflow()";
                break;
            case 11: //heal
                int healed = randInt(50,200);
                remainingHp = remainingHp+healed;
                System.out.println(name + " ran debug() and healed for " + healed + ".");
                break;
        }
    }

    public void monsterStats() {
        System.out.println("\n\n==== BOSS ====\n");
        System.out.println("== " + name + "'S STATS ==\n\n\tHP : " + remainingHp + "\n\tStrength : " + strength + "\n\tArmor : " + armor + "\n\tAccuracy: " + accuracy + "\n\tIntelligence: " + intelligence + "\n\n");
    }

    public void damageArmorModify (int tempDamage, int armor) {
        damage = tempDamage / armor;
    }

}
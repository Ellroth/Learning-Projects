/**
 * Created by Luke on 8/24/2016.
 */
//test for commit/push

public class Battle {

    public static void main(String[] args) {

        Hero hero1 = new Hero("WARRIOR", 15, 15, 7, 3, 250);
        Hero hero2 = new Hero("BLACK MAGE", 3 , 5, 8, 15, 100);
        Hero hero4 = new Hero("RANGER", 10 , 8, 12, 5, 175);
        Hero hero3 = new Hero("WHITE MAGE", 3 , 5, 5, 12, 150);
        Monster monster1 = new Monster("CODETHULUH");
        final String BATTLE_INTRO = "Welcome to battle sim. You have a party of 4 heroes that have just encountered the final boss. It is up to you to save the world!";

        System.out.println(BATTLE_INTRO);
        do{
            hero1.heroTurn(hero1.getName(), hero1.getHp(), hero1.getStrength(), hero1.getArmor(), hero1.getAccuracy(), hero1.getIntelligence());
            hero2.heroTurn(hero2.getName(), hero2.getHp(), hero2.getStrength(), hero2.getArmor(), hero2.getAccuracy(), hero2.getIntelligence());
            hero3.heroTurn(hero3.getName(), hero3.getHp(), hero3.getStrength(), hero3.getArmor(), hero3.getAccuracy(), hero3.getIntelligence());
            hero4.heroTurn(hero4.getName(), hero4.getHp(), hero4.getStrength(), hero4.getArmor(), hero4.getAccuracy(), hero4.getIntelligence());
        } while (monster1.getHp() != 0);
    }
}

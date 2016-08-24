/**
 * Created by Luke on 8/24/2016.
 */

public class Battle {

    public static void main(String[] args) {

        Hero hero1 = new Hero("WARRIOR", 15, 15, 7, 3, 250);
        Hero hero2 = new Hero("BLACK MAGE", 3 , 5, 8, 15, 100);
        Hero hero4 = new Hero("RANGER", 10 , 8, 12, 5, 175);
        Hero hero3 = new Hero("WHITE MAGE", 3 , 5, 5, 12, 150);
        Monster monster1 = new Monster("CODETHULHU", 1000);
        final String BATTLE_INTRO = "Welcome to battle sim. You have a party of 4 heroes that have just encountered the final boss. It is up to you to save the world!";

        System.out.println(BATTLE_INTRO);
        do{
            hero1.heroTurn(hero1.name, hero1.hp, hero1.strength, hero1.armor, hero1.accuracy, hero1.intelligence);
            hero2.heroTurn(hero2.name, hero2.hp, hero2.strength, hero2.armor, hero2.accuracy, hero2.intelligence);
            hero3.heroTurn(hero3.name, hero3.hp, hero3.strength, hero3.armor, hero3.accuracy, hero3.intelligence);
            hero4.heroTurn(hero4.name, hero4.hp, hero4.strength, hero4.armor, hero4.accuracy, hero4.intelligence);
        } while (monster1.hp != 0);
    }
}

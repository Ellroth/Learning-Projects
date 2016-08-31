/**
 * Created by Luke on 8/24/2016.
 */

public class Battle {

    public static void main(String[] args) {

        Hero hero1 = new Hero("WARRIOR", 15, 15, 7, 3, 250);
        hero1.setRemainingHp(hero1.getTotalHp());
        Hero hero2 = new Hero("BLACK MAGE", 3, 5, 8, 15, 100);
        hero2.setRemainingHp(hero2.getTotalHp());
        Hero hero3 = new Hero("RANGER", 10, 8, 12, 5, 175);
        hero3.setRemainingHp(hero3.getTotalHp());
        Hero hero4 = new Hero("WHITE MAGE", 3, 5, 5, 12, 150);
        hero4.setRemainingHp(hero4.getTotalHp());
        Monster monster = new Monster("CODETHULUH");
        monster.setRemainingHp(monster.getTotalHp());
        final String BATTLE_INTRO = "Welcome to battle sim. You have a party of 4 heroes that have just encountered the final boss. It is up to you to save the world!";

        System.out.println(BATTLE_INTRO); // set test cases for hero hp= 0, if 0 skip hero turn
        do {
            if (monster.getRemainingHp() != 0) {
                monster.monsterStats();
                System.out.println("====HEROES====\n");
                hero1.heroTurn(hero1.getName(), hero1.getRemainingHp(), hero1.getStrength(), hero1.getArmor(), hero1.getAccuracy(), hero1.getIntelligence());
                monster.takeDamage(hero1.getDamage()); // heroes not taking the correct amount of damage
                hero2.heroTurn(hero2.getName(), hero2.getRemainingHp(), hero2.getStrength(), hero2.getArmor(), hero2.getAccuracy(), hero2.getIntelligence());
                monster.takeDamage(hero2.getDamage());
                hero3.heroTurn(hero3.getName(), hero3.getRemainingHp(), hero3.getStrength(), hero3.getArmor(), hero3.getAccuracy(), hero3.getIntelligence());
                monster.takeDamage(hero3.getDamage());
                hero4.heroTurn(hero4.getName(), hero4.getRemainingHp(), hero4.getStrength(), hero4.getArmor(), hero4.getAccuracy(), hero4.getIntelligence());
                monster.takeDamage(hero4.getDamage());

                System.out.println(monster.getName() + " has " + monster.getRemainingHp() + " hp remaining.");

            }
            if (hero1.heroStatus() && hero2.heroStatus() && hero3.heroStatus() && hero4.heroStatus() || monster.getRemainingHp() != 0) {
                monster.monsterTurn();
                if (monster.getMonsterMove() != 11) {
                    monster.target();
                    switch (monster.getTarget()) {
                        case 1:
                            hero1.takeDamage(monster.getDamage());
                            monster.damageArmorModify(monster.getDamage(), hero1.getArmor());
                            System.out.println(monster.getName() + " ran " + monster.getMonsterAction() + " and dealt damage for " + monster.getDamage() + " to " + hero1.getName() + ".");
                            break;
                        case 2:
                            hero2.takeDamage(monster.getDamage());
                            monster.damageArmorModify(monster.getDamage(), hero2.getArmor());
                            System.out.println(monster.getName() + " ran " + monster.getMonsterAction() + " and dealt damage for " + monster.getDamage() + " to " + hero2.getName() + ".");
                            break;
                        case 3:
                            hero3.takeDamage(monster.getDamage());
                            monster.damageArmorModify(monster.getDamage(), hero3.getArmor());
                            System.out.println(monster.getName() + " ran " + monster.getMonsterAction() + " and dealt damage for " + monster.getDamage() + " to " + hero3.getName() + ".");
                            break;
                        case 4:
                            hero4.takeDamage(monster.getDamage());
                            monster.damageArmorModify(monster.getDamage(), hero4.getArmor());
                            System.out.println(monster.getName() + " ran " + monster.getMonsterAction() + " and dealt damage for " + monster.getDamage() + " to " + hero4.getName() + ".");
                            break;
                    }
                }
            } else { System.out.println(monster.getTarget() + " is dead."); } // this is not properly catching that hero is dead. if target dead, re roll target
        }
        while (hero1.heroStatus() && hero2.heroStatus() && hero3.heroStatus() && hero4.heroStatus() || monster.getRemainingHp() != 0);
        System.out.println(monster.getName() + " is dead! You win!!");
    }

}

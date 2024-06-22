import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

abstract class Creature {
    String name;
    int health;


    public Creature(String name, int health) {
        this.name = name;
        this.health = health;
    }


    public abstract void attack(List<String> list,String player_name);

    public abstract int takeDamage(int player_health,int damageValue,String player_name);

    public int getHealth() {
        return health;
    }

}

interface Interactable{
    public void interact();
}

class Goblin extends Creature implements Interactable{
    int damage = 50;

    public Goblin(String name, int health) {
        super(name, health);
    }

    @Override
    public void attack(List<String> list,String player_name) {
       health = health - damage;

       if(list.contains("Weapon")){
           list.remove("Weapon");
           health = ((health<0) ? 0 : health);
           System.out.println(player_name + " used one weapon and now goblin health is : " + health);
           if (health<=0){
               System.out.println(player_name + " Defeated the Goblin");
           }
       }

       if (list.contains("Potion")){
           list.remove("Potion");
           health = ((health<0) ? 0 : health);
           System.out.println(player_name + " used one Potion and now goblin health is : " + health);
           if (health<=0){
               System.out.println(player_name + " Defeated the Goblin");
           }
       }

    }

    @Override
    public int takeDamage(int player_health,int damageValue,String player_name) {
        player_health = player_health - damageValue;
        player_health = ((player_health<0) ? 0 : player_health);
        System.out.println(player_name + " got attacked by Goblin and  " + player_name + " now your health is : " + player_health);
        if (player_health<=0){
            System.out.println(player_name + " got Defeated");
        }
        return player_health;
    }


    @Override
    public void interact() {
        System.out.println("Your in Goblin Room");
    }
}

class Dragon extends Creature implements Interactable{

    int damage = 100;

    public Dragon(String name, int health) {
        super(name, health);
    }

    @Override
    public void attack(List<String> list,String player_name) {
        health = health - 60;

        if(list.contains("Weapon")){
            list.remove("Weapon");
            health = ((health<0) ? 0 : health);
            System.out.println(player_name + " used one weapon and now Dragon health is : " + health);
            if (health<=0){
                System.out.println(player_name + " Defeated the Dragon");
            }
        }

        if (list.contains("Potion")){
            list.remove("Potion");
            health = ((health<0) ? 0 : health);
            System.out.println(player_name + " used one Potion and now Dragon health is : " + health);
            if (health<=0){
                System.out.println(player_name + " Defeated the Dragon");
            }
        }

    }

    @Override
    public int takeDamage(int player_health,int damageValue,String player_name) {
        player_health = player_health - damageValue;
        player_health = ((player_health<0) ? 0 : player_health);
        System.out.println(player_name + " got attacked by Dargon and " + player_name + " now Your health is : " + player_health);
        if (player_health<=0){
            System.out.println(player_name + " got Defeated");
        }
        return player_health;
    }

    @Override
    public void interact() {
        System.out.println("Your in Dragon Room");
    }
}

class  Player{

    public void displayNameHealth(String name,int health){
        System.out.println("Hero name : "+ name + " , Health : "+health);
    }

}

abstract class Item {
    public abstract void use();
}

class Potion extends Item {
    List<String> potion = new ArrayList<>();

    public void increment(){
        potion.add("Potion");
    }

    public List<String> potionSize(){
        return potion;
    }


    @Override
    public void use() {

    }
}
class Weapon extends Item{
    List<String> Weapon = new ArrayList<>();

    public void increment(){
        Weapon.add("Weapon");
    }

    public List<String> weaponSize(){
        return Weapon;
    }


    @Override
    public void use() {

    }
}


public class DungeonGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int player_health = 100;
        System.out.print("Enter the player name : ");
        String player_name = scanner.nextLine();
        Player player = new Player();
        player.displayNameHealth(player_name,player_health);

        Goblin goblin_class = new Goblin("Goblin",100);
        Dragon dragon_class = new Dragon("Dragon",150);

        Weapon weapon_class = new Weapon();
        Potion potion_class = new Potion();

        System.out.println("Type \"1\" to Enter into Room ");
        System.out.println("Type \"2\" to Exit the Room");
        int room_num = scanner.nextInt();

        boolean flag = true;

        while(flag){
            if(room_num == 1){

                int random_value = random.nextInt(2)+1;
                System.out.println("random value : " + random_value);
                if(random_value == 1){

                    if(player_health>0){
                        int enemy_value = random.nextInt(2)+1;
                        System.out.println("enemy value : "+enemy_value);
                        if(enemy_value == 1){
                            List<String> weapon_return = weapon_class.weaponSize();
                            List<String> potion_return = potion_class.potionSize();
                            if(!weapon_return.isEmpty() && goblin_class.health>0){
                                System.out.println(player_name +" Entered into the Goblin Room");
                                goblin_class.interact();
                                goblin_class.attack(weapon_return,player_name);
                            }else if(!potion_return.isEmpty() && goblin_class.health>0){
                                System.out.println(player_name +" Entered into the Goblin Room");
                                goblin_class.interact();
                                goblin_class.attack(potion_return,player_name);
                            }else if(weapon_return.isEmpty() && player_health>0){
                                System.out.println(player_name +" Entered into the Goblin Room");
                                goblin_class.interact();
                                player_health = goblin_class.takeDamage(player_health,50,player_name);
                            }else if(potion_return.isEmpty() && player_health>0){
                                System.out.println(player_name +" Entered into the Goblin Room");
                                goblin_class.interact();
                                player_health = goblin_class.takeDamage(player_health,50,player_name);
                            } else if (!weapon_return.isEmpty() && dragon_class.health>0 && player_health>0) {
                                System.out.println(player_name +"Your Entered into the Dragon Room");
                                dragon_class.interact();
                                dragon_class.attack(weapon_return,player_name);
                            } else if (!potion_return.isEmpty() && dragon_class.health>0 && player_health>0) {
                                System.out.println(player_name +" Entered into the Dragon Room");
                                dragon_class.interact();
                                dragon_class.attack(potion_return,player_name);
                            }
                        } else if (enemy_value == 2) {
                            List<String> weapon_return = weapon_class.weaponSize();
                            List<String> potion_return = potion_class.potionSize();
                            if(!weapon_return.isEmpty() && dragon_class.health>0){
                                System.out.println(player_name +" Entered into the Dragon Room");
                                dragon_class.interact();
                                dragon_class.attack(weapon_return,player_name);
                            }else if(!potion_return.isEmpty() && dragon_class.health>0){
                                System.out.println(player_name +" Entered into the Dragon Room");
                                dragon_class.interact();
                                dragon_class.attack(potion_return,player_name);
                            }else if(weapon_return.isEmpty() && player_health>0){
                                System.out.println(player_name +" Entered into the Dragon Room");
                                dragon_class.interact();
                                player_health = dragon_class.takeDamage(player_health,70,player_name);
                            } else if (potion_return.isEmpty() && player_health>0) {
                                System.out.println(player_name +" Entered into the Dragon Room");
                                dragon_class.interact();
                                player_health = dragon_class.takeDamage(player_health,70,player_name);
                            } else if (!weapon_return.isEmpty() && goblin_class.health>0 && player_health>0) {
                                System.out.println(player_name +" Entered into the Goblin Room");
                                goblin_class.interact();
                                goblin_class.attack(weapon_return,player_name);
                            }else if (!potion_return.isEmpty() && goblin_class.health>0 && player_health>0) {
                                System.out.println(player_name +" Entered into the Goblin Room");
                                goblin_class.interact();
                                goblin_class.attack(potion_return,player_name);
                            }
                        }
                    }else {
                        flag = false;
                        return;
                    }


                } else if (random_value == 2) {
                    int item_value = random.nextInt(2)+1;
                    System.out.println("Item value : "+item_value);
                    if(item_value == 1){
                        System.out.println(player_name +" got the Weapon");
                        weapon_class.increment();
                    } else if (item_value == 2) {
                        System.out.println(player_name +" got the Potion");
                        potion_class.increment();
                    }

                }

                if(player_health>0 && dragon_class.health<=0 && goblin_class.health<=0){
                    System.out.println(player_name +" won the Game");
                    flag = false;
                    break;
                } else if (player_health <=0) {
                    flag = false;
//                    System.out.println("You got defeated here");
                    break;
                }

            } else if (room_num==2) {
                System.out.println(player_name + " are leaving the Room");
                flag = false;
                break;
            }

            System.out.println("Type \"1\" to Again Enter into Room ");
            System.out.println("Type \"2\" to Exit the Room");
            room_num = scanner.nextInt();

        }

//        System.out.println(potion_class.potionSize());
//        System.out.println(weapon_class.weaponSize());


    }
}

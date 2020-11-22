package app;

import java.util.*;

public class LolCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter minute of game and next how much gold you need: ");
        new LolCalculator().LoLCalculator(sc.nextInt(),sc.nextInt());
    }

    public void LoLCalculator(int minuteInGame, int goldNeed){
        System.out.println("Minute " + minuteInGame);
        System.out.println("Gold " + goldNeed);

        int meleeMinion = 21;
        int casterMinion = 14;

        if(minuteInGame < 0 || goldNeed < 0) {
            System.out.println("Enter correct numbers");
        }
        else{
            int numberOfMelee = goldNeed / meleeMinion;
            int meleeMinionChange = goldNeed % meleeMinion;
            int numberOfCaster = goldNeed / casterMinion;
            int casterMionionChange = goldNeed % casterMinion;

            if(meleeMinionChange != 0 || casterMionionChange != 0){
                System.out.println("You need to kill " + (numberOfMelee + 1) + " fighter Minions or "
                        + (numberOfCaster + 1) + " caster Minions to get at least " + goldNeed + "\n");
            } else {
                System.out.println("You need to kill " + numberOfMelee + " fighter Minions or "
                        + numberOfCaster + " caster Minions to get at least " + goldNeed + "\n");
            }

            if(minuteInGame < 15) {
                int siegeMinion = 60;
                int goldPerWave = meleeMinion * 3 + casterMinion * 3 + siegeMinion / 3;
                int howManyWaves =  goldNeed /goldPerWave;
                System.out.println("Gold per wave (3 melee Minions, 3 caster Minions and 1 siege Minion every 3 waves) - " +
                        goldPerWave + " gold");


                if(goldPerWave % goldNeed == 0) {
                    System.out.println("You need to kill " + howManyWaves + " to get at least " + goldNeed);
                } else {
                    System.out.println("You need to kill " + (howManyWaves + 1) + " to get at least " + goldNeed);
                }
            }
            else if(minuteInGame <= 17) {
                int siegeMinion = 84;
                int goldPerWave = meleeMinion * 3 + casterMinion * 3 + siegeMinion / 2;
                int howManyWaves = goldNeed / goldPerWave;
                System.out.println("Gold per wave (3 melee Minions, 3 caster Minions and 1 siege Minion every 2 waves) - " +
                        goldPerWave + " gold");

                if(goldPerWave % goldNeed == 0) {
                    System.out.println("You need to kill " + howManyWaves + " to get at least " + goldNeed);
                } else {
                    System.out.println("You need to kill " + (howManyWaves + 1) + " to get at least " + goldNeed);
                }
            }
            else if(minuteInGame < 25) {
                int siegeMinion = 90;
                int goldPerWave = meleeMinion * 3 + casterMinion * 3 + siegeMinion /2;
                int howManyWaves = goldNeed /goldPerWave;
                System.out.println("Gold per wave (3 melee Minions, 3 caster Minions and 1 siege Minion every 2 waves) - " +
                        goldPerWave + " gold");

                if(goldPerWave % goldNeed == 0) {
                    System.out.println("You need to kill " + howManyWaves + " to get at least " + goldNeed);
                } else {
                    System.out.println("You need to kill " + (howManyWaves + 1) + " to get at least " + goldNeed);
                }
            }
            else if(minuteInGame > 25) {
                int siegeMinion = 90;
                int goldPerWave = meleeMinion * 3 + casterMinion * 3 + siegeMinion;
                int howManyWaves = goldNeed /goldPerWave;
                System.out.println("Gold per wave (3 melee Minions, 3 caster Minions and 1 siege Minion every wave) - " +
                        goldPerWave + " gold");

                if(goldPerWave % goldNeed == 0) {
                    System.out.println("You need to kill " + howManyWaves + " to get at least " + goldNeed);
                } else {
                    System.out.println("You need to kill " + (howManyWaves + 1) + " to get at least " + goldNeed);
                }
            }
        }
    }
}

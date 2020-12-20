package pl.pjwstk.lab3;

import java.util.*;

public class LolCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter minute of game and next how much gold you need: ");
        new LolCalculator().LoLCalculator(sc.nextInt(),sc.nextInt());

        System.out.println("Enter jungle clear type (FullClear, Top, Bot, None): ");
        new LolCalculator().JungleCampGold(sc.next());
    }

    public int LoLCalculator(int minuteInGame, int goldNeed){
        System.out.println("Minute " + minuteInGame);
        System.out.println("Gold " + goldNeed);

        int meleeMinion = 21;
        int casterMinion = 14;

        if(minuteInGame < 0 || goldNeed < 0) {
            System.out.println("Enter correct numbers");
            return -1;
        }
        else{
            int numberOfMelee = goldNeed / meleeMinion;
            int meleeMinionChange = goldNeed % meleeMinion;
            int numberOfCaster = goldNeed / casterMinion;
            int casterMionionChange = goldNeed % casterMinion;

            if(meleeMinionChange != 0 || casterMionionChange != 0){
                System.out.println("You need to kill " + (numberOfMelee + 1) + " fighter Minions or "
                        + (numberOfCaster + 1) + " caster Minions to get at least " + goldNeed + "\n");
                int wavesWithoutSiege = (numberOfMelee + 1)/3;
                System.out.println("Without siege waves: " + wavesWithoutSiege + "\n");
            } else {
                System.out.println("You need to kill " + numberOfMelee + " fighter Minions or "
                        + numberOfCaster + " caster Minions to get at least " + goldNeed + "\n");
                int wavesWithoutSiege = (numberOfMelee + 1)/3;
                System.out.println("Without siege waves: " + wavesWithoutSiege + "\n");
            }

            if(minuteInGame < 15) {
                int siegeMinion = 60;
                int goldPerWave = meleeMinion * 3 + casterMinion * 3 + siegeMinion / 3;
                int howManyWaves =  goldNeed /goldPerWave;
                System.out.println("Gold per wave (3 melee Minions, 3 caster Minions and 1 siege Minion every 3 waves) - " +
                        goldPerWave + " gold");

                if(goldPerWave % goldNeed == 0) {
                    System.out.println("You need to kill " + howManyWaves + " waves to get at least " + goldNeed + "\n");
                    return howManyWaves;
                } else {
                    System.out.println("You need to kill " + (howManyWaves + 1) + " waves to get at least " + goldNeed + "\n");
                    return  (howManyWaves+1);
                }
            }
            else if(minuteInGame <= 17) {
                int siegeMinion = 84;
                int goldPerWave = meleeMinion * 3 + casterMinion * 3 + siegeMinion / 2;
                int howManyWaves = goldNeed / goldPerWave;
                System.out.println("Gold per wave (3 melee Minions, 3 caster Minions and 1 siege Minion every 2 waves) - " +
                        goldPerWave + " gold");

                if(goldPerWave % goldNeed == 0) {
                    System.out.println("You need to kill " + howManyWaves + " to waves get at least " + goldNeed + "\n");
                    return howManyWaves;
                } else {
                    System.out.println("You need to kill " + (howManyWaves + 1) + " waves to get at least " + goldNeed + "\n");
                    return (howManyWaves+1);
                }
            }
            else if(minuteInGame < 25) {
                int siegeMinion = 90;
                int goldPerWave = meleeMinion * 3 + casterMinion * 3 + siegeMinion /2;
                int howManyWaves = goldNeed /goldPerWave;
                System.out.println("Gold per wave (3 melee Minions, 3 caster Minions and 1 siege Minion every 2 waves) - " +
                        goldPerWave + " gold");

                if(goldPerWave % goldNeed == 0) {
                    System.out.println("You need to kill " + howManyWaves + " waves to get at least " + goldNeed + "\n");
                    return howManyWaves;
                } else {
                    System.out.println("You need to kill " + (howManyWaves + 1) + " waves to get at least " + goldNeed + "\n");
                    return (howManyWaves+1);
                }
            }
            else if(minuteInGame > 25) {
                int siegeMinion = 90;
                int goldPerWave = meleeMinion * 3 + casterMinion * 3 + siegeMinion;
                int howManyWaves = goldNeed /goldPerWave;
                System.out.println("Gold per wave (3 melee Minions, 3 caster Minions and 1 siege Minion every wave) - " +
                        goldPerWave + " gold");

                if(goldPerWave % goldNeed == 0) {
                    System.out.println("You need to kill " + howManyWaves + " waves to get at least " + goldNeed + "\n");
                    return howManyWaves;
                } else {
                    System.out.println("You need to kill " + (howManyWaves + 1) + " waves to get at least " + goldNeed + "\n");
                    return (howManyWaves+1);
                }
            }
        }
        return -1;
    }

    public int JungleCampGold(String clearType) {
        int raptorGold = 85;
        int murkWolvesGold = 85;
        int krugsGold = 135;
        int grompGold = 105;
        int blueGold = 100;
        int redGold = 100;

        switch (clearType) {
            case "FullClear":
                int fullClearGold = raptorGold + murkWolvesGold + krugsGold + grompGold + blueGold + redGold;
                System.out.println("Doing full clear in jungle would give you: " + fullClearGold + " gold.\n");

                return fullClearGold;

            case "Top":
                int topClearGold = murkWolvesGold + grompGold + blueGold;
                System.out.println("Doing top clear in jungle would give you: " + topClearGold + " gold.\n");

                return topClearGold;

            case "Bot":
                int botClearGold = raptorGold + krugsGold + redGold;
                System.out.println("Doing bot clear in jungle would give you: " + botClearGold + " gold.\n");

                return botClearGold;

            case "None":
                System.out.println("You are not clearing any jungle camps.\n");

                return 0;

            default:
                System.out.println("Wrong selection");
                return -1;
        }

    }
}

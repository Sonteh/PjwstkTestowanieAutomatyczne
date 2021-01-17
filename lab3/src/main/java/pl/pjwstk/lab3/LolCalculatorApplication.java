package pl.pjwstk.lab3;

public class LolCalculatorApplication {
    private LolCalculator lolService;

    public void setLolCalculatorService(LolCalculator lolService){
        this.lolService = lolService;
    }

    public int lolcalculator(int input1, int input2){
        return lolService.LoLCalculator(input1, input2);
    }

    public int junglecampgold(String input1){
        return lolService.JungleCampGold(input1);
    }
}

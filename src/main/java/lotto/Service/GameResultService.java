package lotto.Service;

import lotto.Enum.LottoResult;
import lotto.Lotto;
import lotto.Player;
import lotto.Validator.LottoValidator;

public class GameResultService {
    private int matchThree = 0;
    private int matchFour = 0;
    private int matchFiveWithoutBonus = 0;
    private int matchFiveWithBonus = 0;
    private int matchSix = 0;
    private int totalAmount = 0;

    private void incrementThreeMatch(){
        this.matchThree++;
        this.totalAmount += LottoResult.THREE.getMoney();
    }
    private void incrementFourMatch(){
        this.matchFour++;
        this.totalAmount += LottoResult.FOUR.getMoney();
    }

    private void incrementSixMatch(){
        this.matchSix++;
        this.totalAmount += LottoResult.SIX.getMoney();
    }
    private void setFiveMatch(Player player, int lotto, Lotto winningLotto, int bonusNumber){
        if(player.matchesBonus(lotto, winningLotto, bonusNumber)){
            matchFiveWithBonus++;
            this.totalAmount += LottoResult.FIVE_WITH_BONUS.getMoney();
        }
        else {
            matchFiveWithoutBonus++;
            this.totalAmount += LottoResult.FIVE_WITH_NO_BONUS.getMoney();
        }
    }
    public void calculateResult(Player player, Lotto winningLotto, int bonusNumber){
        for(int lotto = 0; lotto < player.getLottoSize(); lotto++){
            int result = player.matchCountWithWinnings(lotto, winningLotto);

            if(result == 3)
                incrementThreeMatch();
            else if(result == 4)
                incrementFourMatch();
            else if (result == 5)
                setFiveMatch(player, lotto, winningLotto, bonusNumber);
            else if (result == 6)
                incrementSixMatch();
        }
    }

    private double getRateOfReturn(int input, int output){
        return (double)output/input * 100;
    }

    public void printResult(int input) {
        GameResultOutputService.printOutputStatement();
        GameResultOutputService.printThreeMatch(this.matchThree);
        GameResultOutputService.printFourMatch(this.matchFour);
        GameResultOutputService.printFiveWithoutBonus(this.matchFiveWithoutBonus);
        GameResultOutputService.printFiveWithBonus(this.matchFiveWithBonus);

        GameResultOutputService.printRateOfReturn(this.getRateOfReturn(input, this.totalAmount));
    }



}

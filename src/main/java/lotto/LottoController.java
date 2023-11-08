package lotto;

import java.util.List;

import static lotto.InputView.*;
import static lotto.OutputView.*;

public class LottoController {

    private float lottoProfit;
    private float profitRate;
    private float money;
    private int matchedThreeProfit = 0 ;
    private int matchedFourProfit = 0 ;
    private int matchedFiveProfit = 0 ;
    private int matchedFiveAndBonusNumber = 0 ;
    private int matchedSixProfit = 0 ;

    private LottoPurchaseSystem lottoPurchase = new LottoPurchaseSystem();
    private LottoWinningSystem lottoWinning = new LottoWinningSystem();
    private LottoRandomSystem lottoRandom = new LottoRandomSystem();

    public void lottoStart() {
        lottoPurchase.setMoney(inputMoney());
        lottoPurchase.calculateLottoAmount();
        printPurchaseQuantity(lottoPurchase.lottoAmount);
        lottoRandom.generateLottoNumbers();
        printRandomLottoNumbers();
        lottoWinning.winningNumber(inputWinningNumber());
        lottoWinning.bonusNumber(inputBonusNumber());
        lottoWinning.winningStatics(lottoWinning.winningCheck(lottoRandom.getRandomLottoNumbers()));
        printWinningStatics();
    }

    public void printWinningStatics() {
        printResults();
        printMatchesThreeNumber(lottoWinning.matchesThreeNumber);
        printMatchesFourNumber(lottoWinning.matchesFourNumber);
        printMatchesFiveNumber(lottoWinning.matchesFiveNumber);
        printMatchesFiveAndBonusNumber(lottoWinning.matchesFiveAndBonusNumber);
        printMatchesSixNumber(lottoWinning.matchesSixNumber);
        sumLottoProfit();
        calculateprofitRate();
        printProfitRate(profitRate);
    }

    public void printRandomLottoNumbers() {
        List<List<Integer>> lottonumbers = lottoRandom.getRandomLottoNumbers();
        for(List<Integer> number : lottonumbers){
            System.out.println(number);
        }
    }

    public void sumLottoProfit() {
        matchedThreeProfit = lottoWinning.matchesThreeNumber * 5000;
        matchedFourProfit = lottoWinning.matchesFourNumber * 50000;
        matchedFiveProfit = lottoWinning.matchesFiveNumber * 1500000;
        matchedFiveAndBonusNumber = lottoWinning.matchesFiveAndBonusNumber * 30000000;
        matchedSixProfit = lottoWinning.matchesSixNumber * 2000000000;

        this.lottoProfit = matchedThreeProfit + matchedFourProfit + matchedFiveProfit +
                matchedFiveAndBonusNumber + matchedSixProfit;
    }
    public void calculateprofitRate() {
        this.money = lottoPurchase.getMoney();
        this.profitRate = (float)(lottoProfit/ money * 100);
    }

}

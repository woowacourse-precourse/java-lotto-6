package lotto;

import java.util.List;

import static lotto.InputView.*;
import static lotto.OutputView.*;

public class LottoController {

    private int lottoProfit;
    private int matchedThreeProfit;
    private int matchedFourProfit;
    private int matchedFiveProfit;
    private int matchedFiveAndBonusNumber;
    private int matchedSixProfit;

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
        lottoWinning.winningStatics(lottoWinning.winningCheck());
        printWinningStatics();
    }

    public void printWinningStatics() {
        printResults();
        printMatchesThreeNumber(lottoWinning.matchesThreeNumber);
        printMatchesFourNumber(lottoWinning.matchesFourNumber);
        printMatchesFiveNumber(lottoWinning.matchesFiveNumber);
        printMatchesFiveAndBonusNumber(lottoWinning.matchesFiveAndBonusNumber);
        printMatchesSixNumber(lottoWinning.matchesSixNumber);
        printProfitRate(calculateprofitRate());
    }

    public void printRandomLottoNumbers() {
        List<List<Integer>> lottonumbers = lottoRandom.getRandomLottoNumbers();
        for(List<Integer> number : lottonumbers){
            System.out.println(number);
        }
    }

    public int sumLottoProfit() {
        matchedThreeProfit = lottoWinning.matchesThreeNumber * 5000;
        matchedFourProfit = lottoWinning.matchesFourNumber * 50000;
        matchedFiveProfit = lottoWinning.matchesFiveNumber * 1500000;
        matchedFiveAndBonusNumber = lottoWinning.matchesFiveAndBonusNumber * 30000000;
        matchedSixProfit = lottoWinning.matchesSixNumber * 2000000000;
        return matchedThreeProfit + matchedFourProfit + matchedFiveProfit +
                matchedFiveAndBonusNumber + matchedSixProfit;
    }
    public int calculateprofitRate() {
        return sumLottoProfit() / lottoPurchase.getMoney();
    }

}

package lotto.view;

import lotto.domain.WinResult;
import lotto.util.WinnerRank;

import java.text.NumberFormat;
import java.util.List;

import static lotto.util.ProgramMessage.*;

public class OutputView {
    public void printMoneyInputGuideMessage() {
        System.out.println(MONEY_INPUT_GUIDE_MESSAGE.getMessage());
    }

    public void printLottoAmount(int lottoAmount) {
        System.out.printf(PURCHASE_LOTTO_NUM_MESSAGE.getMessage(), lottoAmount);
    }

    public void printUserLottos(int lottoAmount, List<Integer> userLotto) {
        while (lottoAmount > 0) {
            System.out.println(userLotto.toString());
            lottoAmount--;
        }
    }

    public void printWinLottoNumbersInputGuide() {
        System.out.println(WIN_LOTTO_NUMBER_INPUT_GUIDE_MESSAGE.getMessage());
    }

    public void printBonusNumbersInputGuide() {
        System.out.println(BONUS_NUMBER_INPUT_GUIDE_MESSAGE.getMessage());
    }

    public void printWinningResultGuideMessage() {
        System.out.println(WIN_RESULT_GUIDE_MESSAGE.getMessage());
    }

    public void printWinResult(WinResult winResult) {
        for(WinnerRank winnerRank : WinnerRank.values()){
            int key = winnerRank.getValue();
            System.out.printf(WIN_RESULT.getMessage(),
                    winnerRank.getSameNumberCount(),
                    formatNumberWithCommas(winnerRank.getPrizeMoney()),
                    winResult.getWinResultValue(key));
        }
    }

    private static String formatNumberWithCommas(int winMoney) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        String winMoneyComma = numberFormat.format(winMoney);

        return winMoneyComma;
    }

    public void printProfit(double profit) {
        System.out.printf(PROFIT_MESSAGE.getMessage(), profit);
    }
}

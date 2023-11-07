package lotto.view;

import lotto.domain.WinResult;
import lotto.util.WinnerRank;

import java.text.NumberFormat;
import java.util.List;

import static lotto.util.LottoNumber.LOTTO_SAME_NUMBER_FIVE_WITH_BONUS_KEY;
import static lotto.util.ProgramMessage.*;

public class OutputView {
    public void printMoneyInputGuideMessage() {
        System.out.println(MONEY_INPUT_GUIDE_MESSAGE.getMessage());
    }

    public void printLottoAmount(int lottoAmount) {
        System.out.printf(PURCHASE_LOTTO_NUM_MESSAGE.getMessage(), lottoAmount);
    }

    public void printUserLottos(List<Integer> userLotto) {
        System.out.println(userLotto.toString());
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
            int key = winnerRank.getRankKey();

            System.out.printf(returnWinResultByRankKey(key),
                    winnerRank.getSameNumberCount(),
                    formatNumberWithCommas(winnerRank.getPrizeMoney()),
                    winResult.getWinResultValue(key));
        }
    }

    private String returnWinResultByRankKey(int rankKey) {
        if(rankKey == LOTTO_SAME_NUMBER_FIVE_WITH_BONUS_KEY.getValue()){
            return WIN_RESULT_WITH_BONUS.getMessage();
        }
        return WIN_RESULT_WITHOUT_BONUS.getMessage();
    }

    private String formatNumberWithCommas(int winMoney) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        String winMoneyComma = numberFormat.format(winMoney);

        return winMoneyComma;
    }

    public void printProfitRate(String profitRate) {
        System.out.printf(PROFIT_RATE_MESSAGE.getMessage(), profitRate);
    }
}

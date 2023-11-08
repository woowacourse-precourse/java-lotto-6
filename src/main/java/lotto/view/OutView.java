package lotto.view;

import static lotto.constants.LottoConstants.DIVIDER;
import static lotto.constants.LottoConstants.MAXIMUM_VALUE;

import java.util.List;
import java.util.Map;
import lotto.constants.LottoCount;
import lotto.constants.LottoMsg;

public class OutView {

    public void randomLottoOutView(List<Integer> lottoNumbers) {
        System.out.println(lottoNumbers);
    }

    public void lottoPriceView(int divisionLottoPrice) {
        System.out.println(String.format(LottoMsg.LOTTO_PRICE_COUNT.getMsg(), divisionLottoPrice));
    }

    public void lottoCommonNumberView(String winningOrBonus) {
        System.out.println();
        System.out.println(String.format(LottoMsg.LOTTO_COMMON_MSG.getMsg(), winningOrBonus));
    }

    public void winnersMsg(List<Map<Integer, Integer>> finalLottoWinner, int lottoBuyerPrice) {
        System.out.println(LottoMsg.LOTTO_RESULT.getMsg());
        System.out.println(DIVIDER);
        lottoWinnerMsg(finalLottoWinner, lottoBuyerPrice);
    }

    private void lottoWinnerMsg(List<Map<Integer, Integer>> lottoWinner, int lottoBuyerPrice) {
        for (Map<Integer, Integer> winner : lottoWinner) {
            countMatchesAndIncrementLottoCount(winner);
        }
        showAllLotto();
        showLateMsg(lottoBuyerPrice);
    }

    public void showAllLotto() {
        for (LottoCount lotto : LottoCount.values()) {
            System.out.println(
                    String.format(LottoMsg.LOTTO_MATCH_FORMAT.getMsg(), lotto.getPriceMsg(), lotto.getMatChesCount()));
        }
    }

    private void showLateMsg(int lottoBuyerPrice) {
        int getAllSumMultiple = 0;
        for (LottoCount lottoCount : LottoCount.values()) {
            getAllSumMultiple += lottoCount.getMultiple();
        }
        String showMsg = String.format(LottoMsg.LOTTO_LATE.getMsg(),
                ((double) getAllSumMultiple / (double) lottoBuyerPrice) * MAXIMUM_VALUE);
        System.out.println(showMsg);
    }

    private void countMatchesAndIncrementLottoCount(Map<Integer, Integer> winner) {
        for (Map.Entry<Integer, Integer> winnerMatches : winner.entrySet()) {
            int lottoMatchesCount = winnerMatches.getKey();
            int lottoBonus = winnerMatches.getValue();
            getLottoCountByCount(lottoMatchesCount, lottoBonus);
        }
    }

    private void getLottoCountByCount(int lottoMatchesCount, int bonus) {
        for (LottoCount lottoCount : LottoCount.values()) {
            lottoCountIncrement(lottoCount, lottoMatchesCount, bonus);
            lottoCount.calculateTotalPrizeAmount();
        }
    }

    private void lottoCountIncrement(LottoCount lottoCount, int lottoMatchesCount, int bonus) {
        if (lottoCount.getCount() == lottoMatchesCount) {
            lottoCount.incrementMatchesCount();
        }
    }
}
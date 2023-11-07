package lotto.view;

import static lotto.constants.LottoConstants.DIVIDER;
import static lotto.constants.LottoConstants.END;
import static lotto.constants.LottoConstants.FORMMATER_COUNT_BONUS;
import static lotto.constants.LottoConstants.FORMMATER_COUNT_SEVEN;
import static lotto.constants.LottoConstants.FORMMATER_COUNT_SIX;
import static lotto.constants.LottoConstants.RATE_PERCENT;
import static lotto.constants.LottoConstants.START;
import static lotto.utils.LottoUtils.getPriceForIntegerParser;
import static lotto.utils.LottoUtils.rateFormat;

import java.util.List;
import java.util.Map;
import lotto.constants.LottoCount;
import lotto.constants.LottoMsg;

public class OutView {

    private static final int WHILE_START_COUNT = 0;
    private static final int MAP_CONTAINS_COUNT = 0;
    private static final int TOTAL_RATE_MSG_CHECK_COUNT = 0;
    private static String PRICE = "0";
    private static final String BLANK = "";

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

    public void totalRateMsg(int lottoBuyerPrice) {
        if (PRICE.equals(String.valueOf(lottoBuyerPrice))) {
            System.out.println(String.format(LottoMsg.LOTTO_LATE.getMsg(), PRICE + RATE_PERCENT));
        }
        if (!PRICE.equals(String.valueOf(lottoBuyerPrice))) {
            rateFormat((double) getPriceForIntegerParser(PRICE) / (double) lottoBuyerPrice);
        }
    }


    public void winnersMsg(Map<Integer, Integer> finalLottoWinner, int lottoBuyerPrice) {
        System.out.println(LottoMsg.LOTTO_RESULT.getMsg());
        System.out.println(DIVIDER);
        winnerFormat(finalLottoWinner);
        totalRateMsg(lottoBuyerPrice);
    }

    private void winnerFormat(Map<Integer, Integer> map) {
        int cnt = WHILE_START_COUNT;
        String result = BLANK;
        while (START <= END) {
            cnt += mapContainsCount(map);
            resultMsg(cnt);
            START++;
            cnt = 0;
        }
    }

    public void resultMsg(int cnt) {
        String resultMsg = String.format(matchRetry(START), bonusCount(START), LottoCount.matchingPrice(START), cnt);
        System.out.println(resultMsg);
    }

    private int bonusCount(int start) {
        if (start == FORMMATER_COUNT_SIX) {
            return FORMMATER_COUNT_BONUS;
        }
        if (start == FORMMATER_COUNT_SEVEN) {
            return FORMMATER_COUNT_SIX;
        }
        return start;
    }

    private String matchRetry(int start) {
        String retryFormat = LottoMsg.LOTTO_MATCH_FORMAT.getMsg();
        if (start == FORMMATER_COUNT_SIX) {
            retryFormat = LottoMsg.LOTTO_MATCH_FORMAT_BONUS.getMsg();
        }
        return retryFormat;
    }

    private int mapContainsCount(Map<Integer, Integer> map) {
        int count = MAP_CONTAINS_COUNT;
        if (map.containsKey(START)) {
            PRICE = LottoCount.matchingPrice(START);
            count++;
        }
        return count;
    }
}

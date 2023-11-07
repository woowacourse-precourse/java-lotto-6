package lotto.view;

import lotto.domain.LottoReward;
import lotto.domain.PurchasedLotto;

import java.util.Map;

import static lotto.constants.OutputConstants.*;

public class OutputView {
    public void purchaseLottoMessage() {
        System.out.println(PURCHASE_LOTTO_MESSAGE);
    }

    public void purchaseLottoCountMessage(Long lottoCount) {
        System.out.println(lottoCount + PURCHASE_LOTTO_COUNT_MESSAGE);
    }

    public void purchaseLottoNumbers(PurchasedLotto purchasedLotto) {
        System.out.println(purchasedLotto.toString());
    }

    public void inputWinningNumbersMessage() {
        System.out.println(WINNING_NUMBERS_MESSAGE);
    }

    public void inputBonusNumberMessage() {
        System.out.println(BONUS_NUMBER_MESSAGE);
    }

    public void resultLotto(Map<LottoReward, Integer> reward, Double earnRate) {
        System.out.println(STATISTICS_HEADER);
        System.out.println(STATISTICS_DIVIDER);
        System.out.println(THIRD_PRIZE + reward.getOrDefault(LottoReward.FIFTH, DEFAULT_VALUE) + COUNT_UNIT);
        System.out.println(FOURTH_PRIZE + reward.getOrDefault(LottoReward.FOURTH, DEFAULT_VALUE) + COUNT_UNIT);
        System.out.println(SECOND_PRIZE + reward.getOrDefault(LottoReward.THIRD, DEFAULT_VALUE) + COUNT_UNIT);
        System.out.println(SECOND_PRIZE_BONUS_NOT_CORRECT + reward.getOrDefault(LottoReward.SECOND, DEFAULT_VALUE) + COUNT_UNIT);
        System.out.println(FIRST_PRIZE_MONEY + reward.getOrDefault(LottoReward.FIRST, DEFAULT_VALUE) + COUNT_UNIT);
        System.out.println(EARN_RATE_MESSAGE + earnRate + PERCENTAGE_FORMAT);
    }

    public void printExceptionMessage(String message) {
        System.out.println(message);
    }
}

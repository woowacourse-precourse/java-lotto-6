package lotto.view;

import lotto.domain.LottoReward;
import lotto.domain.PurchasedLotto;

import java.util.Map;

public class OutputView {
    private static final String PURCHASE_LOTTO_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";


    public void purchaseLottoMessage() {
        System.out.println(PURCHASE_LOTTO_MESSAGE);
    }

    public void purchaseLottoCountMessage(Integer lottoCount) {
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
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + reward.getOrDefault(LottoReward.FIFTH, 0) + "개");
        System.out.println("4개 일치 (30,000원) - " + reward.getOrDefault(LottoReward.FOURTH, 0) + "개");
        System.out.println("5개 일치, 보너스 불 일치 (1,500,000원) - " + reward.getOrDefault(LottoReward.THIRD, 0) + "개");
        System.out.println("5개 일치 (30,000,000원) - " + reward.getOrDefault(LottoReward.SECOND, 0) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + reward.getOrDefault(LottoReward.FIRST, 0) + "개");
        System.out.println("총 수익률은 " + earnRate + "%입니다.");
    }
}

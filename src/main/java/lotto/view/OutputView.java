package lotto.view;

import lotto.domain.PurchasedLotto;

public class OutputView {
    private static final String PURCHASE_LOTTO_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";


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
}

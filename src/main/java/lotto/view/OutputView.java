package lotto.view;

import lotto.model.Lotto;

public class OutputView {

    private static final String BUY_ANNOUNCE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_NUMBER_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";

    public static void printBuyAnnounce() {
        System.out.println(BUY_ANNOUNCE_MESSAGE);
    }

    public static void printLottoCount(int lottoCount) {
        System.out.println();
        System.out.println(lottoCount + LOTTO_COUNT_MESSAGE);
    }

    public static void printEachLotto(Lotto oneLotto) {
        System.out.println(oneLotto);
    }

    public static void printWinningNumberInputAnnounce() {
        System.out.println(WINNING_NUMBER_INPUT_MESSAGE);
    }
}

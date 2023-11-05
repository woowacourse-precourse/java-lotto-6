package lotto.view;

import java.util.List;

public class OutputView {
    private static final String INPUT_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_COUNT_MESSAGE = "\n%d개를 구매했습니다.";

    public static final void printInputAmountMessage() {
        System.out.println(INPUT_AMOUNT_MESSAGE);
    }

    public static final void printLottoCountMessage(int lottoCount) {
        System.out.println(String.format(LOTTO_COUNT_MESSAGE, lottoCount));
    }

    public static final void printLottos(List<Integer> lottoNumbers) {
        System.out.println(lottoNumbers);
    }
}

package lotto.view;

import lotto.domain.Lotto;

public class OutputView {
    private static final String BUY_LOTTO_COUNT_INFO = "%d개를 구매했습니다.%n";

    public static void outputLottoCount(int lottoCount) {
        System.out.printf(BUY_LOTTO_COUNT_INFO, lottoCount);
    }

    public static void outputIssuedLotto(Lotto lotto) {
        System.out.println(lotto);
    }
}

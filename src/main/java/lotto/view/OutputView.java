package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class OutputView {
    private static final String NUMBER_OF_LOTTO_MESSAGE = "개를 구매했습니다.";

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printBlank() {
        System.out.println();
    }

    public static void printNumberOfLotto(int lottoNumber) {
        System.out.println(lottoNumber + NUMBER_OF_LOTTO_MESSAGE);
    }

    public static void printLottos(Lottos lottos) {
        printBlank();
        printNumberOfLotto(lottos.numberOfLotto());
        lottos.printLottos();
    }
}

package lotto.domain.view;

import lotto.domain.Lottos;

public class OutputView {
    public static void showErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public static void showLottos(Lottos lottos) {
        System.out.println(lottos);
    }
}

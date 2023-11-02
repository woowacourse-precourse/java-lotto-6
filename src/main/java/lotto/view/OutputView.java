package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {

    private static final String NEW_LINE = "\n";
    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] %s"+NEW_LINE;
    private static final String PURCHASE_QUANTITY_MESSAGE_FORMAT = NEW_LINE+"%d개를 구매했습니다."+NEW_LINE;

    public static void errorMessage(IllegalArgumentException e) {
        System.out.printf(ERROR_MESSAGE_FORMAT,e.getMessage());
    }

    public static void quantityAndLottoNumbers(List<Lotto> userLottos) {
        System.out.printf(PURCHASE_QUANTITY_MESSAGE_FORMAT,userLottos.size());
        for (Lotto lotto : userLottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}

package lotto;

import lotto.controller.UnifiedController;
import lotto.view.SystemMessage;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        UnifiedController unifiedController = new UnifiedController();
        unifiedController.promptData(SystemMessage.ASK_MONEY);
        unifiedController.printLottoTicketsInfo();
        unifiedController.promptData(SystemMessage.ASK_WINNING_NUMBERS);
        unifiedController.promptData(SystemMessage.ASK_BONUS);
        unifiedController.printResult();
    }
}

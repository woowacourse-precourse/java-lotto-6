package lotto;

import lotto.controller.UnifiedController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        UnifiedController unifiedController = new UnifiedController();
        unifiedController.inputAndStoreMoney();
    }
}

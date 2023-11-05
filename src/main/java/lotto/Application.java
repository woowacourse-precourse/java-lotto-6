package lotto;

import lotto.controller.LottoGameController;

public class Application {
    private static final String ERROR_PREFIX = "[ERROR] ";

    public static void main(String[] args) {
        try {
            LottoGameController lottoGameController = new LottoGameController();
            lottoGameController.startGame();
        } catch (Exception e) {
            System.out.println(ERROR_PREFIX + e.getMessage());
        }

    }
}

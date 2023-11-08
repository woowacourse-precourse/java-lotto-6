package lotto;

import lotto.controller.LottoGameController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoGameController lottoGameController = new LottoGameController();

        try {
            lottoGameController.run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

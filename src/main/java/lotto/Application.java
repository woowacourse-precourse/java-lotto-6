package lotto;

import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        while (true) {
            try {
                LottoController lottoController = new LottoController();
                lottoController.run();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

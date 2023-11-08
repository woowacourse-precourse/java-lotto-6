package lotto;

import lotto.controller.LottoController;
import lotto.domain.Lotto;

public class Application {
    public static void main(String[] args) {
        try {
            LottoController lottoController = new LottoController();
            lottoController.start();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
package lotto;

import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            LottoController controller = new LottoController();
            controller.run();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

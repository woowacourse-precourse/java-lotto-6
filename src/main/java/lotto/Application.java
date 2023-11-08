package lotto;

import lotto.controller.LottoSystemController;

public class Application {
    public static void main(String[] args) {
        try {
            LottoSystemController.startLottoSystem();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

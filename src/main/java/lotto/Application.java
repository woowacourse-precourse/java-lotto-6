package lotto;

import lotto.Controller.LottogameController;

public class Application {
    public static void main(String[] args) {
        try {
            LottogameController lottogameController = new LottogameController();
            lottogameController.startLottoGame();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}

package lotto;

import controller.LottosController;

public class Application {

    private static final LottosController lottosController = new LottosController();
    public static void main(String[] args) {
        initLottos();
    }

    private static void initLottos(){
        lottosController.start();
    }
}

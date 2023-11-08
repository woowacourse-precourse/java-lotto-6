package lotto;

import lotto.controller.GameProcess;

public class Application {
    public static void main(String[] args) {
        GameProcess gameProcess = new GameProcess();

        gameProcess.buyLotto();
        gameProcess.publishLotto();
        gameProcess.enterWiningNumber();
        gameProcess.checkWiningResult();
    }
}

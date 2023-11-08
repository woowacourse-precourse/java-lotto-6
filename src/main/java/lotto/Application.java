package lotto;

import lotto.controller.GameProcess;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameProcess gameProcess = new GameProcess();
        gameProcess.buyLotto();
        gameProcess.publishLotto();
        gameProcess.enterWiningNumber();
        gameProcess.checkWiningResult();
    }
}

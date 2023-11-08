package lotto.controller;

import lotto.domain.Buyer;
import lotto.domain.DrawMachine;

public class GameController {
    Buyer buyer = new Buyer();
    DrawMachine drawMachine = new DrawMachine();

    public void run() {
        beforeDraw();
        Draw();
        afterDraw();
    }

    private void beforeDraw() {
        buyer.buyLotto();
    }

    private void Draw() {
        drawMachine.makeWinningNumbers();
        drawMachine.makeBonusNumber();
    }

    private void afterDraw() {
        // 당첨 통계 계산 후 출력
    }
}

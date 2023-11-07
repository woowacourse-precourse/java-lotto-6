package lotto.controller.handler;

import lotto.controller.user.BonusDraw;
import lotto.controller.user.LottoDraw;
import lotto.model.WinningNumber;
import lotto.view.InputView;

public class DrawHandler {
    private final InputView inputView;
    private WinningNumber winningNumber;

    public DrawHandler(InputView inputView) {
        this.inputView = inputView;
    }

    private void drawLottoNumber() {
        LottoDraw lottoDraw = new LottoDraw(inputView);
        lottoDraw.draw();
    }

    private void drawBounsNumber() {
        BonusDraw bonusDraw = new BonusDraw(inputView);
        bonusDraw.draw();
    }

    public void drarw() {
        drawLottoNumber();
        drawBounsNumber();
    }
}

package lotto.controller.handler;

import lotto.controller.user.BonusDraw;
import lotto.controller.user.LottoDraw;
import lotto.domain.Lotto;
import lotto.domain.WinningNumber;
import lotto.view.InputView;

public class DrawHandler {
    private static final String DUPLICATE_NUMBER = "당첨 번호와 중복 되지 않는 1~45사이의 수를 입력해 주세요.";
    private final InputView inputView;
    private WinningNumber winningNumber;

    public DrawHandler(InputView inputView) {
        this.inputView = inputView;
    }

    private Lotto drawLottoNumber() {
        LottoDraw lottoDraw = new LottoDraw(inputView);
        lottoDraw.draw();

        return lottoDraw.getLotto();
    }

    private void drawBounsNumber(Lotto lotto) {
        BonusDraw bonusDraw = new BonusDraw(inputView);
        int bonusNumber;

        while (true) {
            try {
                bonusDraw.draw();
                bonusNumber = bonusDraw.getBonusNumber();

                winningNumber = new WinningNumber(lotto, bonusNumber);
            } catch (IllegalArgumentException exception) {
                inputView.showInputErrorMessage(DUPLICATE_NUMBER);
                continue;
            }
            break;
        }
    }

    public void drarw() {
        Lotto lotto = drawLottoNumber();
        drawBounsNumber(lotto);
    }

    public WinningNumber getWinningNumber() {
        return winningNumber;
    }
}

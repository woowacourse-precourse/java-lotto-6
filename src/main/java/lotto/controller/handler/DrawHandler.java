package lotto.controller.handler;

import lotto.constant.ErrorText;
import lotto.controller.user.BonusDraw;
import lotto.controller.user.LottoDraw;
import lotto.domain.Lotto;
import lotto.domain.WinningNumber;
import lotto.model.LottoTicket;
import lotto.view.InputView;

public class DrawHandler {
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
                inputView.showInputErrorMessage(ErrorText.DUPLICATE_NUMBER.getMessage());
                continue;
            }
            break;
        }
    }

    public void drarw(LottoTicket lottoTicket) {
        Lotto lotto = drawLottoNumber();
        drawBounsNumber(lotto);

        lottoTicket.setWinningNumber(winningNumber);
    }
}

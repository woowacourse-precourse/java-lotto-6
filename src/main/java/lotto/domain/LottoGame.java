package lotto.domain;

import lotto.view.ExceptionMessage;
import lotto.view.InputView;

public class LottoGame {
    private static PlayerLottoAmount playerLottoAmount;

    public void start() {
        setPlayerAmount();
        //setWinningNumber();


    }

    private void setPlayerAmount() {
        int ticketCount = inputPlayerAmount();

    }

    private int inputPlayerAmount() {
        try {
            playerLottoAmount = new PlayerLottoAmount(InputView.inputPlayerAmount());
        } catch (IllegalArgumentException e) {
            ExceptionMessage.wrongValueException();
            playerLottoAmount = new PlayerLottoAmount(InputView.inputPlayerAmount());
        }
        return playerLottoAmount.purchaseTicketCount();
    }
}

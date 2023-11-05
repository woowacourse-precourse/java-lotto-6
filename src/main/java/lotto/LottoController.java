package lotto;


public class LottoController {
    public void start() {
        int ticketCount = inputLottoMoney();
    }

    private int inputLottoMoney() {
        InputView.inputRequestMoney();
    }
}

package controller;

import java.util.List;

import lotto.LottoMoney;
import view.InputView;
import view.OutputView;

public class GameController {
    LottoMoney lottoMoney;

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    RandomUtility randomUtility = new RandomUtility();
    boolean restart = true;

    public void startGame() {
        saveLottoMoney();
        outputView.printLottoTicketMessage(lottoMoney);
        randomUtility.generateRandomLottoNumbers();
        saveRandomLottoNumbers(lottoMoney);
    }

    private void saveLottoMoney() {
        while (restart) {
            try {
                String inputMoney = inputView.enterLottoMoney();
                lottoMoney = new LottoMoney(inputMoney);
                restart = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void saveRandomLottoNumbers(LottoMoney lottoMoney) {
        for (int i = 0; i < lottoMoney.getLottoTicket(); i++) {
            List<Integer> numbers = randomUtility.generateRandomLottoNumbers();
            outputView.printLottoNumber(numbers);
        }
    }

}

package controller;

import java.util.ArrayList;
import java.util.List;
import view.InputView;
import view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private int numberOfSheets;
    private List<List<Integer>> customerLottoTickets = new ArrayList<>();
    private List<Integer> winningNumber = new ArrayList<>();
    private int bonusNumber;


    public LottoController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void start() {
        requestLottoAmount();
        buyLottoCount();
        requestWinningNumber();
    }

    private void requestLottoAmount() {
        inputView.printRequestAmount();
        Integer amount = inputView.InputAmount();
        numberOfSheets = outputView.printNumberOfSheets(amount);
    }

    private void buyLottoCount() {
        customerLottoTickets = outputView.printLottoSheet(numberOfSheets);
    }

    private void requestWinningNumber() {
        winningNumber = inputView.inputWinningNumber();
        bonusNumber = inputView.inputBonusNumber();
    }

    private void matchLottoNumber() {

    }
}

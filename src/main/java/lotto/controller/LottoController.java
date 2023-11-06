package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.util.constants.DomainConstants;
import lotto.domain.LottoTicket;
import lotto.domain.convertor.Convertor;
import lotto.domain.convertor.TextConvertor;
import lotto.domain.validator.AmountValidator;
import lotto.domain.validator.Validator;
import lotto.domain.validator.WinnerNumberValidator;
import lotto.view.input.AmountView;
import lotto.view.input.Input;
import lotto.view.input.WinnerNumberView;
import lotto.view.output.LottoView;
import lotto.view.output.Output;

public class LottoController {

    private final LottoTicket lottoTicket;

    public LottoController() {
        this.lottoTicket = new LottoTicket();
    }

    public void lottoMachine() {
        buyLotto();
        checkWinnerNumber();
    }

    public void buyLotto() {
        String amountInput;
        do {
            amountInput = inputAmount();
        } while (validateAmount(amountInput));
        generateLottoTicket(convertAmount(amountInput));
        displayMyLotto();
    }

    public void checkWinnerNumber() {
        String inputWinnerNumber;
        List<String> winnerNumber;
        do{
            inputWinnerNumber = inputWinningNumbers();
            winnerNumber = winnerNumberConvert(inputWinnerNumber);
        } while(validateWinnerNumber(winnerNumber));
    }

    public String inputWinningNumbers() {
        Input winnerNumberView = new WinnerNumberView();
        winnerNumberView.println();
        return winnerNumberView.getInput();
    }

    public String inputAmount() {
        Input amountView = new AmountView();
        return amountView.getInput();
    }

    public boolean validateAmount(String amountInput) {
        Validator<String> validator = new AmountValidator();
        return validator.inputValidate(amountInput);
    }

    public int convertAmount(String amountInput) {
        Convertor<Integer> amountConvertor = new TextConvertor<>(Integer::parseInt);
        return amountConvertor.convert(amountInput);
    }

    public void generateLottoTicket(int amount) {
        int lottoCount = calculateLottoTicket(amount);
        lottoTicket.createLottoTicket(lottoCount);
    }

    public void displayMyLotto() {
        Output lottoView = new LottoView(lottoTicket.getLottoTicket());
        lottoView.println();
        lottoView.getOutput();
    }

    public List<String> winnerNumberConvert(String input) {
        Convertor<List<String>> convertor = new TextConvertor<>(text -> Arrays.stream(text.split(","))
                .collect(Collectors.toList()));
        return convertor.convert(input);
    }

    public boolean validateWinnerNumber(List<String> winnerNumber) {
        Validator<List<String>> validator = new WinnerNumberValidator();
        return validator.inputValidate(winnerNumber);
    }

    private int calculateLottoTicket(int amount) {
        return (amount / DomainConstants.LOTTO_PRICE.getConstants());
    }
}

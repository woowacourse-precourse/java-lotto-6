package lotto.controller;

import lotto.util.constants.DomainConstants;
import lotto.domain.LottoTicket;
import lotto.util.convertor.Convertor;
import lotto.util.convertor.StringConvertor;
import lotto.util.validator.AmountValidator;
import lotto.util.validator.Validator;
import lotto.view.input.AmountView;
import lotto.view.output.LottoView;
import lotto.view.output.Output;

public class LottoController {

    private final LottoTicket lottoTicket;

    public LottoController() {
        this.lottoTicket = new LottoTicket();
    }

    public void buyLotto() {
        String amountInput;
        Validator validator = new AmountValidator();

        do {
            amountInput = inputAmount();
        } while(validator.inputValidate(amountInput));

        Convertor<Integer> amountConvertor = new StringConvertor<>(Integer::parseInt);
        generateLottoTicket(amountConvertor.convert(amountInput));
        displayMyLotto();
    }

    public String inputAmount() {
        AmountView amountInputView = new AmountView();
        return amountInputView.getInput();
    }

    public void validateAmount() {

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

    private int calculateLottoTicket(int amount) {
        return (amount / DomainConstants.LOTTO_PRICE.getInt());
    }
}

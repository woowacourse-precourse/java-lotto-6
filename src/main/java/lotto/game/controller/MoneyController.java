package lotto.game.controller;

import lotto.adapter.IoAdapter;
import lotto.message.ErrorMessage;
import lotto.message.LottoMessage;
import lotto.service.ValidateService;
import lotto.vo.Money;

public class MoneyController {

    private final IoAdapter ioAdapter;
    private final ValidateService validateService;

    public MoneyController(IoAdapter ioAdapter, ValidateService validateService) {
        this.ioAdapter = ioAdapter;
        this.validateService = validateService;
    }

    public Money make() {
        LottoMessage purchaseAmountMessage = LottoMessage.ENTER_PURCHASE_AMOUNT;
        ioAdapter.printMessage(purchaseAmountMessage.getMessage());
        int moneyInput = moneyInput();
        return new Money(moneyInput);
    }

    private int moneyInput() {

        while (true) {
            try {
                String moneyInputStream = ioAdapter.inputStream();
                validateService.checkCorrectMoney(moneyInputStream);
                ioAdapter.printNewLine();
                return Integer.parseInt(moneyInputStream);
            } catch (IllegalArgumentException exception) {
                ErrorMessage notUnitsOfThousandError = ErrorMessage.NOT_UNITS_OF_THOUSAND_ERROR;
                ioAdapter.printMessage(notUnitsOfThousandError.getMessage());
            }
        }
    }
}

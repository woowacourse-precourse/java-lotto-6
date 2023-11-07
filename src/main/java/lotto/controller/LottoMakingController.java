package lotto.controller;

import lotto.domain.Player;
import lotto.view.ErrorMessage;
import lotto.view.LottoView;

public class LottoMakingController {
    private static final LottoView view = new LottoView();
    private final int MONEY_UNIT = 1000;
    private int money;
    public void createLottoCount() {
        while(true) {
            try {
                String input = view.inputMoney();
                validateIsNumber(input);
                validateMoneyUnit(money);
                break;
            } catch (NumberFormatException e) {
                view.outputError(ErrorMessage.ERROR_NOT_NUMBER_MESSAGE.getValue());
            } catch (IllegalArgumentException e) {
                view.outputError(e.getMessage());
            }
        }
    }

    private void validateIsNumber(String number) throws NumberFormatException {
        money = Integer.parseInt(number);
    }

    private void validateMoneyUnit(int money) {
        if(money % MONEY_UNIT != 0)
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_THOUSAND_MESSAGE.getValue());
    }
}

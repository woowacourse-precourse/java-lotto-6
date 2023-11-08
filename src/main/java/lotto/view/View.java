package lotto.view;

import lotto.constant.ErrorMessage;
import lotto.constant.LottoConstant;
import lotto.util.IntegerParser;

public class View {
    private InputView inputView;
    private OutputView outputView;

    public View() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public int getMoney() {
        while (true) {
            try {
                String inputMoney = inputView.getInputMoney();
                int money = IntegerParser.parse(inputMoney);
                validateSufficientMoney(money);
                return money;
            } catch (NumberFormatException e) {
                outputView.printErrorMessage(ErrorMessage.NOT_INTEGER_ERROR);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(ErrorMessage.INSUFFICIENT_MONEY_ERROR);
            }
        }
    }

    private void validateSufficientMoney(int money) {
        if (money < LottoConstant.LOTTO_PRICE) throw new IllegalArgumentException();
    }
}

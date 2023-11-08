package lotto.view;

import lotto.constant.ErrorMessage;
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
                return IntegerParser.parse(inputMoney);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(ErrorMessage.NOT_INTEGER_ERROR);
            }
        }
    }
}

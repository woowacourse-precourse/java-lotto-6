package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.View.InputView;
import lotto.validation.Validator;

public class Buyer {
    int amount;
    List<Lotto> buyList = new ArrayList<>();
    InputView inputView = new InputView();
    Validator validator = new Validator();

    public void buyLotto() {
        while (true) {
            String input = inputView.getAmount();
            if (validator.isAmountRight(input)) {
                amount = Integer.parseInt(input);
                break;
            }
        }


    }

}

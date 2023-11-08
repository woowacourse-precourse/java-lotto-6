package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.View.InputView;
import lotto.validation.Validator;

public class Buyer {
    List<Lotto> buyList = new ArrayList<>();
    InputView inputView = new InputView();
    Validator validator = new Validator();

    public void buyLotto() {
        while (true) {
            String input = inputView.getPrice();
            if (validator.isPriceRight(input))
                break;
        }
    }

}

package lotto;

import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Application {
    static InputView inputView = InputView.getInstance();
    static OutputView outputView = OutputView.getInstance();
    static Validator validator = Validator.getInstance();
    static Committee committee = Committee.getInstance();

    public static void main(String[] args) {
        inputView = InputView.getInstance();
        outputView = OutputView.getInstance();
        validator = Validator.getInstance();

        int price = setPrice();

        List<Integer> winningNumbers= committee.setWinningNum();
        int count = price/1000;

    }

    static int setPrice() {
        boolean askAgain = true;
        int price = 0;

        while (askAgain) {
            askAgain = false;
            String priceInput = inputView.inputPrice();
            try {
                price = validator.validatePrice(priceInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                askAgain = true;
            }
        }
        return price;
    }
}

package lotto;


import lotto.domain.Cost;
import lotto.domain.MyLotto;
import lotto.view.InputView;

public class Application {
    static boolean isValid;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        StringConverter stringConverter = new StringConverter();

        int quantity = payMoney(inputView);

        MyLotto myLotto = new MyLotto(quantity);
        myLotto.printGenerateLottoResult();

    }

    private static int payMoney(InputView inputView) {
        Cost cost;
        do {
            cost = new Cost(inputView.inputBuyingCost());
        } while (!cost.isValid());

        return cost.getQuantity();
    }
}

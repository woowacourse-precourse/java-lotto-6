package lotto;

import lotto.data.Purchasing;
import lotto.data.Statics;
import lotto.presentation.Input;
import lotto.presentation.Output;

public class Application {
    public static void main(String[] args) {
        start();
    }
    static void start(){
        Input input = new Input();
        Output output = new Output();
        Statics statics = new Statics(5);

        String purchasePrice = input.inputPurchasePrice();

        Purchasing purchasing = new Purchasing(Integer.parseInt(purchasePrice));

        output.printPurchasedLottos(purchasing.getLottos());
        String[] winngingNumber = input.inputWinningNumber();
        String bonusNumber = input.inputBonusNumber();
        output.printMultipleWinningStatics(statics);
    }
}

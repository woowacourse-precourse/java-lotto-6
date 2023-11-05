package lotto;

import lotto.UI.Input;
import lotto.UI.Output;
import lotto.domain.Lotto;

public class Application {
    public static void main(String[] args) {
        Input input = new Input();
        Output output = new Output();
//        Lotto lotto = new Lotto();
        int price = input.inputPrice();
//        lotto.buyLotto()

        input.inputLottoNumbers();
        input.inputBonusNumber();
    }
}

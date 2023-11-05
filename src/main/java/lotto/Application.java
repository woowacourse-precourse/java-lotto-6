package lotto;

import lotto.UI.Input;

public class Application {
    public static void main(String[] args) {
        Input input = new Input();
        input.inputPrice();
        input.inputLottoNumbers();
        input.inputBonusNumber();
    }
}

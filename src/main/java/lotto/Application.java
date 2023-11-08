package lotto;

import lotto.Input.TakeInput;
import lotto.domain.CompareLottos;

public class Application {
    public static void main(String[] args) {
        InitLotto initLotto = TakeInput.takeInput();
        CompareLottos.compareLottos(initLotto);
    }
}

package lotto;

import lotto.domain.PlayLotto;
import lotto.view.InputMoney;

public class Application {
    public static void main(String[] args) {
        int inputMoney = new InputMoney().input();
        int cnt = new PlayLotto(inputMoney).lottoTry();

    }
}

package lotto;

import lotto.View.InputVIew;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Lotto lotto = new Lotto(InputVIew.inputWinningNumbers());
    }
}

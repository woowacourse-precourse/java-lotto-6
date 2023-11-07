package lotto;

import lotto.domain.LottoDraw;
import lotto.ui.Input;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Input input = new Input();
        LottoDraw lottoDraw = new LottoDraw(input.purchasePriceInput());
        lottoDraw.configureLottoNumbers();
    }
}

package lotto;

import lotto.util.TypeConverter;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

    }
    private static InputView inputView() {
        return new InputView(new TypeConverter());
    }
}

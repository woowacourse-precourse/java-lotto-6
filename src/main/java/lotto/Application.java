package lotto;

import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        try {
            inputView.inputPrice();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]");
            inputView.inputPrice();
        }
    }
}

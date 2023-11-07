package lotto.view;

import static lotto.constant.Constant.ERROR_MESSAGE_FRONT;

public class GameView {

    public void errorMessageView(String errorMessage) {
        System.out.println(ERROR_MESSAGE_FRONT + errorMessage);
    }
}

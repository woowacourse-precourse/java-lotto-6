package lotto.view;

public class GameView {

    private final String ERROR_MESSAGE_FRONT = "[ERROR] ";

    public void errorMessageView(String errorMessage) {
        System.out.println(ERROR_MESSAGE_FRONT + errorMessage);
    }
}

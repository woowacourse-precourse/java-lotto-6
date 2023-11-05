package lotto;

import lotto.controllers.InputProcessor;

import static lotto.views.MessageManager.getPurchaseAmountPromptMessage;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        getPurchaseAmountPromptMessage();

        InputProcessor.readLine();



        InputProcessor.close();
    }
}

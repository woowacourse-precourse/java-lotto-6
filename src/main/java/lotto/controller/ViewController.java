package lotto.controller;

import static lotto.SystemConstant.DEFAULT_DEPTH;
import static lotto.validation.InputValidation.validateInput;
import static lotto.view.InputView.inputData;
import static lotto.view.OutputView.printErrorMessage;
import static lotto.view.OutputView.printSystemMessage;

import lotto.view.SystemMessage;

public class ViewController {

    public static String request(SystemMessage systemMessage, int depth) {
        String input;
        try {
            input = requestInput(systemMessage, depth);
            validateInput(systemMessage, input);
        } catch (IllegalArgumentException e) {
            printErrorMessage(e);
            input = request(systemMessage, depth + 1);
        }
        return input;
    }

    public static String requestInput(SystemMessage systemMessage, int depth) {
        if (depth == DEFAULT_DEPTH) {
            return requestFirst(systemMessage);
        }
        return requestAgain();
    }

    public static String requestFirst(SystemMessage systemMessage) {
        printSystemMessage(systemMessage);
        return inputData();
    }

    public static String requestAgain() {
        return inputData();
    }
}

package lotto.view;

import lotto.view.Input;
import lotto.view.Output;

public class InputHandler {

    private final Input input;
    private final Output output;

    public InputHandler(Input input, Output output) {
        this.input = input;
        this.output = output;
    }



    public String requestStringInput(String message) {
        while (true) {
            try {
                output.displayInputRequest(message);
                return input.inputString();
            } catch (IllegalArgumentException e) {
                output.printError(e.getMessage());
            }
        }
    }

    public int requestNumberInput(String message) {
        while (true) {
            try {
                output.displayInputRequest(message);
                return input.inputNumber();
            } catch (IllegalArgumentException e) {
                output.printError(e.getMessage());
            }
        }
    }
}
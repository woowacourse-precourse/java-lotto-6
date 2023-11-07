package Controller;

import Utils.Messages;
import VIew.InputView;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputManager {
    private final InputView inputView;

    public InputManager() {
        this.inputView = new InputView();
    }

    public int promptForPayment(String message) {
        try {
            return getValidPayment(message);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return promptForPayment(message);
        }
    }


    private int getValidPayment(String message) throws IllegalArgumentException {
        System.out.println(message);
        String input = Console.readLine();
        try {
            int payment = Integer.parseInt(input);
            validatePayment(payment);
            return payment;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Messages.NumberInputError);
        }
    }

    public void displayMessage(String message) {
        inputView.printMessage(message);
    }

    public void validatePayment(int payment) {
        if (payment <= 0) {
            throw new IllegalArgumentException(Messages.NonPositiveAmountException);
        }
        if (payment % 1000 != 0) {
            throw new IllegalArgumentException(Messages.NonMultipleOfThousandException);
        }
    }

}

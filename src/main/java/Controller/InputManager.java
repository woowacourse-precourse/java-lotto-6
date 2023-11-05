package Controller;

import VIew.InputView;
import camp.nextstep.edu.missionutils.Console;

public class InputManager {
    private InputView inputView;

    public InputManager(InputView inputView) {
        this.inputView = inputView;
    }



    public int promptForPayment(String message) {
        int payment = 0;
        boolean isValidInput = false;
        while (!isValidInput) {
            try {
                payment = getValidPayment(message);
                isValidInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
        return payment;
    }

    private int getValidPayment(String message) throws IllegalArgumentException {
        System.out.println(message);
        String input = Console.readLine();
        try {
            int payment = Integer.parseInt(input);
            validatePayment(payment);
            return payment;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }
    }

    private void validatePayment(int payment) {
        if (payment <= 0) {
            throw new IllegalArgumentException("금액은 0 이상이어야 합니다.");
        }
        if (payment % 1000 != 0) {
            throw new IllegalArgumentException("금액은 1000원 단위여야 합니다.");
        }
    }

    public String promptForInput(String message) {
        inputView.printMessage(message);
        return inputView.getUserInput();
    }


}

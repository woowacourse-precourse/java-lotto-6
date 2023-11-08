package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {

    public static void alertError(String message) {
        System.out.println("[ERROR] " + message);
    }

    public static int convertInteger(String input) {
        int toValidate;
        try {
            toValidate = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return toValidate;
    }

    public static int inputBudget() {
        int input = convertInteger(Console.readLine());
        boolean isNotMultipleOf1000 = input % 1000 != 0;
        if(isNotMultipleOf1000) {
            throw new IllegalArgumentException();
        }
        return input;
    }

    public static void main(String[] args) {
        int budget;
        try {
            budget = inputBudget();
        } catch (IllegalArgumentException e) {
            alertError("로또 구입 금액은 1,000 단위의 숫자여야 합니다.");
        }
    }
}

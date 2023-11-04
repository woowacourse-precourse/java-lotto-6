package view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public static int getPurchaseAmount() {
        int input = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.println("구입금액을 입력해 주세요.");

            try {
                input = Integer.parseInt(Console.readLine());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }

        return input;
    }

    public static List<Integer> getLotto() {
        String input;
        List<Integer> lotto = new ArrayList<>();
        boolean validInput = false;

        while (!validInput) {
            System.out.println("\n당첨 번호를 입력해 주세요.");
            input = Console.readLine();

            try {
                lotto = changeStringToLotto(input);
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }

        return lotto;
    }

    public static List<Integer> changeStringToLotto(String input) {
        List<String> splitedInput = Arrays.asList(input.split(","));
        splitedInput.replaceAll(String::trim);

        List<Integer> inputNumbers = new ArrayList<>();
        for (String inputNumber : splitedInput) {
            try {
                int number = Integer.parseInt(inputNumber);
                inputNumbers.add(number);
            } catch (NumberFormatException e) {
                throw e;
            }
        }
        return inputNumbers;
    }

    public static int getBonusNumber() {
        int input = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.println("보너스 번호를 입력해 주세요.");

            try {
                input = Integer.parseInt(Console.readLine());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }

        return input;
    }
}

package lotto;

import util.InputUtil;

import java.util.ArrayList;
import java.util.List;

import static validate.InputValidation.*;
import static validate.InputValidation.validateLottoNumberRange;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int purchaseAmount = getInputToPurchaseAmount();

        List<Integer> resultNumbers = getInputToResultNumbers();
    }

    private static int getInputToPurchaseAmount() {
        int purchaseAmount = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                String input = InputUtil.getUserInput("구입금액을 입력해 주세요.\n");
                purchaseAmount = validateAndGetPurchaseAmount(input);
                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return purchaseAmount;
    }

    private static int validateAndGetPurchaseAmount(String input) {
        validateNumericInput(input);
        return Integer.parseInt(input);
    }

    private static List<Integer> getInputToResultNumbers() {
        List<Integer> list = new ArrayList<>();
        boolean validInput = false;

        while (!validInput) {
            try {
                String input = InputUtil.getUserInput("당첨 번호를 입력해 주세요.\n");
                list = validateAndGetResultNumbers(input);
                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return list;
    }

    private static List<Integer> validateAndGetResultNumbers(String input) {
        List<Integer> list = new ArrayList<>();
        String[] numbers = input.split(",");
        for (String number : numbers) {
            validateNumericInput(number);
            validateNonZeroInput(number);

            int lottoNumber = Integer.parseInt(number.trim());
            validateLottoNumberRange(lottoNumber);
            list.add(lottoNumber);
        }
        return list;
    }

}

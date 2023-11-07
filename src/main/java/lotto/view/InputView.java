package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String ASK_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String ASK_WINNER_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String ASK_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String ERROR_MESSAGE_ABOUT_PURCHASE_AMOUNT = "[ERROR] 구입 금액은 1,000원 단위로 입력해주세요.";
    private static final String ERROR_MESSAGE_ABOUT_DUPLICATED_LOTTO_NUMBERS = "[ERROR] 중복되지 않는 숫자를 입력해주세요.";
    private static final String ERROR_MESSAGE_ABOUT_WRONG_RANGED_LOTTO_NUMBERS = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String ERROR_MESSAGE_ABOUT_BLANK_INPUT = "[ERROR] 입력값이 없습니다.";
    private static final String COMMA = ",";
    public static int inputPurchaseAmount() {
        int money = 0;
        try {
            System.out.println(ASK_PURCHASE_AMOUNT);
            money = Integer.parseInt(Console.readLine());
            Validator.validatePurchaseAmount(money);
        } catch(IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE_ABOUT_PURCHASE_AMOUNT);
        }
        return money;
    }

    private static void validateInputZero(String input) {
        if (input == "0") {
            throw new IllegalArgumentException();
        }
    }
    private static void validateInputBlank(String input) {
        if (input.replaceAll(" ", "") == "") {
            throw new IllegalArgumentException();
        }
    }

    public static List inputWinnerNumbers() {
        String input = "";
        try {
            System.out.println(ASK_WINNER_NUMBERS);
            input = Console.readLine();
            Validator.validateBlank(input);
        } catch(IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE_ABOUT_BLANK_INPUT);
        }
        return convertStringToListWithDelimeter(input);
    }

    public static int inputBonusNumbers() {
        String input = "";
        try {
            System.out.println(ASK_BONUS_NUMBER);
            input = Console.readLine().replaceAll(" ", "");
            Validator.validateBlank(input);
        } catch(IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE_ABOUT_BLANK_INPUT);
        }
        return Integer.parseInt(input);
    }

    private static List<Integer> convertStringToListWithDelimeter(String input) {
        return Arrays.stream(input.split(COMMA)).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
    }

}

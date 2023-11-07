package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.Validator;
import lotto.constants.ErrorMessage;
import lotto.constants.StaticMessage;

public class InputHandler {
    // TODO : 사용자의 입력에 대한 처리
    private static final String delimiter = ",";

    public static String askNumber(StaticMessage message) {
        do {
            try {
                System.out.println(message);
                return Console.readLine();
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException();
            }
        } while (true);
    }

    public static User askPayment() {
        String input = "";
        do {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                input = Console.readLine();
                Validator.validatePayment(input);
                return new User(input);
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.NUMBER_FORMAT.getMessage());
            }
        } while (true);
    }

    public static String[] askWinningNumbers() {
        System.out.println(StaticMessage.INPUT_WINNING_NUMBERS);
        return convertStringToArray(Console.readLine());
//        do {
//            System.out.println("당첨 번호를 입력해 주세요.");
//            try {
//                input = Console.readLine();
//                Validator.validatePayment(input);
//                return new User(input);
//            } catch (IllegalArgumentException e) {
//                System.out.println(ErrorMessage.NUMBER_FORMAT.getMessage());
//            }
//        } while (true);
//        System.out.println("당첨 번호를 입력해 주세요.");
//        return Console.readLine();

    }

//    public static void inputController(String input) {
//        //
//    }

    public static void inputController(String[] input) {
        do {
            askWinningNumbers();
            try {
                Validator.containOnlyDigit(input);
            } catch (IllegalArgumentException e) {

            }
        } while (true);
    }

    public void askBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        Console.readLine();
    }

    public static int convertStringToInteger (String input) {
        return Integer.parseInt(input);
    }

    public static String[] convertStringToArray (String input) {
        return input.split(delimiter);
    }
}

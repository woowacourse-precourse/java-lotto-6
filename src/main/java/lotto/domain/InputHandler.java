package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.Validator;
import lotto.constants.ErrorMessage;
import lotto.constants.StaticMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class InputHandler {
    // TODO : 사용자의 입력에 대한 처리
    private static final String delimiter = ",";

    public static int askNumber(StaticMessage message) {
        do {
            try {
                System.out.println(message);
                return convertStringToInteger(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.NUMBER_FORMAT);
            }
        } while (true);
    }

    public static List<Integer> askWinningNumbers() {
        do {
            System.out.println(StaticMessage.INPUT_WINNING_NUMBERS);
            try {
                return convertStringToArray(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.NUMBER_FORMAT.getMessage());
            }
        } while (true);
    }

//    public static User askPayment() {
//        String input = "";
//        do {
//            try {
//                System.out.println("구입금액을 입력해 주세요.");
//                input = Console.readLine();
//                Validator.validatePayment(input);
//                return new User(input);
//            } catch (IllegalArgumentException e) {
//                System.out.println(ErrorMessage.NUMBER_FORMAT.getMessage());
//            }
//        } while (true);
//    }

//    public static String[] askWinningNumbers() {
//        do {
//            System.out.println(StaticMessage.INPUT_WINNING_NUMBERS);
//            try {
//                return convertStringToArray(Console.readLine());
//            } catch (IllegalArgumentException e) {
//                System.out.println(ErrorMessage.NUMBER_FORMAT.getMessage());
//            }
//        } while (true);
//    }

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
        if (!Validator.containOnlyDigitTest(input)) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(input);
    }

    public static List<Integer> convertStringToArray (String inputNumbers) {
        List<Integer> numbers = new ArrayList<>();
        for (String input: inputNumbers.split(delimiter)) {
            if (!Validator.containOnlyDigitTest(input)) {
                throw new IllegalArgumentException();
            }
            numbers.add(Integer.parseInt(input));
        }
        return numbers;
    }
}

package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static InputView inputView;

    private static final String MESSAGE_LOTTO_INPUT_NOT_NUMBER = "[ERROR] 숫자만 입력해야 합니다.";
    private static final String MESSAGE_LOTTO_INPUT_NOT_NUMBER_EXCLUDE_COMMA = "[ERROR] 쉼표(,)를 제외하 숫자만 입력해야 합니다.";

    private InputView() {
    }

    public static InputView getInstance() {
        if (inputView == null) {
            inputView = new InputView();
        }
        return inputView;
    }

    private String readInput() {
        return Console.readLine();
    }

    public int readAmount() {
        while (true) {
            try {
                String input = readInput();
                System.out.println();
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println(MESSAGE_LOTTO_INPUT_NOT_NUMBER);
            }
        }
    }

    public List<Integer> readMainNumbers() {
        while (true) {
            String input = readInput();
            System.out.println();
            try {
                List<Integer> numbers = new ArrayList<>();
                for (String s : input.split(",")) {
                    numbers.add(Integer.parseInt(s));
                }
                return numbers;
            } catch (IllegalArgumentException e) {
                System.out.println(MESSAGE_LOTTO_INPUT_NOT_NUMBER_EXCLUDE_COMMA);
            }
        }
    }

    public Integer readBonusNumber() {
        while (true) {
            try {
                String input = readInput();
                System.out.println();
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println(MESSAGE_LOTTO_INPUT_NOT_NUMBER);
            }
        }
    }
}

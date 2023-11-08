package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    static final String ERROR_MESSAGE = "[ERROR] ";

    int validateInput(String input) {
        int validatedInput;

        while (true) {
            try {
                validatedInput = Integer.parseInt(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_MESSAGE + "숫자를 입력해주세요.");
                input = Console.readLine();
            }
        }

        return validatedInput;
    }

    List<String> validateInputForNumbers(List<String> splitedInput, int maxSize) {
        while (true) {
            try {
                if (splitedInput.size() != maxSize) {
                    throw new IllegalArgumentException();
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_MESSAGE + "6개의 당첨번호를 입력해야 합니다.");
                String input = Console.readLine();
                splitedInput = Arrays.asList(input.split(","));
            }
        }

        return  splitedInput;
    }

    List<String> checkDuplicationInputForNumbers(List<String> splitedInput) {
        while (true) {
            try {
                Set<String> removeDuplicateInput = new HashSet<>(splitedInput);

                if (splitedInput.size() != removeDuplicateInput.size()) {
                    throw new IllegalArgumentException();
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_MESSAGE + "중복된 값은 입력할 수 없습니다.");
                String input = Console.readLine();
                splitedInput = Arrays.asList(input.split(","));
            }
        }

        return  splitedInput;
    }
}

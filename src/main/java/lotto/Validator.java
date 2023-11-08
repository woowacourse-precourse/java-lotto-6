package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

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

    void validateInputForNumbers(List<String> input, int maxSize) {
        try {
            if (input.size() > maxSize) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE + "당첨번호는 최대 6개입니다.");
        }
    }
}

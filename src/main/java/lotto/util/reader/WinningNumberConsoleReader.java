package lotto.util.reader;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.stream.Collectors;
import lotto.util.Logger;
import lotto.util.RegxPattern;

public class WinningNumberConsoleReader implements ConsoleReader {
        @Override
        public String readLine() {
                String numbers;
                while (true) {
                        try {
                                Logger.info("\n당첨 번호를 입력해 주세요.");
                                numbers = Console.readLine();
                                validate(numbers);
                                break;
                        } catch (IllegalArgumentException e) {
                                Logger.error(e.getMessage());
                        }

                }

                return numbers;
        }

        private void validate(String numbers) {
                if (!numbers.matches(RegxPattern.RESULT_FORMAT)) {
                        throw new IllegalArgumentException("숫자와 구분자 , 이외에는 입력할 수 없습니다.");
                }

                if (numbers.split(",").length != 6 ||
                        Arrays.stream(numbers.split(",")).collect(Collectors.toSet()).size() != 6) {
                        throw new IllegalArgumentException("당첨 번호는 6자리 번호이고, 중복된 숫자를 포함할 수 없습니다.");
                }

                Arrays.stream(numbers.split(",")).forEach(number -> {
                        if (!number.matches(RegxPattern.LOTTO_NUMBER_RANGE)) {
                                throw new IllegalArgumentException("당첨 번호는 1에서 45사이의 숫자만 입력가능합니다.");

                        }
                });
        }
}

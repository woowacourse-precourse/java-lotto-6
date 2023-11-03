package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;

public class View {

    public interface Converter<T> {
        T convert(String input);
    }

    public static <T> T readNumber(String prompt, Converter<T> converter) {
        System.out.println(prompt);

        while (true) {
            try {
                return converter.convert(readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int readPayment() {
        return readNumber("구입금액을 입력해 주세요.", StringUtils::stringToNumber);
    }

    public static List<Integer> readWinningNumbers() {
        return readNumber("당첨 번호를 입력해 주세요.", StringUtils::stringToNumbers);
    }

    public static int readBonusNumber() {
        return readNumber("보너스 번호를 입력해 주세요.", StringUtils::stringToNumber);
    }
}

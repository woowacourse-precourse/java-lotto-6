package view;

import message.ErrorMessage;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputLotteryNumber {
    private static final Pattern PATTERN = Pattern.compile("(\\d{1,2},){5}\\d{1,2}"); // 1~2자리 숫자와 쉼표가 5번 나와야 한다. 그리고 마지막에 1~2자리 숫자가 하나 나와야 한다.
    private static final String INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";

    public List<Integer> inputLotteryNumbers() {
        System.out.println(INPUT_MESSAGE);
        String lotteryNumbers = Console.readLine();
        System.out.println();
        validate(lotteryNumbers);
        return Stream.of(lotteryNumbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void validate(String lotteryNumbers) {
        validateInputFormat(lotteryNumbers);
    }

    private void validateInputFormat(String lotteryNumbers) {
        if (!PATTERN.matcher(lotteryNumbers).matches()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_FORMAT_ERROR);
        }
    }
}
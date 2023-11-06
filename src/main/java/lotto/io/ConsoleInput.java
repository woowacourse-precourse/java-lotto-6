package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.domain.message.ErrorMessage;

public class ConsoleInput implements Input {

    public static final String SPLIT_REGEX = ",";
    public static final String NUMBER_FORMAT_EXCEPTION_MESSAGE = String.format("%s 숫자를 입력하셔야 합니다",
            ErrorMessage.ERROR.getMessage());
    public static final String BLANK_EXCEPTION_MESSAGE = String.format("%s 값을 입력해야 합니다.",
            ErrorMessage.ERROR.getMessage());
    ;

    private String consoleLine() {
        String str = Console.readLine();
        validate(str);
        return str;
    }

    @Override
    public Integer getInteger() {
        try {
            return Integer.valueOf(consoleLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public List<Integer> getIntegers() {
        try {
            return Stream.of(consoleLine().split(SPLIT_REGEX))
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public String getString() {
        return consoleLine();
    }

    @Override
    public List<String> getStrings() {
        return Stream.of(consoleLine().split(SPLIT_REGEX))
                .collect(Collectors.toList());
    }

    private void validate(String str) {
        if (str == null || str.isBlank()) {
            throw new IllegalArgumentException(BLANK_EXCEPTION_MESSAGE);
        }
    }
}

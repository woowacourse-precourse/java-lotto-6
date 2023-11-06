package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConsoleInput implements Input {

    public static final String SPLIT_REGEX = ",";

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
            throw new IllegalArgumentException("[ERROR] 숫자를 입력하셔야 합니다");
        }
    }

    @Override
    public List<Integer> getIntegers() {
        try {
            return Stream.of(consoleLine().split(SPLIT_REGEX))
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력하셔야 합니다");
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
            throw new IllegalArgumentException("값을 입력해야 합니다");
        }
    }
}

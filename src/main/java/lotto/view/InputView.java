package lotto.view;

import static lotto.util.Constant.COMMA;
import static lotto.util.Constant.REGEX_NOSPACE;
import static lotto.util.Constant.REGEX_SPACE;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public static String readLine() {
        return Console.readLine();
    }

    public List<String> split(String input) {
        return Arrays.stream(input.split(COMMA))
                .collect(Collectors.toList());
    }

    public String stringWithoutSpace(String input) {
        return input.replaceAll(REGEX_SPACE, REGEX_NOSPACE);
    }
}

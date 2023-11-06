package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.regex.PatternSyntaxException;
import lotto.game.io.Input;
import lotto.io.enums.InputMessage;

public final class ConsoleInput implements Input {

    private static final String DEFAULT_SPLIT_REGEX = "";

    public String line() {
        return Console.readLine();
    }

    public List<String> strings() {
        return strings(DEFAULT_SPLIT_REGEX);
    }

    public List<String> strings(String regex) {
        return Arrays.stream(Console.readLine().split(regex))
                .toList();
    }

    public int number() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(InputMessage.WRONG_INPUT_VALUE.get(), e);
        }
    }

    public List<Integer> numbers() {
        return numbers(DEFAULT_SPLIT_REGEX);
    }

    public List<Integer> numbers(String regex) {
        try {
            return Arrays.stream(Console.readLine().split(regex))
                    .map(Integer::valueOf)
                    .toList();
        } catch (PatternSyntaxException e) {
            throw new IllegalArgumentException(InputMessage.WRONG_SPLIT_REGEX.get(), e);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(InputMessage.WRONG_INPUT_VALUE.get());
        }
    }

}
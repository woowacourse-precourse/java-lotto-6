package lotto.system.shop.reader;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.system.shop.domain.Reader;
import lotto.system.shop.exception.reader.InvalidNumberTypeException;

public class ConsoleReader implements Reader {

    @Override
    public Integer readNumber() {
        String input = Console.readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidNumberTypeException();
        }
    }

    @Override
    public List<Integer> readNumbers() {
        String input = Console.readLine();
        try {
            return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new InvalidNumberTypeException();
        }
    }
}

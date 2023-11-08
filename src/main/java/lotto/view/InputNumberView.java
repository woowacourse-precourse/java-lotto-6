package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.exception.LottoInputFormatException;

public class InputNumberView {
    private static final Pattern FORMAT = Pattern.compile("(\\d{1,2},){5}\\d{1,2}");

    public List<Integer> getNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        System.out.println();
        validate(input);
        return Stream.of(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void validate(String input) {
        validateInput(input);
    }

    private void validateInput(String input) {
        if (!FORMAT.matcher(input).matches()) {
            try {
                throw new LottoInputFormatException();
            } catch (LottoInputFormatException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

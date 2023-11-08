package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.common.ErrorMessage;
import lotto.common.SystemMessage;

import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;

public class InputLottoWinningNumbersView {
    private static final Pattern PATTERN = Pattern.compile("(\\d{1,2},){5}\\d{1,2}");

    public List<Integer> inputLottoWinningNumbers(){
        System.out.println(SystemMessage.INPUT_WINNING_LOTTO_NUMBERS.getMessage());
        String input = Console.readLine();
        System.out.println();
        validate(input);
        return Stream.of(input.split(","))
                .map(Integer::parseInt).collect(Collectors.toList());
    }

    private void validate(String inputValue){
        validateFormat(inputValue);
    }

    private void validateFormat(String inputValue){
        if(!PATTERN.matcher(inputValue).matches()){
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
        }
    }
}

package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Money;
import lotto.ui.message.ErrorMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public static final String delimiter = ",";

    public Integer getMoney() {
        String input = getInput();
        return validateNumber(input);
    }

    public List<Integer> getWinLottoNumbers() {
        List<Integer> winLottoNumbers = new ArrayList<>();

        String input = getInput();
        List<String> numbers = split(input);

        for (String splitValues : numbers) {
            Integer number = validateNumber(splitValues);
            winLottoNumbers.add(number);
        }

        return winLottoNumbers;
    }

    public Integer getWinLottoBonus() {
        String input = getInput();
        return validateNumber(input);
    }

    private Integer validateNumber(String input) {

        if (!isNumber(input)) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_NUMBER.getComment());
        }

        return Integer.parseInt(input);
    }

    private List<String> split(String input) {
        return Arrays.stream(input.split(delimiter)).toList();
    }

    private boolean isNumber(String input) {
        return input.chars().allMatch(initial -> (initial >= '0' && initial <= '9'));
    }

    private String getInput() {
        return Console.readLine();
    }


}

package lotto.view;

import lotto.exception.WinnerNumberException;
import lotto.util.StringToListConverter;

import java.util.List;

public class InputViewWinnerNumber extends InputView {
    private static final String WINNER_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";

    public static List<Integer> getWinnerNumber() {
        System.out.println(WINNER_NUMBER_MESSAGE);
        String input = getInputValue();
        new WinnerNumberException(input);
        List<Integer> winnerNum = StringToListConverter.stringToList(input);
        return winnerNum;
    }
}

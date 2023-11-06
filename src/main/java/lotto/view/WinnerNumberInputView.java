package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.WinnerNumberException;
import lotto.util.StringToListConverter;

import java.util.List;

public class WinnerNumberInputView extends InputView {
    private static final String WINNER_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private WinnerNumberException winnerNumberException = new WinnerNumberException();
    private StringToListConverter stringToListConverter = new StringToListConverter();

    public List<Integer> getWinnerNumber(){
        System.out.println(WINNER_NUMBER_MESSAGE);
        String input = getInputValue();
        winnerNumberException.isNumber(input);
        winnerNumberException.isComma(input);
        List<Integer> winnerNum = stringToListConverter.stringToList(input);
        winnerNumberException.isBlank(winnerNum);
        winnerNumberException.isSize(winnerNum);
        winnerNumberException.isRightRange(winnerNum);
        winnerNumberException.isDuplicate(winnerNum);
        return winnerNum;
    }
}

package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.WinningDetails;
import lotto.domain.WinningNumber;

import java.util.ArrayList;
import java.util.List;

public class InputWinningNumber {
    private final static String WINNING_NUMBER = "\n당첨 번호를 입력해 주세요.";
    private final static String NOT_NUMBER = "[ERROR] 숫자를 입력해주세요.";
    private final static String LOTTO_ERROR = "[ERROR] 잘못된 입력입니다. 다시 입력해주세요.";

    private Lotto lotto;

    public WinningNumber enterWinningNumber() {
        System.out.println(WINNING_NUMBER);
        while(true) {
            try {
                convertToInteger();
                break;
            } catch (NumberFormatException e) {
                System.out.println(NOT_NUMBER);
            } catch (IllegalArgumentException e) {
                System.out.println(LOTTO_ERROR);
            }
        }
        WinningNumber winningNumber = new WinningNumber(lotto);
        return winningNumber;
    }

    public void convertToInteger() {
        String[] winningNumber = Console.readLine().split(",");
        List<Integer> numbers = new ArrayList<Integer>();
        for (String s : winningNumber) {
            int number = Integer.parseInt(s);
            numbers.add(number);
        }
        lotto = new Lotto(numbers);
    }
}

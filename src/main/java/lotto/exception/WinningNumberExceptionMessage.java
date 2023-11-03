package lotto.exception;

import java.util.List;

public class WinningNumberExceptionMessage extends IllegalArgumentException{

    public WinningNumberExceptionMessage(String message){
        super(message);
    }

    public static void validateLottoNumberFormat(String input) {
        String pattern = "^\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2}$";

        if (!input.matches(pattern)) {
            throw new WinningNumberExceptionMessage("[ERROR] 로또 번호는 '1,2,3,4,5,6'과 같은 형식으로 입력해야 합니다.");
        }
    }

    public static void validateWinningNumberLength(List<Integer> winningNumber) {
        if (winningNumber.size() != 6) {
            throw new WinningNumberExceptionMessage("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }
}
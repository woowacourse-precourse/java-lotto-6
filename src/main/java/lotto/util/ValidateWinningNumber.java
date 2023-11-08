package lotto.util;

import java.util.ArrayList;
import java.util.List;

public class ValidateWinningNumber {

    private static List<Integer> winningNumberList;

    public static List<Integer> validateWinningNumber(String inputValue) {

        winningNumberList = new ArrayList<>();

        String[] winningNumberStringArray = inputValue.split(",");
        isSixNumber(winningNumberStringArray);

        for (String winningNumberString : winningNumberStringArray){
            int positiveInteger = ValidateNumber.isPositiveInteger(winningNumberString);
            isRange(positiveInteger);
            ValidateNumber.isDuplicate(winningNumberList);
            winningNumberList.add(positiveInteger);
        }

        return winningNumberList;
    }


    private static void isSixNumber(String[] winningNumber) {

        if (winningNumber.length != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해주세요.");
        }

    }

    private static void isRange(int WinningNumber) {

            if(WinningNumber < 1 || WinningNumber > 45){
                throw new IllegalArgumentException("[ERROR] 1~45 사이의 숫자를 입력해주세요.");
            }

    }

    public static void validateBonusNumber(String inputValue) {

        int bonusNumber = ValidateNumber.isPositiveInteger(inputValue);
        isRange(bonusNumber);

        if(winningNumberList.contains(bonusNumber)){
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 중복되는 보너스 번호를 입력할 수 없습니다.");
        }

    }

}

package lotto.exception;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;
import lotto.model.Playing;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputValidator {

    public static int checkPurchaseAmountInput(int purchaseAmount){

        int res = purchaseAmount % 1000;
        if (res != 0){
            throw new IllegalArgumentException();
        }
        int lottoCnt = purchaseAmount/1000;

        return lottoCnt;
    }

    public static List<Integer> checkWinningNumbersInput(){

        List<Integer> winningNumbers = new ArrayList<>();
        while(true){
            try{
                winningNumbers = Playing.inputWinningNumbers();
                if (!checkValidWinningNumbersRange(winningNumbers)) {
                    throw new IllegalArgumentException();
                }
                break;
            } catch(IllegalArgumentException e){
                System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }

        return winningNumbers;
    }

    public static boolean checkValidWinningNumbersRange(List<Integer> winningNumbers){
        for (Integer winningNumber : winningNumbers) {
            if (winningNumber < 1 || winningNumber > 45){
                return false;
            }
        }
        return true;
    }

    public static Integer checkValidBonusNumberInput(List<Integer> winningNumbers){
        Integer bonus = 0;
        while(true) {

        try{
            bonus = Playing.inputBonusNumber();
            if(winningNumbers.contains(bonus)){
                throw new IllegalArgumentException();
            }
            break;
        } catch(IllegalArgumentException e){
            System.out.println("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
        }
        }

        return bonus;
    }
}

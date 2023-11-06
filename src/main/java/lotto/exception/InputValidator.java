package lotto.exception;

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
                    System.out.println("pass");
                    throw new IllegalArgumentException();
                }
                break;
            } catch(IllegalArgumentException e){
                System.out.println("[ERROR] 입력된 번호가 범위를 벗어났습니다. 다시 입력해주세요.");
            }
        }

        return winningNumbers;
    }

    public static boolean checkValidWinningNumbersRange(List<Integer> winningNumbers){
        for (Integer winningNumber : winningNumbers) {
            if (winningNumber < 0 || winningNumber > 45){
                return false;
            }
        }
        return true;
    }
}

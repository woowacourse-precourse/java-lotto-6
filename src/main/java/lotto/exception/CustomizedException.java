package lotto.exception;

import lotto.view.InputView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CustomizedException {
    static final String ERROR_MESSAGE_INIT = "[ERROR] ";
    static final int WINNING_NUMBERS_SIZE = 6;

    public static void notDivisibleByThousandException(int price) {
        if (price % 1000 != 0 || price == 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE_INIT + "올바르지 않은 값입니다.다시 입력해주세요.");
        }
    }

    public static void winningNumbersSizeMoreOrLess(List<Integer> winningNumbers) {
        if (winningNumbers.size() != WINNING_NUMBERS_SIZE) {
            throw new IllegalArgumentException(ERROR_MESSAGE_INIT + "로또 번호는 총 6개를 입력하셔야합니다.");
        }
    }

    public static void winningNumbersNotRange(List<Integer> winningNumbers){
        for(int i = 0 ; i<winningNumbers.size();i++){
            if(winningNumbers.get(i)<1 || winningNumbers.get(i)>45){
                throw new IllegalArgumentException(ERROR_MESSAGE_INIT+"1부터45까지의 수만 입력 가능합니다.");
            }

        }
    }



}

package lotto;

import java.util.HashSet;
import java.util.List;

public class WinLotto {
    private final List<Integer> winNumbers;
    final int NUMBER_SIZE = 6;
    final int MAX_NUMBER = 45;
    final int MIN_NUMBER = 1;

    WinLotto(List<Integer> winNumbers){
        this.winNumbers = winNumbers;
    }

    private validateWinNumbers(List<Integer> winNumbers){
        final String RANGE_EXCEPTION_MESSAGE = "[ERROR] 로또 번호는 1~45 사이의 숫자여야합니다.";
        final String UNIQUE_NUMBER_EXCEPTION_MESSAGE ="[ERROR] 로또 번호는 중복되지 않아야합니다.";
        final String NUMBER_SIZE_EXCEPTION_MESSAGE = "[ERROR] 로또 번호는 6개입니다.";

        if (winNumbers.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException(NUMBER_SIZE_EXCEPTION_MESSAGE);
        }
        if(new HashSet<Integer>(winNumbers).size() != winNumbers.size()){
            throw new IllegalArgumentException(UNIQUE_NUMBER_EXCEPTION_MESSAGE);
        }
        for(Integer i : winNumbers){
            if(i > MAX_NUMBER || i < MIN_NUMBER){
                throw new IllegalArgumentException(RANGE_EXCEPTION_MESSAGE);
            }
        }
    }

    public List<Integer> getWinNumbers(){
        return winNumbers;
    }

}

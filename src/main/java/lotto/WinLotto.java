package lotto;

import java.util.ArrayList;
import java.util.List;

public class WinLotto {

    private List<Integer> numbers;
    private int bonusNumber;

    public WinLotto(String winNums, String bonusNumber) {

        this.numbers = changeNumbers(winNums);
        this.bonusNumber = ;
    }

    private List<Integer> changeNumbers(String winNums) {

        List<Integer> checkNums = new ArrayList<>();
        String[] winNumbers = winNums.split(",");
        for(int i = 0; i < winNumbers.length; i++) {

            checkNums.add(Integer.parseInt(winNumbers[i]));
        }

        validate(checkNums);
        return checkNums;
    }

    private void validate(List<Integer> checkNums) {

        validateSize(checkNums);
        validateNum(checkNums);

    }
}

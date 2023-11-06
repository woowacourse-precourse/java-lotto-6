package lotto.Domain;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

import lotto.Util.ExceptionTest;
import lotto.Util.Input;

public class LottoWinningNumber {
    private final Input input = new Input();
    private final ExceptionTest exceptionTest = new ExceptionTest();
    private List<Integer> userWinningNumber;
    private Integer userBonusNumber;

    public List<Integer> getWinningNumber(){
        String userInputWinningNumber = input.userInputWinningNumber();
        String[] winningNumber = userInputWinningNumber.split(",");
        exceptionTest.checkWinningCount(winningNumber);
        exceptionTest.checkDuplicate(winningNumber);

        return Arrays.stream(winningNumber).map(Integer::parseInt).collect(Collectors.toList());
    }


    public List<Integer> getUserWinningNumber(){
        return userWinningNumber;
    }

    public Integer getUserBonusNumber(){
        return userBonusNumber;
    }

    public LottoWinningNumber getWinningNumberResult(){
        this.userWinningNumber = getWinningNumber();
        this.userBonusNumber = getBonusNumber();
        return this;
    }

    public int getBonusNumber(){
        String userInputBonusNumber = input.userInputBonusNumber();
        return Integer.parseInt(userInputBonusNumber);
    }

}

package lotto.domain;

import lotto.view.ExceptionMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumber {

    private static  List<Integer> winningNums;

    private static  int bonusNum;


    public static  void getWinningNum(String winningNums) throws IllegalArgumentException{
        String[] winningNum = winningNums.split(",");
        List<Integer> winningNumbers = new ArrayList<>();
        for(int i=0; i<winningNum.length; i++){
            winningNumbers.add(Integer.valueOf(winningNum[i]));
        }
        WinningNumber.winningNums = winningNumbers;
    }

    private static void validate(List<Integer> winningNums){
        if(winningNums.size() != 6){
            throw new IllegalArgumentException(ExceptionMessage.inputWinningNumberSizeError.getErrorMessage());
        }
    }
}

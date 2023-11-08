package lotto.domain;

import lotto.view.ExceptionMessage;

import java.util.ArrayList;
import java.util.List;


public class WinningNumber {

    private   List<Integer> winningNums;

    private   int bonusNum;

    private WinningNumber() {
    }

    private static class WinningNumberHolder{
        private static final WinningNumber winningNumber = new WinningNumber();
    }
    public static WinningNumber getInstance(){
        return WinningNumberHolder.winningNumber;
    }

    public   void putWinningNums(String winningNums) throws IllegalArgumentException{
        String[] winningNum = winningNums.split(",");
        List<Integer> winningNumbers = new ArrayList<>();
        for(int i=0; i<winningNum.length; i++){
            validateRangeNum(Integer.valueOf(winningNum[i]));
            winningNumbers.add(Integer.valueOf(winningNum[i]));
        }
        this.winningNums = winningNumbers;
        validateSize(winningNumbers);
        duplicationValidate(winningNumbers);
    }

    public  void putBonusNum(String bonusNum) throws IllegalArgumentException{
        validateRangeNum(Integer.parseInt(bonusNum));
        duplicationBonusValidate(Integer.parseInt(bonusNum));
        this.bonusNum = Integer.parseInt(bonusNum);
    }

    public  List<Integer> getWinningNums() {
        return winningNums;
    }

    public  int getBonusNum() {
        return bonusNum;
    }

    private  void validateSize(List<Integer> winningNums){
        if(winningNums.size() != 6){
            throw new IllegalArgumentException(ExceptionMessage.inputWinningNumbersSizeError.getErrorMessage());
        }
    }

    private  void validateRangeNum(int number){
        if(number <1 || number >45){
            throw new IllegalArgumentException(ExceptionMessage.NumberRangeError.getErrorMessage());
        }

    }

    private  void duplicationValidate(List<Integer> numbers){
        if(numbers.size() != numbers.stream().distinct().count()){
            throw new IllegalArgumentException(ExceptionMessage.duplicationError.getErrorMessage());
        }
    }

    private  void duplicationBonusValidate(int number){
        if(winningNums.contains(number)){
            throw new IllegalArgumentException(ExceptionMessage.duplicationError.getErrorMessage());
        }
    }


}

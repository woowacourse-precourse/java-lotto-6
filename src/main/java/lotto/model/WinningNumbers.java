package lotto.model;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.ErrorMessages;
import lotto.validator.WinningNumbersValiator;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {
    int bonusNumber;
    List<Integer> winningNumbers;
    private String ERROR_MESSAGE_COMMA_NUMBERS= ErrorMessages.ERROR_MESSAGE_COMMA_NUMBERS.getMessage();
    private String ERROR_MESSAGE_BONUS_NUMBER = ErrorMessages.ERROR_MESSAGE_BONUS_NUMBER.getMessage();


    public WinningNumbers() {
    }

    public List<Integer> getWinningNumbers(){
        return winningNumbers;
    }
    public int getBonusNumber(){
        return this.bonusNumber;
    }

    public void askCommonWinningNumbers() {
        while(true){
            String winningNumbersBeforeSplit = readNumbersWithoutBlank();
            try{
                checkCommonNumbersFormat(winningNumbersBeforeSplit);
                List<Integer> splitedCommonNumbers = splitWinningNumbersByComma(winningNumbersBeforeSplit);
                saveCommonNumbers(splitedCommonNumbers);
                break;
            }catch (IllegalArgumentException e){
                System.out.println(ERROR_MESSAGE_COMMA_NUMBERS);
            }
        }
    }

    public String readNumbersWithoutBlank(){
        String numbers = Console.readLine();
        return numbers.replace(" ","");
    }

    public void checkCommonNumbersFormat(String winningNumbersBeforeSplit){
        WinningNumbersValiator.IsContainEssentialComma(winningNumbersBeforeSplit);
    }

    public List<Integer> splitWinningNumbersByComma(String winningNumbersBeforeSplit) {

        List<Integer> tempWinningNumbers = new ArrayList<>();
        String[] splitedWinningNumber = winningNumbersBeforeSplit.split(",");

        for (String str : splitedWinningNumber) {
            int number = Integer.parseInt(str);
            tempWinningNumbers.add(number);
        }
        return tempWinningNumbers;
    }

    public void saveCommonNumbers(List<Integer> splitedCommonNumbers){
        WinningNumbersValiator.validateSplitedCommonNumbers(splitedCommonNumbers);
        this.winningNumbers = splitedCommonNumbers;
    }


    public void askBonusNumber(){
        while(true){
            String bonusNumberBeforeValidate = readNumbersWithoutBlank();
            try{
                checkBonusNumber(bonusNumberBeforeValidate);
                int bonusNumber = Integer.parseInt(bonusNumberBeforeValidate);
                saveBonusNumber(bonusNumber);
                break;
            }catch (IllegalArgumentException e){
                System.out.println(ERROR_MESSAGE_BONUS_NUMBER);
            }
        }
    }

    public void checkBonusNumber(String bonusNumberBeforeValidate){
        WinningNumbersValiator.checkBonusNumberLength(bonusNumberBeforeValidate);
    }

    public void saveBonusNumber(int bonusNumber){
        WinningNumbersValiator.checkIsInRange(bonusNumber);
        checkBonusNumberIsUnique(bonusNumber);
        this.winningNumbers.add(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public void checkBonusNumberIsUnique(int bonusNumber){
        List<Integer> tempWinningNumberAddBonus = new ArrayList<>(winningNumbers);
        tempWinningNumberAddBonus.add(bonusNumber);
        WinningNumbersValiator.checkIsNumberUnique(tempWinningNumberAddBonus);
    }
}
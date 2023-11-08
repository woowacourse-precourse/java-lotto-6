package lotto.model;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.valiator;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {
    List<Integer> winningNumbers;
    private String ERROR_MESSAGE_COMMA_NUMBERS= "[ERROR] 올바른 형식(콤마 분리로 분리된 숫자형)으로 당첨 번호를 입력해 주세요";
    private String ERROR_MESSAGE_BONUS_NUMBER = "[Error] 올바른 형식(하나의 숫자로 이뤄진 숫자형)으로 보너스 번호를 입력해 주세요.";


    public WinningNumbers() {
    }

    public List<Integer> getWinningNumbers(){
        return winningNumbers;
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
        valiator.IsContainEssentialComma(winningNumbersBeforeSplit);
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
        valiator.validateSplitedCommonNumbers(splitedCommonNumbers);
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
        valiator.checkBonusNumberLength(bonusNumberBeforeValidate);
    }

    public void saveBonusNumber(int bonusNumber){
        valiator.checkIsInRange(bonusNumber);
        checkBonusNumberIsUnique(bonusNumber);
        this.winningNumbers.add(bonusNumber);
    }

    public void checkBonusNumberIsUnique(int bonusNumber){
        List<Integer> tempWinningNumberAddBonus = new ArrayList<>(winningNumbers);
        tempWinningNumberAddBonus.add(bonusNumber);
        valiator.checkIsNumberUnique(tempWinningNumberAddBonus);
    }
}
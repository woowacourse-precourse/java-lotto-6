package lotto.model;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.WinningNumbersValidations;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {
    List<Integer> winningNumbers;

    public WinningNumbers() {
    }

    public List<Integer> getWinningNumbers(){
        return winningNumbers;
    }

    public void generateWinningNumbers() {
        askWinningNumbers();
        askBonusNumber();
        validateWinningNumbers(winningNumbers);
    }

    public void askWinningNumbers() {
        String winningNumbersBeforeSplit = removeBlank(requestWinningNumbers());
        validateCanSplitWinningNumbersByComma(winningNumbersBeforeSplit);
        List<Integer> splitedWinningNumbers = splitWinningNumbersByComma(winningNumbersBeforeSplit);
        this.winningNumbers = splitedWinningNumbers;
    }

    public String removeBlank(String str){
        return str.replace(" ","");
    }

    public void askBonusNumber(){
        String bonusNumberBeforeValidate = removeBlank(requestBonusNumber());
        validateBonusNumbers(bonusNumberBeforeValidate);
        int bonusNumber = Integer.parseInt(bonusNumberBeforeValidate);
        this.winningNumbers.add(bonusNumber);
    }
    public String requestWinningNumbers(){
        return Console.readLine();
    }
    public String requestBonusNumber(){
        return Console.readLine();
    }

    public List<Integer> splitWinningNumbersByComma(String winningNumbersBeforeSplit) {
        List<Integer> splitedWinningNumbers = splitWinningNumbers(winningNumbersBeforeSplit);
        return splitedWinningNumbers;
    }

    public void validateCanSplitWinningNumbersByComma(String winningNumbersBeforeSplit) {
        try {
            WinningNumbersValidations.IsContainEssentialComma(winningNumbersBeforeSplit);
        } catch (IllegalArgumentException e) {
            System.out.println("[Error] 콤마를 기준으로 당첨 번호를 입력해 주세요.");
            askWinningNumbers();
        }
    }


    public List<Integer> splitWinningNumbers(String winningNumbersBeforeSplit) {
        List<Integer> tempWinningNumbers = new ArrayList<>();
        String[] tempSplitedWinningNumber = winningNumbersBeforeSplit.split(",");
        for (String number : tempSplitedWinningNumber) {
            checkIsNumeric(number,"WinningNumbers");
            tempWinningNumbers.add(Integer.parseInt(number));
        }
        return tempWinningNumbers;
    }

    public void checkIsNumeric(String number,String numberType) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            if(numberType == "BonudNumber"){
                System.out.println("[Error] 보너스 번호는 숫자로 입력해 주세요.");
                askBonusNumber();
            }else if(numberType == "WinningNumbers"){
                System.out.println("[Error] 당첨 번호는 숫자로 입력해 주세요.");
                askWinningNumbers();
            }
        }
    }


    // 보너스 번호 단독 유효성 검사
    public void validateBonusNumbers(String bonusNumberBeforeValidate){
        validateParseInt(bonusNumberBeforeValidate);
        validateLength(bonusNumberBeforeValidate);
    }


    public void validateParseInt(String bonusNumberBeforeValidate) {
        try {
            checkIsNumeric(bonusNumberBeforeValidate,"BonudNumber");
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 보너스 번호는 숫자형으로 입력해 주세요.");
            askBonusNumber();
        }
    }

    public void validateLength(String bonusNumberBeforeValidate){
        try {
            if (bonusNumberBeforeValidate.length() != 1) {
                throw new IllegalArgumentException();
            }
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR] 보너스 번호는 한 개만 입력해 주세요.");
            askBonusNumber();
        }
    }

    //6자리 + 보너스번호 유효성 검사
    public void validateWinningNumbers(List<Integer> winningNumbers) throws IllegalArgumentException{
        validateWinningNumbersUnique(winningNumbers);
        validateWinningNumbersInRange(winningNumbers);
    }

    public void validateWinningNumbersUnique(List<Integer> winningNumbers) {
        try{
            WinningNumbersValidations.checkWinningNumbersUnique(winningNumbers);
        }catch (IllegalArgumentException e){
            System.out.println("[Error] 중복된 당첨 번호가 입력되었습니다.");
            generateWinningNumbers();
        }
    }

    public void validateWinningNumbersInRange(List<Integer> winningNumbers) {
        try {
            WinningNumbersValidations.checkIsInRange(winningNumbers);
        }catch (IllegalArgumentException e){
            System.out.println("[Error] 당첨 번호가 범위를 벗어났습니다.");
            generateWinningNumbers();
        }
    }
}
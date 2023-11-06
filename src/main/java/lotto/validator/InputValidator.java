package lotto.validator;


import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import lotto.constants.Constants;
import lotto.utils.Utils;

public class InputValidator {
    private int totalMoney;
    private List<Integer> winningNumbers;

    public int checkAll(String money) throws IllegalArgumentException{
        checkInteger(money);
        totalMoney = Utils.makeStringToInteger(money);
        checkRemainder(totalMoney);
        return totalMoney;

    }

    public void checkRemainder (int number) throws IllegalArgumentException{
        if(number % Constants.LOTTO_PRICE != Constants.ZERO){
             throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해 주세요");
        }
    }
    public void checkInteger (String number) throws IllegalArgumentException{
        if(!Constants.INTEGER.matcher(number).matches()){
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요");
        }
    }

    public List<Integer> checkWinningNumber(String winningNumber)throws IllegalArgumentException{
        checkLastCommas(winningNumber);
        List<String> stringwinningnumbers = Utils.makeStringtoArray(winningNumber);
        checkLetterAndBlank(stringwinningnumbers);
        winningNumbers = Utils.makeStringArraytoIntegerArray(stringwinningnumbers);
        checkWinningNumberLong(winningNumbers);
        checkDuplicateWinningNumber(winningNumbers);
        checkWinningNumberRange(winningNumbers);
        return winningNumbers;
    }
    public void checkLastCommas(String stringNumber) throws IllegalArgumentException{
        if(stringNumber.endsWith(Constants.COMMAS)){
            throw new IllegalArgumentException("[ERROR] 맨 뒤에 쉼표를 쓰지 마세요.");
        }
    }
    public void checkDuplicateWinningNumber(List<Integer> winningNumbers) throws IllegalArgumentException{
        long number = winningNumbers.stream().distinct().count();
        if(winningNumbers.size() != number){
            throw new IllegalArgumentException("[ERROR] 중복되는 숫자를 입력하지 마세요");
        }

    }
    public void checkWinningNumberRange(List<Integer> numbers) throws IllegalArgumentException{
        if(Collections.max(numbers) > Constants.MAX_LOTTO_NUMBER || Collections.min(numbers )< Constants.ONE){
             throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
    public void checkLetterAndBlank(List<String> strings){
        for(String number : strings){
            if(!Constants.INTEGER.matcher(number).matches() || number.isBlank()){
                throw new IllegalArgumentException("[ERROR] 공백 없이 숫자를 입력해 주세요");
            }
        }
    }
    public void checkWinningNumberLong(List<Integer> strings){
        if (strings.size() != Constants.MAX_LOTTO_PICK_NUMBER ){
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해 주세요");
        }
    }
    public int checkBonusNumber(String number) throws IllegalArgumentException{
        checkBonusInteger(number);
        int bonusNumber =  Utils.makeStringToInteger(number);
        return bonusNumber;
    }
    public void checkBonusInteger (String number) throws IllegalArgumentException{
        if(!Constants.INTEGER.matcher(number).matches()){
            throw new IllegalArgumentException("[ERROR] 숫자를 한개만 입력해 주세요");
        }
    }
}

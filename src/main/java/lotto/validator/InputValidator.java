package lotto.validator;


import java.util.List;
import lotto.constants.Constants;
import lotto.utils.Utils;

public class InputValidator {
    private int totalMoney;

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

        List<String> stringwinningnumbers = Utils.makeStringtoArray(winningNumber);
        List<Integer> winningNumbers = Utils.makeStringArraytoIntegerArray(stringwinningnumbers);
        if (winningNumbers.size() != Constants.MAX_LOTTO_PICK_NUMBER ){
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해 주세요");
        }return winningNumbers;
    }




}

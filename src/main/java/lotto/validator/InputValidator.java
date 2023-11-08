package lotto.validator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.controller.LottoController;

public class InputValidator {

    LottoRule lottoRule = new LottoRule();

    public boolean checkPriceInputInteger(String input){
        int intInput;
        try {
            intInput = Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(InputErrorMessage.INPUT_VALUE_INTEGER_ERROR);
            return false;
        }

        return checkPriceInputRange(intInput);
    }
    public boolean checkPriceInputRange(int input){
        if(input<0) {
            System.out.println(InputErrorMessage.INPUT_DIVIDE_ERROR);
            return false;
        }
        if(input>2000000000){
            System.out.println(InputErrorMessage.MAX_INPUT_VALUE_ERROR);
            return false;
        }

        return checkPriceInputDivide(input);
    }

    public boolean checkPriceInputDivide(int input){
        if(input%1000 !=0){
            System.out.println(InputErrorMessage.INPUT_DIVIDE_ERROR);
            return false;
        }
        return true;
    }
    public boolean checkWinningNumberInputInteger(List<String> input){
        List<Integer> winningNumber = new ArrayList<>();

        int number=0;
        for (String str : input) {
            try {
                number = Integer.parseInt(str);
            }
            catch(IllegalArgumentException e){
                System.out.println(InputErrorMessage.LOTTO_NUMBER_IS_INTEGER);
                return false;
            }
            winningNumber.add(number);
        }

        return checkWinningNumberInputLength(winningNumber);
    }
    public boolean checkWinningNumberInputLength(List<Integer> winningNumber){
        if(winningNumber.size()!=lottoRule.LOTTO_NUMBER_LENGTH){
            System.out.println(InputErrorMessage.LOTTO_NUMBER_INPUT_ERROR);
            return false;
        }
        return checkWinningNumberInputRange(winningNumber);
    }

    public boolean checkWinningNumberInputRange(List<Integer> winningNumber){
        for(int number : winningNumber){
            if (number < 1 || number > 45) {
                System.out.println(InputErrorMessage.LOTTO_NUMBER_RANGE_ERROR);
                return false;
            }
        }
        return checkWinningNumberDuplicate(winningNumber);
    }

    public boolean checkWinningNumberDuplicate(List<Integer> winningNumber){
        Set<Integer> set = new HashSet<>(); // 중복된 값 체크를 위한 Set
        for (int number : winningNumber) {
            if (!set.add(number)) {
                System.out.println(InputErrorMessage.LOTTO_BONUS_NUMBER_DUPLICATE_ERROR);
                return false;
            }
        }
        return true;
    }



    public boolean checkBonusInputInteger(String input,List<Integer> winningNumbers){
        int intInput;
        try {
            intInput = Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(InputErrorMessage.INPUT_VALUE_INTEGER_ERROR);
            return false;
        }
        return checkBonusInputRange(intInput,winningNumbers);
    }

    public boolean checkBonusInputRange(int number,List<Integer> winningNumbers){
        if (number < 1 || number > 45) {
            System.out.println(InputErrorMessage.LOTTO_NUMBER_RANGE_ERROR);
            return false;
        }
        return checkWinningNumberIncludeBonusNumber(number,winningNumbers);
    }

    public boolean checkWinningNumberIncludeBonusNumber(int number,List<Integer> winningNumbers){
        if(winningNumbers.contains(number)){
            System.out.println(InputErrorMessage.LOTTO_NUMBER_DUPLICATE_ERROR);
            return false;
        }
        return true;
    }


}

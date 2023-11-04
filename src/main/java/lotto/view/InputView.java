package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.util.CommonInputValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final Money MONEY_ERROR_CODE = null;
    private static final Lotto SIX_NUMBERS_ERROR_CODE = null;
    private static final Integer BONUS_NUMBER_ERROR_CODE = -1;

    public Money inputMoney(){
        String input = Console.readLine();
        try{
            CommonInputValidator.isNumericValidator(input);
            Integer amount = Integer.parseInt(input);
            return new Money(amount);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return MONEY_ERROR_CODE;
        }
    }
    public Lotto inputSixNumbers(){
        String input = Console.readLine();
        List<Integer> numbers = new ArrayList<>();
        try{
            List<String> parsedNumbers = parseNumbersFromInput(input);
            for(String parsedNumber : parsedNumbers){
                CommonInputValidator.isNumericValidator(parsedNumber);
                Integer number = Integer.parseInt(parsedNumber);
                CommonInputValidator.isInRangeValidator(number);
                numbers.add(number);
            }
            return new Lotto(numbers);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return SIX_NUMBERS_ERROR_CODE;
        }
    }

    public Integer inputBonusNumber(Lotto lotto){
        String input = Console.readLine();
        List<Integer> numbers = lotto.getNumbers();
        try{
            CommonInputValidator.isNumericValidator(input);
            Integer bonusNumber = Integer.parseInt(input);
            CommonInputValidator.isInRangeValidator(bonusNumber);
            CommonInputValidator.isNotOverlapBonusValidator(numbers, bonusNumber);
            return bonusNumber;
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return BONUS_NUMBER_ERROR_CODE;
        }
    }

    private List<String> parseNumbersFromInput(String input){
        String[] numbers = input.split(",", -1);
        // convert array type into list type
        return new ArrayList<>(Arrays.asList(numbers));
    }
}

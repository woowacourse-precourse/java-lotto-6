package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;
import lotto.util.InputValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final Integer MONEY_ERROR_CODE = -1;
    private static final Lotto SIX_NUMBERS_ERROR_CODE = null;

    public Integer inputMoney(){
        String input = Console.readLine();
        try{
            InputValidator.isNumericValidator(input);
            Integer money = Integer.parseInt(input);
            InputValidator.isMinimumValidator(money);
            InputValidator.isThousandUnitValidator(money);
            return money;
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
                InputValidator.isNumericValidator(parsedNumber);
                Integer number = Integer.parseInt(parsedNumber);
                InputValidator.isInRangeValidator(number);
                numbers.add(number);
            }
            InputValidator.isNotOverlapSixValidator(numbers);
            return new Lotto(numbers);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return SIX_NUMBERS_ERROR_CODE;
        }
    }

    public void inputBonusNumber(){}

    private List<String> parseNumbersFromInput(String input){
        String[] numbers = input.split(",", -1);
        // convert array type into list type
        return new ArrayList<>(Arrays.asList(numbers));
    }
}

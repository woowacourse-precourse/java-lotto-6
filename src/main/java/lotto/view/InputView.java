package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.util.CommonInputValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class InputView {
    private static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String SIX_NUMBERS_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static Optional<Money> inputMoney(){
        System.out.println(MONEY_INPUT_MESSAGE);
        String input = Console.readLine();
        try{
            CommonInputValidator.isNumericValidator(input);
            Integer amount = Integer.parseInt(input);
            return Optional.of(new Money(amount));
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }
    public static Optional<Lotto> inputSixNumbers(){
        System.out.println(SIX_NUMBERS_INPUT_MESSAGE);
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
            return Optional.of(new Lotto(numbers));
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }

    public static Optional<Bonus> inputBonusNumber(Lotto lotto){
        System.out.println(BONUS_INPUT_MESSAGE);
        String input = Console.readLine();
        try{
            CommonInputValidator.isNumericValidator(input);
            Integer number = Integer.parseInt(input);
            CommonInputValidator.isInRangeValidator(number);
            List<Integer> numbers = lotto.getNumbers();
            return Optional.of(new Bonus(numbers, number));
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }

    private static List<String> parseNumbersFromInput(String input){
        String[] numbers = input.split(",", -1);
        // convert array type into list type
        return new ArrayList<>(Arrays.asList(numbers));
    }
}

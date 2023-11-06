package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class LottoInput {

    public int lottoPurchaseInput(){
        String lottoPurchasePrice = Console.readLine();
        return Integer.parseInt(lottoPurchasePrice);
    }

    private List<String> parseByComma(String input){
        List<String> parsedInput = Arrays.stream(input.split(",")).map(String::trim).toList();
        InputValidator.isListEmpty(parsedInput);
        parsedInput.forEach(InputValidator::isInputValid);

        return parsedInput;
    }
}

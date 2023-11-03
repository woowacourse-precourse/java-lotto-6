package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.constant.ErrorMessage;
import lotto.service.InputService;
import lotto.service.ValidateService;

public class LottoWinningNumbers {
    private final InputService inputService = new InputService();
    private final ValidateService validateService = new ValidateService();
    private List<Integer> winningNumbers;

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public List<Integer> inputWinningNumbers(){
        List<String> inputValues = Arrays.asList(inputService.inputValue().split(","));
        List<Integer> winningNumbers = new ArrayList<>();
        for(String value: inputValues){
            try {
                int number = Integer.parseInt(value.trim());
                validateService.validateInputWinningNumbersAll(number);
                winningNumbers.add(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ErrorMessage.INPUT_NUMBER_ERROR.getMessage());
            }
        }
        return winningNumbers;
    }
}

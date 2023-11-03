package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.constant.ErrorMessage;
import lotto.service.InputService;
import lotto.service.MessageService;
import lotto.service.ValidateService;

public class LottoWinningNumbers {
    private final InputService inputService = new InputService();
    private final ValidateService validateService = new ValidateService();
    private final MessageService messageService = new MessageService();
    private int bonusNumber;
    private List<Integer> winningNumbers;

    public LottoWinningNumbers getWinningNumbersInfo(){
        this.winningNumbers = getWinningNumbers();
        this.bonusNumber = getBonusNumber();
        return this;
    }
    public List<Integer> getWinningNumbers() {
        messageService.inputWinningNumberMessage();
        while (true) {
            try {
                List<String> inputValues = Arrays.asList(inputService.inputValue().split(","));
                List<Integer> winningNumbers = separateNumbers(inputValues);
                validateService.validateInputWinningNumbersAll(winningNumbers);
                return winningNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> separateNumbers(List<String> inputValues) {
        winningNumbers = new ArrayList<>();
        for (String value : inputValues) {
            try {
                int number = Integer.parseInt(value.trim());
                winningNumbers.add(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ErrorMessage.INPUT_NUMBER_ERROR.getMessage());
            }
        }
        return winningNumbers;
    }

    public int getBonusNumber() {
        messageService.inputBonusNumberMessage();
        while (true) {
            try {
                bonusNumber = validateService.validateNumber(inputService.inputValue());
                validateService.validateBonusNumber(bonusNumber,winningNumbers);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}

package lotto.broadcaster;

import lotto.message.ErrorMessage;
import lotto.message.Message;
import lotto.utils.CustomScanner;
import lotto.utils.Validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Broardcaster {
    public List<Integer> pickLotteryNumbers() {
        System.out.println(Message.INPUT_LOTTERY_NUMBERS);
        String inputLotteryNumbers = CustomScanner.getReadLine();
        try {
            validateInputLotteryNums(inputLotteryNumbers);
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            return pickLotteryNumbers();
        }
        System.out.println();
        return getListFromArray(inputLotteryNumbers.split(","));
    }

    private void validateInputLotteryNums(String inputLotteryNumbers) {
        if (!Validator.validateLotteryNumbersAndSize(inputLotteryNumbers)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTERY_NUMBERS.getMessage());
        }
        if (Validator.isDuplicateLotteryNumbers(inputLotteryNumbers.split(","))) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTERY_NUMBERS.getMessage());
        }
    }

    private List<Integer> getListFromArray(String[] parseResult) {
        List<Integer> result = new ArrayList<>();
        Arrays.stream(parseResult)
            .forEach(num -> result.add(Integer.parseInt(num)));
        return result;
    }

    public int pickBonusNumber(List<Integer> lotteryNumbers) {
        System.out.println(Message.INPUT_BONUS_NUMBER);
        String inputBonusNumber = CustomScanner.getReadLine();
        try {
            validateInputBonusNumber(inputBonusNumber, lotteryNumbers);
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            return pickBonusNumber(lotteryNumbers);
        }
        System.out.println();
        return Integer.parseInt(inputBonusNumber);
    }

    private void validateInputBonusNumber(String inputBonusNumber, List<Integer> lotteryNumbers) {
        if (!Validator.validateBonusNumber(inputBonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER.getMessage());
        }
        if (Validator.isDuplicateAllNumbers(lotteryNumbers, Integer.parseInt(inputBonusNumber))) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_BONUS_NUMBER.getMessage());
        }
    }
}

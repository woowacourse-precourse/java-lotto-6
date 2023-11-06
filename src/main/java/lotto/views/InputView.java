package lotto.views;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.global.ErrorMessage;
import lotto.global.Utils;

public class InputView {
    public static final String PURCHASE_AMOUNT_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String WINNING_NUMBER_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";

    public long getPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_INPUT_MESSAGE);
        String input = Console.readLine();
        Utils.checkNumber(input);
        return Long.parseLong(input);
    }


    Set<Integer> validateWinningNumbers(List<Integer> inputWinningNumbers){
        if(inputWinningNumbers.size() != 6){
            throw new IllegalArgumentException(ErrorMessage.NOT_MET_LOTTO_NUMBERS_LENGTH.getMessage());
        }
        Set<Integer> uniqueWinningNumbers = inputWinningNumbers.stream().collect(Collectors.toSet());
        // 중복 제거 후 개수 비교
        if(inputWinningNumbers.size() != uniqueWinningNumbers.size()){
            throw new IllegalArgumentException(ErrorMessage.NOT_MET_LOTTO_NUMBERS_LENGTH.getMessage());
        }
        for (Integer originalWinningNumber : uniqueWinningNumbers) {
            validateLottoRange(originalWinningNumber);
        }
        return uniqueWinningNumbers;
    }

    public Set<Integer> getOriginalWinningNumbers() {
        System.out.println(WINNING_NUMBER_INPUT_MESSAGE);
        String input = Console.readLine();
        if(!Utils.WINNING_NUMBER_CHECK_PATTERN.matcher(input).matches()){
            throw new IllegalArgumentException(ErrorMessage.NOT_MET_WINNING_NUMBER_REGEX.getMessage());
        }
        String[] inputNumbers = input.split(",");

        List<Integer> originalWinningNumbers = new ArrayList<>();
        for (int i = 0; i < inputNumbers.length; i++) {
            String number = inputNumbers[i];
            originalWinningNumbers.add(Integer.parseInt(number));
        }

        return validateWinningNumbers(originalWinningNumbers);
    }

    public int getBonusNumber(Set<Integer> originalWinningNumbers) {
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
        String input = Console.readLine();

        Utils.checkNumber(input);
        int bonusNumber = Integer.parseInt(input);

        validateBonusNumber(originalWinningNumbers, bonusNumber);
        return bonusNumber;
    }


    void validateBonusNumber(Set<Integer> originalWinningNumbers, int bonusNumber) {
        validateLottoRange(bonusNumber);
        if (originalWinningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_CONTAINS_BONUS_NUMBER_IN_WINNING_NUMBERS.getMessage());
        }
    }

    void validateLottoRange(int number) {
        if (!(1 <= number && number <= 45)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_MET_LOTTO_NUMBERS_RANGE.getMessage());
        }
    }
}

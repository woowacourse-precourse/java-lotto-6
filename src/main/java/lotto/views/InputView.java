package lotto.views;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.Set;
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

    public Set<Integer> getOriginalWinningNumbers() {
        System.out.println(WINNING_NUMBER_INPUT_MESSAGE);
        String[] input = Console.readLine().split(",");
        if(input.length != 6) {
            throw new IllegalArgumentException(ErrorMessage.NOT_MET_LOTTO_NUMBERS_LENGTH.getMessage());
        }

        Set<Integer> originalWinningNumbers = new HashSet<>();
        for (int i = 0; i < input.length; i++) {
            String number = input[i];
            Utils.checkNumber(number);
            originalWinningNumbers.add(Integer.parseInt(number));
        }

        validateWinningNumbers(originalWinningNumbers);
        return originalWinningNumbers;
    }

    public int getBonusNumber(Set<Integer> originalWinningNumbers) {
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
        String input = Console.readLine();

        Utils.checkNumber(input);
        int bonusNumber = Integer.parseInt(input);

        validateBonusNumber(originalWinningNumbers, bonusNumber);
        return bonusNumber;
    }

    void validateWinningNumbers(Set<Integer> originalWinningNumbers){
        if(originalWinningNumbers.size() != 6){
            throw new IllegalArgumentException(ErrorMessage.NOT_MET_LOTTO_NUMBERS_LENGTH.getMessage());
        }
        for (Integer originalWinningNumber : originalWinningNumbers) {
            validateLottoRange(originalWinningNumber);
        }
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

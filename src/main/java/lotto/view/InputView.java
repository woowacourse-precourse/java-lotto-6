package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.enums.ErrorMessageEnum;
import lotto.enums.InputMessageEnum;

public class InputView {

    public int inputPurchasePrice() {
        System.out.println(InputMessageEnum.INPUT_PURCHASE_PRICE_MESSAGE.getMessage());
        String amount = Console.readLine();
        // validate(amount); // TODO : 검증 로직 작성
        return Integer.parseInt(amount);
    }

    public List<Integer> inputWinningNumbers(int lottoCount) {
        List<Integer> winningNumbers = new ArrayList<>();
        try {
            System.out.println(InputMessageEnum.INPUT_WINNING_NUMBERS_MESSAGE.getMessage());
            String numbers = Console.readLine();
            validateWinningNumbers(numbers, lottoCount); // TODO : 검증 로직 생성
            String[] splittedNumbers = numbers.split(",");

            for (String number : splittedNumbers) {
                winningNumbers.add(Integer.parseInt(number));
            }
        } catch (Exception e) {
            inputWinningNumbers(lottoCount);
        }
        return winningNumbers;
    }

    public int inputBonusNumber() {
        System.out.println(InputMessageEnum.INPUT_BONUS_NUMBER_MESSAGE.getMessage());
        String number = Console.readLine();
        // validate(number); // TODO : 검증 로직 생성
        return Integer.parseInt(number);
    }

    private void validateWinningNumbers(String numbers, int lottoCount) {
        String[] numbersSplitted = numbers.split(",");
        if (numbersSplitted.length != lottoCount) {
            System.out.println(ErrorMessageEnum.ERROR_LOTTO_COUNT_MESSAGE.getMessage());
            throw new IllegalArgumentException();
        }
        Set<Integer> uniqueNumbers;
        try {
            uniqueNumbers = Arrays.stream(numbersSplitted).map(Integer::parseInt).collect(Collectors.toSet());
            if (uniqueNumbers.size() != lottoCount) {
                System.out.println(ErrorMessageEnum.ERROR_LOTTO_NOT_UNIQUE_MESSAGE.getMessage());
                throw new IllegalArgumentException();
            }
        } catch (Exception e) {
            System.out.println(ErrorMessageEnum.ERROR_LOTTO_NOT_NUMBER_MESSAGE.getMessage());
            throw new IllegalArgumentException();
        }
    }
}

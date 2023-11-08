package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.message.InputMessage;
import lotto.validator.BonusNumberValidator;
import lotto.validator.LottoNumbersValidator;
import lotto.validator.PriceValidator;
import lotto.validator.Validator;

public class InputView {
    public int inputBuyingPrice() {
        while (true) {
            try {
                return Integer.parseInt(getBuyingPrice());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Lotto inputWinningLottoNumbers() {
        while (true) {
            try {
                return new Lotto(getLottoNumbers());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int inputBonusNumber(Lotto lotto) {
        while (true) {
            try {
                return getBonusNumber(lotto);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String getBuyingPrice() {
        System.out.println(InputMessage.INPUT_MONEY_NOTICE.getValue());
        String buyingPrice = Console.readLine();
        PriceValidator.validate(buyingPrice);
        System.out.println();

        return buyingPrice;
    }

    public List<Integer> getLottoNumbers() {
        System.out.println(InputMessage.INPUT_WINNING_NUMBER_NOTICE.getValue());
        List<String> inputNumbers = Arrays.stream(readLine().split(InputMessage.INPUT_DELIMITER.getValue()))
                .map(String::trim)
                .toList();
        inputNumbers.forEach(Validator::validateNumber);
        LottoNumbersValidator.validate(convertToNumbers(inputNumbers));
        return convertToNumbers(inputNumbers);
    }

    public int getBonusNumber(Lotto lotto) {
        System.out.println(InputMessage.INPUT_BONUS_NUMBER_NOTICE.getValue());
        String inputNumber = readLine();
        Validator.validateNumber(inputNumber);

        BonusNumberValidator.validate(lotto,Integer.parseInt(inputNumber));
        return Integer.parseInt(inputNumber);
    }

    private static List<String> readLineAndSplitWith(final String delimiter) {
        return Arrays.stream(readLine().split(delimiter))
                .map(String::trim)
                .toList();
    }

    private static List<Integer> convertToNumbers(final List<String> inputNumbers) {
        return inputNumbers.stream()
                .map(Integer::parseInt)
                .toList();
    }

}



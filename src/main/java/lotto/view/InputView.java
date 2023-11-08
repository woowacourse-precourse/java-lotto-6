package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.enums.Message;
import lotto.validator.BonusNumberValidator;
import lotto.validator.LottoNumberValidator;
import lotto.validator.Validator;

public class InputView {
    public int purchaseLotto() {
        while (true) {
            try {
                return Integer.parseInt(getBuyingPrice());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Lotto inputLottoNumbers() {
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
        System.out.println(Message.INPUT_PRICE_MESSAGE.getValue());
        String buyingPrice = Console.readLine();
        Validator.validatePrice(buyingPrice);
        System.out.println();

        return buyingPrice;
    }

    public List<Integer> getLottoNumbers() {
        System.out.println(Message.INPUT_NUMBERS_MESSAGE.getValue());
        List<String> inputNumbers = Arrays.stream(readLine().split(Message.COMMA_SEPARATOR.getValue()))
                .map(String::trim)
                .toList();
        inputNumbers.forEach(Validator::validateNumber);
        LottoNumberValidator.validate(convertToNumbers(inputNumbers));
        System.out.println();

        return convertToNumbers(inputNumbers);
    }

    public int getBonusNumber(Lotto lotto) {
        System.out.println(Message.INPUT_BONUS_NUMBER_MESSAGE.getValue());
        String inputNumber = readLine();
        Validator.validateNumber(inputNumber);

        BonusNumberValidator.validate(lotto,Integer.parseInt(inputNumber));
        System.out.println();

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
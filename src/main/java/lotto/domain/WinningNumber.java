package lotto.domain;

import java.util.Arrays;
import java.util.List;
import lotto.util.ErrorMessage;
import lotto.util.Validator;

public class WinningNumber {
    private static final String SEPARATOR = ",";
    private final Lotto lotto;

    public WinningNumber(String numbers) {
        validateWinningNumberInput(numbers);
        List<Integer> lottoNumbers = stringToIntList(numbers);

        this.lotto = new Lotto(lottoNumbers);
    }

    public LottoRanking calculateLottoRanking(Lotto purchaseLotto, BonusNumber bonusNumber) {
        int count = purchaseLotto.countMatchingLottoNumbers(lotto);
        boolean isBonus = purchaseLotto.containsNumber(bonusNumber.getBonus());
        return LottoRanking.valueOf(count, isBonus);
    }

    public Lotto getLotto() {
        return lotto;
    }

    private static void validateWinningNumberInput(String input) {
        Validator.validateInputNotEmpty(input);
        Validator.validateInputWithSeparator(input);
    }

    private List<Integer> stringToIntList(String numbers) {
        return Arrays.stream(numbers.split(SEPARATOR))
                .map(String::trim)
                .map(this::parseInt)
                .toList();
    }

    private int parseInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            ErrorMessage.printNotNumericNumberErrorMessage();
            throw new IllegalArgumentException();
        }
    }
}
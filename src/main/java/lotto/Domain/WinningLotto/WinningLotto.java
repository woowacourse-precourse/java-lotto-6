package lotto.Domain.WinningLotto;

import static lotto.CommonValidation.CommonValidation.hasBlank;
import static lotto.CommonValidation.CommonValidation.isInteger;
import static lotto.CommonValidation.CommonValidation.isValueBetween1And45;
import static lotto.Message.ExceptionMessage.LottoExceptionMessage.LOTTO_DUPLICATE_WITH_BONUS_NUMBER_ERROR_MESSAGE;
import static lotto.Util.Util.ConvertStringToInteger;

import java.util.LinkedList;
import java.util.List;
import lotto.Domain.Lotto;
import lotto.Exception.LottoException;

public class WinningLotto {
    private static final String DELIMITER = ",";

    Lotto lotto;
    BonusNumber bonusNumber;

    public WinningLotto(String inputWinningNumbers, String inputBonusNumber) {
        List<String> dividedByDelimiter = divideByDelimiter(inputWinningNumbers);
        List<Integer> winningNumbers = generateWinningNumbers(dividedByDelimiter);
        BonusNumber number = BonusNumber.of(inputBonusNumber);
        isBonusNumberInWinningNumbers(winningNumbers, number);

        this.lotto = Lotto.from(winningNumbers);
        this.bonusNumber = number;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }

    private List<String> divideByDelimiter(String inputWinningNumbers) {
        return List.of(inputWinningNumbers.split(DELIMITER));
    }

    private List<Integer> generateWinningNumbers(List<String> dividedByDelimiter) {
        List <Integer> winningNumbers = new LinkedList<>();

        for (String string : dividedByDelimiter) {
            hasBlank(string);
            isInteger(string);
            Integer integer = ConvertStringToInteger(string);
            isValueBetween1And45(integer);
            winningNumbers.add(integer);
        }

        return winningNumbers;
    }

    private void isBonusNumberInWinningNumbers(List<Integer> winningNumbers, BonusNumber bonusNumber) {
        if (winningNumbers.contains(bonusNumber.getNumber()))
            throw new LottoException(LOTTO_DUPLICATE_WITH_BONUS_NUMBER_ERROR_MESSAGE.getMessage());
    }
}
package lotto.Domain.WinningLotto;

import static lotto.CommonValidation.CommonValidation.hasBlank;
import static lotto.CommonValidation.CommonValidation.isInteger;
import static lotto.CommonValidation.CommonValidation.isValidLottoNumber;
import static lotto.Message.ExceptionMessage.LottoExceptionMessage.LOTTO_DUPLICATE_WITH_BONUS_NUMBER_ERROR_MESSAGE;
import static lotto.Util.Util.convertStringToInteger;

import java.util.LinkedList;
import java.util.List;
import lotto.DiContainer.DiContainer;
import lotto.Domain.Lotto;
import lotto.Exception.LottoException;

public class WinningLotto {
    private static final String DELIMITER = ",";

    private Lotto lotto;
    private BonusNumber bonusNumber;

    private WinningLotto() {
    }

    public static WinningLotto of(){
        return new WinningLotto();
    }

    public Lotto getLotto() {
        return lotto;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }

    public void setLotto(String inputWinningNumbers) {
        List<String> dividedByDelimiter = divideByDelimiter(inputWinningNumbers);
        List<Integer> winningNumbers = generateWinningNumbers(dividedByDelimiter);

        this.lotto = Lotto.from(winningNumbers);
    }

    public void setBonusNumber(String inputBonusNumber) {
        BonusNumber number = BonusNumber.from(inputBonusNumber);
        isBonusNumberInWinningNumbers(lotto.getNumbers(), number);

        this.bonusNumber = number;
    }

    private List<String> divideByDelimiter(String inputWinningNumbers) {
        return List.of(inputWinningNumbers.split(DELIMITER));
    }

    private List<Integer> generateWinningNumbers(List<String> dividedByDelimiter) {
        List <Integer> winningNumbers = new LinkedList<>();
        validate(dividedByDelimiter);
        for (String string : dividedByDelimiter) {
            winningNumbers.add(convertStringToInteger(string));
        }
        return winningNumbers;
    }

    private void validate(List<String> dividedByDelimiter) {
        for (String string : dividedByDelimiter) {
            hasBlank(string);
            isInteger(string);
            Integer integer = convertStringToInteger(string);
            isValidLottoNumber(integer);
        }
    }

    private void isBonusNumberInWinningNumbers(List<Integer> winningNumbers, BonusNumber bonusNumber) {
        if (winningNumbers.contains(bonusNumber.getNumber()))
            throw new LottoException(LOTTO_DUPLICATE_WITH_BONUS_NUMBER_ERROR_MESSAGE.getMessage());
    }
}
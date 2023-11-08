package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

import lotto.common.LottoCommonString;
import lotto.common.LottoCount;
import lotto.common.LottoWinnerTable;
import lotto.validator.ValidatorLottoNumber;
import lotto.validator.ValidatorLottoNumbers;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        numbers.stream().forEach(ValidatorLottoNumber::validate);
        ValidatorLottoNumbers.validateNumberList(numbers);
    }

    public static Lotto fromString(String lottoNumbers) {
        List<String> lottoNumbersStringList = getStringListLottoNumber(lottoNumbers);
        ValidatorLottoNumbers.validateStringNumberList(lottoNumbersStringList);
        return new Lotto(lottoNumbersStringList
                .stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
    }

    public LottoWinnerTable compareWinningNumber(Lotto comparedLotto, BonusNumber bonusNumber) {
        int winningCount = (int) this.numbers.stream().filter(comparedLotto::isWiningNumber).count();
        boolean isBonusRequired = this.isWiningNumber(bonusNumber.getBonusNumber());
        if (isBonusRequired) {
            winningCount++;
        }
        if (winningCount < LottoCount.LOTTO_COUNT_NUMBER) {
            isBonusRequired = false;
        }
        return LottoWinnerTable.findByGrade(winningCount, isBonusRequired);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private boolean isWiningNumber(Integer number) {
        return numbers.contains(number);
    }

    private static List<String> getStringListLottoNumber(String lottoWinningNumber) {
        return List.of(lottoWinningNumber.split(LottoCommonString.LOTTO_INPUT_DELIMITER.getMessage()))
                .stream()
                .map(String::strip) // remove white spaces
                .collect(Collectors.toList());
    }
}

package lotto.domain.dto.input;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.validator.LottoValidator;

import java.util.List;

public class WinningLottoNumbersDtoBuilder {

    private Lotto winningNumbers;
    private LottoNumber bonusNumber;

    private WinningLottoNumbersDtoBuilder() {
    }

    public static WinningLottoNumbersDtoBuilder create() {
        return new WinningLottoNumbersDtoBuilder();
    }

    public WinningLottoNumbersDtoBuilder winningNumbers(List<Integer> numbers) {
        this.winningNumbers = new Lotto(numbers);
        return this;
    }

    public WinningLottoNumbersDtoBuilder bonusNumber(int number) {
        this.bonusNumber = new LottoNumber(number);
        LottoValidator.validateDuplicatedBonusNumber(winningNumbers, bonusNumber);
        return this;
    }

    public WinningLottoNumbersDto build() {
        return new WinningLottoNumbersDto(winningNumbers, bonusNumber);
    }
}

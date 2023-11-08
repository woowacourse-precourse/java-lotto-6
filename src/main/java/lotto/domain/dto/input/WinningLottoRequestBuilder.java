package lotto.domain.dto.input;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.validator.LottoValidator;

import java.util.List;

public class WinningLottoRequestBuilder {

    private Lotto winningNumbers;
    private LottoNumber bonusNumber;

    private WinningLottoRequestBuilder() {
    }

    public static WinningLottoRequestBuilder create() {
        return new WinningLottoRequestBuilder();
    }

    public WinningLottoRequestBuilder winningNumbers(List<Integer> numbers) {
        this.winningNumbers = new Lotto(numbers);
        return this;
    }

    public WinningLottoRequestBuilder bonusNumber(int number) {
        this.bonusNumber = new LottoNumber(number);
        LottoValidator.validateDuplicatedBonusNumber(winningNumbers, bonusNumber);
        return this;
    }

    public WinningLottoRequest build() {
        return new WinningLottoRequest(winningNumbers, bonusNumber);
    }
}

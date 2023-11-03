package lotto.domain;

import static lotto.exception.ExceptionMessage.BONUS_NUMBER_ALREADY_CONTAINS_IN_WINNING_NUMBERS;

import java.util.List;
import lotto.exception.LottoGameException;

public class LottoGame {
    private final LottoGenerator lottoGenerator;
    private Lottos customerLottos;
    private Lotto winningLotto;
    private LottoNumber bonusNumber;

    public LottoGame(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public void purchaseUserLottos(int availableCounts) {
        this.customerLottos = lottoGenerator.generate(availableCounts);
    }

    public void determineWinningLotto(List<Integer> inputLottoNumbers) {
        this.winningLotto = new Lotto(inputLottoNumbers);
    }

    public void determineBonusNumber(int inputBonusNumber) {
        LottoNumber bonusNumber = new LottoNumber(inputBonusNumber);
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(LottoNumber bonusNumber) {
        List<LottoNumber> numbers = winningLotto.getNumbers();
        if (numbers.contains(bonusNumber)) {
            throw new LottoGameException(
                    String.format(BONUS_NUMBER_ALREADY_CONTAINS_IN_WINNING_NUMBERS.getMessage(), numbers));
        }
    }
}

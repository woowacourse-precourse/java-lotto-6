package lotto.domain;

import static lotto.exception.ExceptionMessage.DUPLICATED_BONUS_NUMBER;

import java.util.List;
import lotto.util.Parser;
import lotto.util.LottoValidator;
import lotto.exception.LottoException;

public class WinningNumber {
    private final Lotto winningNumber;
    private int bonusNumber;

    private WinningNumber(Lotto winningNumber) {
        this.winningNumber = winningNumber;
    };

    public static WinningNumber create(String inputWinningNumber) {
        LottoValidator.validateNotNull(inputWinningNumber);
        List<Integer> numbers = Parser.parseWinningNumber(inputWinningNumber);
        return new WinningNumber(new Lotto(numbers));
    }

    public void createBonusNumber(String input) {
        LottoValidator.validateNotNull(input);
        bonusNumber = Parser.parseBonusNumber(input);
        validateBonusNumber();
    }

    public LottoResults compareWithLottos(LottoTickets lottoTickets) {
        return lottoTickets.getLottoResults(winningNumber, bonusNumber);
    }

    private void validateBonusNumber() {
        LottoValidator.validateInRange(bonusNumber);
        if (winningNumber.hasSameNumber(bonusNumber)) {
            throw new LottoException(DUPLICATED_BONUS_NUMBER);
        }
    }
}

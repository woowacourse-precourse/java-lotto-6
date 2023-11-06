package lotto.util.validation;

import static lotto.exception.ExceptionMessage.DUPLICATE_BONUS_NUMBER;

import lotto.model.Lotto;

public class WinningLottoValidator extends AbstractValidator<Lotto> {
    private final int bonusNumber;

    public WinningLottoValidator(final int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    @Override
    public void validate(final Lotto winningLottoTicket) {
        validateNotNull(winningLottoTicket);
        validateDuplicateLottoNumber(winningLottoTicket);
    }

    private void validateDuplicateLottoNumber(final Lotto winningLottoTicket) {
        if (winningLottoTicket.isDuplicateNumber(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER.format());
        }
    }
}

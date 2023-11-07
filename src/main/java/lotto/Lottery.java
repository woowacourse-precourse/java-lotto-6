package lotto;

import lotto.exception.LottoErrorCode;

public record Lottery(
        Lotto lotto,
        Integer bonusNumber
) {
    public Lottery {
        validateAllUnique(lotto, bonusNumber);
    }

    private void validateAllUnique(Lotto lotto, Integer bonusNumber) {
        if (lotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(LottoErrorCode.DUPLICATED_NUMBER.getMessage());
        }
    }

}

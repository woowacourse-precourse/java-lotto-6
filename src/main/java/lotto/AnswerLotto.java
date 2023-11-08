package lotto;

import constants.ErrorMessage;

public class AnswerLotto {
    private final Lotto answerLotto;
    private final LottoNumber bonusNumber;

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }

    public Lotto getAnswerLotto() {
        return answerLotto;
    }

    public AnswerLotto(Lotto answerLotto, LottoNumber bonusNumber) {
        validateBonusNumber(answerLotto, bonusNumber);
        this.answerLotto = answerLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(Lotto answerLotto, LottoNumber bonusNumber) {
        validateBonusNumberInAnswerLotto(answerLotto, bonusNumber);
    }

    private void validateBonusNumberInAnswerLotto(Lotto answerLotto, LottoNumber bonusNumber) {
        if (isAnswerLottoHasBonusNumber(answerLotto, bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_IN_ANSWER_LOTTO_ERROR.getMessage());
        }
    }

    public boolean isAnswerLottoHasBonusNumber(Lotto answerLotto, LottoNumber bonusNumber) {
        return answerLotto.hasNumber(bonusNumber.getNumber());
    }
}

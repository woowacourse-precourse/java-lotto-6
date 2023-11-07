package lotto;

import constants.ErrorMessage;
import constants.NumberType;
import java.util.List;

public class AnswerLotto {
    private final List<LottoNumber> answerLottoNumbers;

    private final LottoNumber bonusNumber;

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }

    public AnswerLotto(List<LottoNumber> answerLottoNumbers, LottoNumber bonusNumber) {
        validateAnswerLotto(answerLottoNumbers);
        validateBonusNumber(answerLottoNumbers, bonusNumber);
        this.answerLottoNumbers = answerLottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public int countMatchNumber(Lotto lotto) {
        return (int) answerLottoNumbers.stream()
                .map(LottoNumber::getNumber)
                .filter(lotto::hasNumber)
                .count();
    }

    private void validateAnswerLotto(List<LottoNumber> lottoNumbers) {
        validateLength(lottoNumbers);
        validateDuplicateMember(lottoNumbers);
    }

    private void validateLength(List<LottoNumber> lottoNumbers) {
        if (checkLength(lottoNumbers)) {
            throw new IllegalArgumentException(
                    String.format(ErrorMessage.LOTTO_LENGTH_ERROR.getMessage(),
                            NumberType.LOTTO_LENGTH.getValue()));
        }
    }

    private boolean checkLength(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.size() != NumberType.LOTTO_LENGTH.getValue();
    }

    private void validateDuplicateMember(List<LottoNumber> lottoNumbers) {
        if (checkHasDuplicateMember(lottoNumbers)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_HAS_DUPLICATE_NUMBER_ERROR.getMessage());
        }
    }

    private boolean checkHasDuplicateMember(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.stream()
                .distinct()
                .count() != lottoNumbers.size();
    }

    private void validateBonusNumber(List<LottoNumber> answerLottoNumbers,LottoNumber bonusNumber) {
        validateBonusNumberInAnswerLotto(answerLottoNumbers, bonusNumber);
    }

    private void validateBonusNumberInAnswerLotto(List<LottoNumber> answerLottoNumbers, LottoNumber bonusNumber) {
        if (isAnswerLottoHasBonusNumber(answerLottoNumbers, bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_IN_ANSWER_LOTTO_ERROR.getMessage());
        }
    }
    public boolean isAnswerLottoHasBonusNumber(List<LottoNumber> answerLottoNumbers, LottoNumber bonusNumber) {
        return answerLottoNumbers.contains(bonusNumber);
    }
}

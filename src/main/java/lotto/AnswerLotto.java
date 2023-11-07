package lotto;

import constants.ErrorMessage;
import constants.NumberType;
import java.util.List;

public class AnswerLotto {
    private final List<LottoNumber> lottoNumbers;

    public AnswerLotto(List<LottoNumber> lottoNumbers) {
        validateAnswerLotto(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }
    public int countMatchNumber(Lotto lotto) {
        return (int) lottoNumbers.stream()
                .map(LottoNumber::getNumber)
                .filter(lotto::hasNumber)
                .count();
    }

    public boolean hasNumber(int number) {
        return lottoNumbers.contains(LottoNumber.of(number));
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
}

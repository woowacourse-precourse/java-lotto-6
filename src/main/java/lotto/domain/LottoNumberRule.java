package lotto.domain;

import java.util.HashSet;
import java.util.List;

public enum LottoNumberRule {
    BASIC(1, 45, 6);

    private final int minLottoNumber;
    private final int maxLottoNumber;
    private final int lottoNumberSize;

    public final String ERROR_MESSAGE_EXCEED_SIZE;
    public final String ERROR_MESSAGE_OUT_OF_RANGE;
    public final String ERROR_MESSAGE_DUPLICATED;

    LottoNumberRule(int minLottoNumber, int maxLottoNumber, int lottoNumberSize) {
        this.minLottoNumber = minLottoNumber;
        this.maxLottoNumber = maxLottoNumber;
        this.lottoNumberSize = lottoNumberSize;

        this.ERROR_MESSAGE_EXCEED_SIZE = "로또 번호는 6자리입니다.";
        this.ERROR_MESSAGE_OUT_OF_RANGE = "로또 번호는 " + minLottoNumber + "부터 "
                + maxLottoNumber + " 사이의 숫자여야 합니다.";
        this.ERROR_MESSAGE_DUPLICATED = "로또 번호는 중복될 수 없습니다.";
    }

    public void validateLottoNumbers(final List<Integer> lottoNumbers) {
        validateNumberSize(lottoNumbers);
        validateNumbersInRange(lottoNumbers);
        validateDuplicated(lottoNumbers);
    }

    private void validateNumberSize(final List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != this.lottoNumberSize) {
            throw new IllegalArgumentException(ERROR_MESSAGE_EXCEED_SIZE);
        }
    }

    private void validateDuplicated(final List<Integer> lottoNumbers) {
        HashSet<Integer> duplicateDetector = new HashSet<>(lottoNumbers);
        if (duplicateDetector.size() != this.lottoNumberSize) {
            throw new IllegalArgumentException(ERROR_MESSAGE_DUPLICATED);
        }
    }

    private void validateNumbersInRange(final List<Integer> lottoNumbers) {
        for (int number : lottoNumbers) {
            if (number < minLottoNumber || number > maxLottoNumber) {
                throw new IllegalArgumentException(ERROR_MESSAGE_OUT_OF_RANGE);
            }
        }
    }
}

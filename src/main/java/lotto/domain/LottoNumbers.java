package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import lotto.utils.generator.LottoGenerator;

public class LottoNumbers {
    private static final int START_INCLUSIVE = LottoGenerator.START_INCLUSIVE;
    private static final int END_INCLUSIVE = LottoGenerator.END_INCLUSIVE;
    private static final int LOTTO_COUNT = LottoGenerator.LOTTO_COUNT;
    public static final String INVALID_NUMBER_RANGE_MESSAGE = "숫자의 범위는 " + START_INCLUSIVE + " ~ " + END_INCLUSIVE + "이어야 합니다.";
    public static final String INVALID_NUMBER_LENGTH_MESSAGE = "번호의 갯수는 " + LOTTO_COUNT + "개 입력해야 합니다.";
    private static final String NUMBER_DELIMITER = ",";
    private static final String INVALID_NUMBER_FORMAT_MESSAGE = "숫자 형식이 아닙니다.";
    public static final String INVALID_NUMBERS_DUPLICATE_MESSAGE = "로또 번호는 중복될 수 없습니다.";

    private final List<Integer> LottoNumbers;

    public LottoNumbers(String lottoNumbersText) {
        validate(lottoNumbersText);
        LottoNumbers = Arrays.stream(lottoNumbersText.split(","))
                .map(Integer::parseInt)
                .toList();
    }

    private void validate(String lottoNumbersText) {
        String[] splitNumberText = toSplit(lottoNumbersText);
        int[] splitNumber = toInt(splitNumberText);
        validateLength(splitNumber);
        validateRange(splitNumber);
        validateDuplicate(splitNumber);
    }

    private String[] toSplit(String lottoNumbersText) {
        return lottoNumbersText.split(NUMBER_DELIMITER);
    }

    private int[] toInt(String[] splitNumberText) {
        try {
            return Arrays.stream(splitNumberText)
                    .map(Integer::parseInt)
                    .mapToInt(Integer::intValue)
                    .toArray();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT_MESSAGE);
        }
    }

    private void validateLength(int[] splitNumber) {
        if (splitNumber.length != LOTTO_COUNT) {
            throw new IllegalArgumentException(INVALID_NUMBER_LENGTH_MESSAGE);
        }
    }

    private void validateRange(int[] splitNumber) {
        for (int number : splitNumber) {
            if (number < START_INCLUSIVE || number > END_INCLUSIVE) {
                throw new IllegalArgumentException(INVALID_NUMBER_RANGE_MESSAGE);
            }
        }
    }

    private void validateDuplicate(int[] splitNumber) {
        long count = Arrays.stream(splitNumber)
                .distinct()
                .count();
        if (count != LOTTO_COUNT) {
            throw new IllegalArgumentException(INVALID_NUMBERS_DUPLICATE_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(LottoNumbers, that.LottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(LottoNumbers);
    }
}

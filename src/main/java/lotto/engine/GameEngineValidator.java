package lotto.engine;

import java.util.Arrays;
import java.util.List;

public class GameEngineValidator {
    public static final String NOT_LOTTO_NUMBER_EXCEPTION_MESSAGE = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final int LOTTO_NUMBER_MIN_VALUE = 1;
    public static final int LOTTO_NUMBER_MAX_VALUE = 45;
    public static final String DUPLICATE_LOTTO_NUMBER_EXCEPTION_MESSAGE = "로또번호는 중복값을 가지고 있으면 안됩니다.";
    public static final String LOTTO_NUMBER_SIZE_EXCEPTION_MESSAGE = "로또 넘버개수는 %s가 아니라 %s 여야합니다.";
    public static final String NOT_NULL_LOTTO_NUMBERS_EXCEPTION_MESSAGE = "로또 넘버는 null이 될수 없습니다.";
    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final String NOT_NUMBER_EXCEPTION_MESSAGE = "%s는 숫자가 아닙니다.";
    private static final String NOT_POSITIVE_NUMBER_EXCEPTION_MESSAGE = "%s는 양수가 아닙니다.";
    private static final Long ZERO = 0L;
    private static final String NOT_THOUSAND_RATIO_NUMBER_EXCEPTION_MESSAGE = "%s는 천의 배수가 아닙니다.";
    private static final Long THOUSAND = 1_000L;

    void checkPrice(String price) {
        checkIsNumber(price);
        checkIsPositive(Long.parseLong(price));
        checkIsThousandRatio(Long.parseLong(price));
    }

    private void checkIsNumber(String price) {
        try {
            Long.parseLong(price);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format(NOT_NUMBER_EXCEPTION_MESSAGE, price));
        }
    }

    private void checkIsPositive(Long number) {
        if (number <= ZERO) {
            throw new IllegalArgumentException(String.format(NOT_POSITIVE_NUMBER_EXCEPTION_MESSAGE, number));
        }
    }

    private void checkIsThousandRatio(Long number) {
        if (number % THOUSAND != 0) {
            throw new IllegalArgumentException(String.format(NOT_THOUSAND_RATIO_NUMBER_EXCEPTION_MESSAGE, number));
        }
    }

    void checkReadLineLottoNumbers(String readLine) {
        checkIsNotNull(readLine);
        List<String> lottoNumbers = Arrays.stream(readLine.split(",")).toList();
        for (String lottoNumber : lottoNumbers) {
            checkIsNumber(lottoNumber);
        }
        checkLottoNumbers(lottoNumbers.stream().map(Long::parseLong).toList());
    }

    void checkLottoNumbers(List<? extends Number> lottoNumbers) {
        checkIsNotNull(lottoNumbers);
        checkLottoNumbersSize(lottoNumbers);
        checkLottoNumbersDuplicate(lottoNumbers);
        checkIsLottoNumberRange(lottoNumbers);
    }

    void checkBonusNumber(String readLine) {
        checkIsNotNull(readLine);
        checkIsNumber(readLine);
        checkIsLottoNumberRange(List.of(Long.parseLong(readLine)));
    }

    private void checkIsNotNull(Object lottoNumbers) {
        if (lottoNumbers == null) {
            throw new IllegalArgumentException(NOT_NULL_LOTTO_NUMBERS_EXCEPTION_MESSAGE);
        }
    }

    private void checkIsLottoNumberRange(List<? extends Number> lottoNumbers) {
        for (Number lottoNumber : lottoNumbers) {
            if (lottoNumber.longValue() < LOTTO_NUMBER_MIN_VALUE || lottoNumber.longValue() > LOTTO_NUMBER_MAX_VALUE) {
                throw new IllegalArgumentException(NOT_LOTTO_NUMBER_EXCEPTION_MESSAGE);
            }
        }
    }

    private <T> void checkLottoNumbersDuplicate(List<T> lottoNumbers) {
        int originalSize = lottoNumbers.size();
        int duplicateDeleteSize = lottoNumbers.stream()
                .distinct()
                .toList().size();
        if (originalSize != duplicateDeleteSize) {
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    private <T> void checkLottoNumbersSize(List<T> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(String.format(LOTTO_NUMBER_SIZE_EXCEPTION_MESSAGE, lottoNumbers.size(),
                    LOTTO_NUMBER_SIZE));
        }
    }
}

package lotto.validator;

import lotto.domain.Lotto;
import lotto.domain.dto.BonusNumberDto;
import lotto.domain.dto.WinningLottoDto;

public class BonusNumberValidator {
    public static final String INVALID_LOTTO_NUMBER_RANGE_MESSAGE =
            "보너스 번호를 " + Lotto.MIN_LOTTO_NUMBER + " ~ " + Lotto.MAX_LOTTO_NUMBER + " 사이의 숫자로 입력해주세요.";

    public static final String DUPLICATE_NUMBER_MESSAGE = "보너스 숫자로 당첨 숫자와 중복된 값이 입력됐습니다.";


    public static void inputValidate(final String input) {
        if (InputValidator.isEmpty(input)) {
            throw new IllegalArgumentException(InputValidator.ENTER_VALUE_MESSAGE);
        }

        if (!InputValidator.isMatchedNumberRegex(input)) {
            throw new IllegalArgumentException(InputValidator.INVALID_INPUT_CHARACTER);
        }
    }

    public static void validateBonusNumber(final int number) {
        validateNumbersInLottoRange(number);
    }

    private static void validateNumbersInLottoRange(final int number) {
        if (number < Lotto.MIN_LOTTO_NUMBER || number > Lotto.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE_MESSAGE);
        }
    }

    public static void validateBonusNumberDuplicate(final WinningLottoDto winningLottoDto,
                                                    final BonusNumberDto bonusNumberDto) {
        boolean isDuplicate = winningLottoDto.numbers().contains(bonusNumberDto.number());

        if (isDuplicate) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_MESSAGE);
        }
    }
}

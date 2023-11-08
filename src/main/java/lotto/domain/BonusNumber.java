package lotto.domain;

public class BonusNumber {
    private static final int LOTTO_GAME_START_NUMBER = 1;
    private static final int LOTTO_GAME_END_NUMBER = 45;
    private static final String BONUS_OUT_OF_RANGE = "1 ~ 45 사이의 값을 입력해 주셔야 합니다.";
    private static final String BONUS_IS_SEPARATE_CHAR = "1 ~ 45 사이의 값을 하나만 입력해 주셔야 합니다.";
    private static final String BONUS_DUPLICATE_VALUE = "당첨 번호에 없는 번호를 입력해 주셔야 합니다.";
    private static final String COMMA = ",";
    private static final String SPACE = " ";
    private final int bonusNumber;

    public BonusNumber(String bonusNumber, Lotto lottoNumbers) {
        validate(bonusNumber, lottoNumbers);
        this.bonusNumber = convertStringToInt(bonusNumber);
    }

    private void validate(String bonusNumber, Lotto lottoNumbers) {
        validateSeperateChar(bonusNumber);
        validateLengthAndRange(bonusNumber);
        validateDuplicate(bonusNumber, lottoNumbers);
    }

    private void validateSeperateChar(String bonusNumber) {
        if (isSeparatorChar(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_IS_SEPARATE_CHAR);
        }
    }

    private void validateDuplicate(String bonusNumber, Lotto lottoNumbers) {
        if (isNumberInLotto(convertStringToInt(bonusNumber), lottoNumbers)) {
            throw new IllegalArgumentException(BONUS_DUPLICATE_VALUE);
        }
    }

    private void validateLengthAndRange(String bonusNumber) {
        if (isStringEmpty(bonusNumber) || !isDigit(bonusNumber) || !isBetweenLottoRange(convertStringToInt(bonusNumber))) {
            throw new IllegalArgumentException(BONUS_OUT_OF_RANGE);
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private boolean isStringEmpty(String number) {
        return number == null || number.isBlank();
    }

    private boolean isSeparatorChar(String number) {
        return number.contains(COMMA) || number.contains(SPACE);
    }

    private boolean isDigit(String number) {
        return number.chars().allMatch(Character::isDigit);
    }

    private boolean isBetweenLottoRange(int number) {
        return number >= LOTTO_GAME_START_NUMBER && number <= LOTTO_GAME_END_NUMBER;
    }

    private int convertStringToInt(String number) {
        return Integer.parseInt(number);
    }

    private boolean isNumberInLotto(int number, Lotto lottoNumbers) {
        return lottoNumbers.getLotto().contains(number);
    }

}

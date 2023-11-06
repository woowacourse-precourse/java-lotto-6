package lotto;

public class BonusNumber {
    private static final String BONUS_OUT_OF_RANGE = "[ERROR] 1~45 사이의 값을 입력해야 합니다.";
    private static final String BONUS_IS_SEPARATE_CHAR = "[ERROR] 1~45 사이의 값을 하나만 입력해야 합니다.";
    private static final String BONUS_DUPLICATE_VALUE = "[ERROR] 당첨번호와 번호가 중복됩니다. 당첨번호에 없는 번호를 입력하세요.";

    private static final int LOTTO_GAME_START_NUMBER = 1;
    private static final int LOTTO_GAME_END_NUMBER = 45;
    private static final String COMMA = ",";
    private static final String SPACE = " ";
    private final int bonusNumber;

    public BonusNumber(String bonusNumber, Lotto lottoNumbers) {
        validate(bonusNumber, lottoNumbers);
        this.bonusNumber = convertStringToInt(bonusNumber);
    }

    private void validate(String number, Lotto lottoNumbers){
        if (isStringEmpty(number)) {
            throw new IllegalArgumentException(BONUS_OUT_OF_RANGE);
        } else if (isSeparatorChar(number)) {
            throw new IllegalArgumentException(BONUS_IS_SEPARATE_CHAR);
        } else if (!isDigit(number) || !isBetweenLottoRange(convertStringToInt(number))) {
            throw new IllegalArgumentException(BONUS_OUT_OF_RANGE);
        } else if (isNumberInLotto(convertStringToInt(number), lottoNumbers)) {
            throw new IllegalArgumentException(BONUS_DUPLICATE_VALUE);
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
        return lottoNumbers.getNumbers().contains(number);
    }
}

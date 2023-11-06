package lotto.validate;

public class LottoNumberValidator {
    public static boolean validateWinningNumber(String winningNumber) {
        String[] splitLottoNumber = winningNumber.split(",");
        isValidLength(splitLottoNumber);
        isValidType(splitLottoNumber);
        return true;
    }

    private static void isValidType(String[] split) {
        try {
            for (String s : split) {
                Integer.valueOf(s);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 금액은 숫자만 입력 가능합니다2.");
        }
    }

    private static void isValidLength(String[] split) {
        if (split.length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첩 번호는 6개의 숫자로 입력되어야 합니다.");
        }
    }
}

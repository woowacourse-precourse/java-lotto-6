package lotto.valid;

public class BonusNumberValid {

    public static int validBonusNumber(String input) {
        int bonusNumber = validOnlyNumber(input);
        validNumValue(bonusNumber);
        return bonusNumber;
    }


    private static int validOnlyNumber(String input) {
        String reg = "^[0-9]*$";
        if (!input.matches(reg)) {
            throw new IllegalArgumentException("[ERROR] 보너스 숫자는 숫자만 입력 가능합니다.");
        }
        return Integer.parseInt(input);
    }

    private static void validNumValue(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1과 45 사이의 숫자여야 합니다.");
        }
    }
}

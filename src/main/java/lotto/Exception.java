package lotto;

public class Exception {
    public static void isValidNotThousandAndNegativeException(int count) {
        if (count % 1000 != 0 || count < 0) throw new IllegalArgumentException("[ERROR] 천원 단위로 입력해주세요.");
    }

    public static int isValidNumberFormat(String number) {
        int count;
        try {
            count = Integer.parseInt(number);
            return count;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자 형식으로 입력해주세요.");
        }
    }

    public static void isValidLottoNumberRange(int number){
        if (number < 0 || number > 46) throw new IllegalArgumentException("[ERROR] 로또 숫자 범위 이내로 입력해주세요.");
    }
}

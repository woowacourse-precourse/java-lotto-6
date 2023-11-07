package lotto.util;

public class LottoUtil {

    public static int parseInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자로 변환하는 도중 오류가 발생하였습니다.");
        }
    }

}

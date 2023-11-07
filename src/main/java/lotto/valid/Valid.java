package lotto.valid;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static lotto.LottoConst.*;

public class Valid {

    public static void validPrice(String text) {
        isEmptyOrNull(text);
        isNumber(text);

        int price = Integer.parseInt(text);
        if (price % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("입력 단위는 " + LOTTO_PRICE + "원 입니다.");
        }
    }

    public static void validWinNum(String text) {
        isEmptyOrNull(text);

        String[] split = text.split(",");
        if (split.length != LOTTO_COUNT) {
            throw new IllegalArgumentException(LOTTO_COUNT + "자리를 입력해주세요");
        }
        for (String numText : split) {
            int number = isNumber(numText);
            isLottoRange(number);
        }

        distinctCheck(split);
    }

    public static void validBonusNum(String text) {
        isEmptyOrNull(text);
        int number = isNumber(text);
        isLottoRange(number);
    }

    public static void distinctCheck(List<Integer> winNum, String bonusNum) {
        if (winNum == null) return;
        int num = Integer.parseInt(bonusNum);
        if (winNum.contains(num)) {
            throw new IllegalArgumentException("보너스 번호가 중복되었습니다");
        }
    }

    private static void isEmptyOrNull(String text) {
        if (text == null || text.equals("") || text.isEmpty() || text.isBlank()){
            throw new IllegalArgumentException("빈 칸은 입력할 수 없습니다.");
        }
    }

    private static int isNumber(String text) {
        Pattern p = Pattern.compile("[^0-9]");
        Matcher m = p.matcher(text);
        if (m.find()) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
        int number = Integer.parseInt(text.trim());
        if (number <= 0) {
            throw new IllegalArgumentException("값이 올바르지 않습니다");
        }
        return number;
    }

    private static void isLottoRange(int number) {
        if (number < MIN_LOTTO_NUM || number > MAX_LOTTO_NUM) {
            throw new IllegalArgumentException(MIN_LOTTO_NUM + " ~" + MAX_LOTTO_NUM + " 범위에서 입력해주세요");
        }
    }

    private static void distinctCheck(String[] split) {
        Set<String> set = new HashSet<>();
        for (String num : split) {
            if (!set.add(num)) {
                throw new IllegalArgumentException("당첨번호가 중복되었습니다.");
            }
        }
    }
}

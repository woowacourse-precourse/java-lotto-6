package lotto.input;
import camp.nextstep.edu.missionutils.Console;

public class Price {
    private final String ENTER_PRICE = "구입금액을 입력해 주세요.";
    private final String ENTER_LOTTO = "당첨 번호를 입력해 주세요.";
    private final String ENTER_BONUS = "보너스 번호를 입력해 주세요.";
    private final String PRINT_CNT = "개를 구매했습니다.";
    private static final String IS_ONLY_NUMBER = "[0-9]+"; // 숫자로만 되어있으면 true 반환
    private static final String ERROR_MESSAGE = "[ERROR]";

    public int purchase() {
        int cnt = 0;
        String price = enter(ENTER_PRICE);
        try {
            cnt = isPriceValid(price);
        } catch (Exception e) {
            System.out.println(ERROR_MESSAGE); // 금액을 다시 입력하라고
            purchase();
        }
        System.out.println(cnt+PRINT_CNT);
        return cnt;
    }
    private String enter(String announcement) {
        System.out.println(announcement);
        return Console.readLine();
    }
    private int isPriceValid(String price) {
        if (isInteger(price) && isKUnit(price))
            return Integer.parseInt(price) / 1000;
        throw new IllegalStateException();
    }
    private boolean isInteger(String price) {
        return price.matches(IS_ONLY_NUMBER);
    }
    private boolean isKUnit(String price) {
        if (Integer.parseInt(price) % 1000 == 0)
            return true;
        return false;
    }
}

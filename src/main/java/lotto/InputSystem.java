package lotto;
import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.List;

public class InputSystem {
    private final String ENTER_PRICE = "구입금액을 입력해 주세요.";
    private final String ENTER_LOTTO = "당첨 번호를 입력해 주세요.";
    private final String ENTER_BONUS = "보너스 번호를 입력해 주세요.";
    private static final String IS_ONLY_NUMBER = "[0-9]+"; // 숫자로만 되어있으면 true 반환
    private static final String ERROR_MESSAGE = "[ERROR]";


    public int purchase() {
        return isPriceValid(enter(ENTER_PRICE));
    }
    private String enter(String announcement) {
        System.out.println(announcement);
        return Console.readLine();
    }
    private int isPriceValid(String price) {
        if (isInteger(price) && isKUnit(price))
            return Integer.parseInt(price) / 1000;
        throw new IllegalArgumentException();
    }
    private boolean isKUnit(String price) {
        if (Integer.parseInt(price) % 1000 == 0)
            return true;
        return false;
    }
    public List<Integer> getNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (String a : enter(ENTER_LOTTO).split(",")) {
            numbers.add(isNumberValid(a));
        }
        Lotto l = new Lotto(numbers);
        return l.getLotto();
    }
    public int getBonus(List<Integer> lotto) {
        return isDuplicate(lotto, isNumberValid(enter(ENTER_BONUS)));
    }
    public int isDuplicate(List<Integer> lotto, int bonus) {
        if (lotto.contains(bonus))
            throw new IllegalArgumentException();
        return bonus;
    }
    public int isNumberValid(String number) {
        if (isInteger(number) && isRangeValid(number))
            return Integer.parseInt(number);
        throw new IllegalArgumentException();
    }
    public boolean isInteger(String number) {
        return number.matches(IS_ONLY_NUMBER);
    }
    public boolean isRangeValid(String number) {
        int parsed = Integer.parseInt(number);
        if (!(1 <= parsed && parsed < 46)) {
            throw new IllegalArgumentException("1 ~ 45 여야돼");
        }
        return true;
    }
}

package lotto;
import camp.nextstep.edu.missionutils.Console;
import lotto.model.Errors;
import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.List;

public class InputSystem {
    private final String ENTER_PRICE = "구입금액을 입력해 주세요.";
    private final String ENTER_LOTTO = "당첨 번호를 입력해 주세요.";
    private final String ENTER_BONUS = "보너스 번호를 입력해 주세요.";
    private final String TICKET_CNT = "개를 구매했습니다.";

    Validation valid = new Validation();
    private String enter(String announcement) {
        System.out.println(announcement);
        return Console.readLine();
    }
    public int purchase() {
        return isPriceValid(enter(ENTER_PRICE));
    }
    private int isPriceValid(String price) {
        try {
            if (valid.isInteger(price) && isKUnit(price)) {
                return howmany(Integer.parseInt(price) / 1000);
            }
        }
        catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
        return 0;
    }
    public int howmany(int cnt) {
        System.out.println(cnt+TICKET_CNT);
        return cnt;
    }
    private boolean isKUnit(String price) {
        if (Integer.parseInt(price) % 1000 == 0)
            return true;
        throw new IllegalArgumentException(Errors.INPUT_K.getMessage());
    }
    public List<Integer> getNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (String a : enter(ENTER_LOTTO).split(",")) {
            numbers.add(valid.isNumberValid(a));
        }
        return new Lotto(numbers).getLotto();
    }
    public int getBonus(List<Integer> lotto) {
        return valid.isDuplicate(lotto, valid.isNumberValid(enter(ENTER_BONUS)));
    }
}

package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.DivideThousand;
import lotto.exception.ZeroException;

import java.util.regex.Pattern;

public class InputBuyLotto {
    private static final String BUY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final int ZERO = 0;
    private static final int THOUSAND = 1000;

    public int getMoney() {
        System.out.println(BUY_MESSAGE);
        String money = Console.readLine();
        System.out.println();
        validate(money);
        return Integer.parseInt(money);
    }

    private void validate(String money) {

        if (!Pattern.compile("\\d+").matcher(money).matches()) {
            throw new IllegalArgumentException();
        }
    }

    private int getTicket(int money) {
        validateZero(money);
        validateDivideThousand(money);

        return money / THOUSAND;
    }

    private void validateZero(int money) {
        if (money == ZERO) {
            throw new ZeroException();
        }
    }

    private void validateDivideThousand(int money) {
        if (money % THOUSAND != 0) {
            throw new DivideThousand();
        }
    }

}

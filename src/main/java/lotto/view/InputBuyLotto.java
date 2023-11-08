package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.DivideThousandException;
import lotto.exception.NumberException;
import lotto.exception.ZeroException;

import java.util.regex.Pattern;

public class InputBuyLotto {
    private static final String BUY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final int ZERO = 0;
    private static final int THOUSAND = 1000;

    public int getMoney() {
        int money = 0;
        boolean validInput = false;
        money = validMoneyContinue(money, validInput);
        return money;
    }

    private int validMoneyContinue(int money, boolean validInput) {
        do {
            System.out.println(BUY_MESSAGE);
            String moneyStr = Console.readLine();
            try {
                validate(moneyStr);
                money = Integer.parseInt(moneyStr);
                validInput = true;
            } catch (NumberException e) {
                System.out.println(e.getMessage());
            }
        } while (!validInput);
        return money;
    }

    private void validate(String money) {

        if (!Pattern.compile("\\d+").matcher(money).matches()) {
            throw new NumberException();
        }
    }

    public int getTicket(int money) {
        boolean validNotZero = false;
        boolean validDivideThousand=false;

        validZeroContinue(money, validNotZero);
        validDivisionCountiunue(money, validDivideThousand);

        return money / THOUSAND;
    }

    private void validDivisionCountiunue(int money, boolean validDivideThousand) {
        do {
            try {
                validateDivideThousand(money);
                validDivideThousand = true;
            } catch (DivideThousandException e) {
                System.out.println(e.getMessage());
            }
        } while (!validDivideThousand);
    }

    private void validZeroContinue(int money, boolean validNotZero) {
        do {
            try {
                validateZero(money);
                validNotZero = true;
            } catch (ZeroException e) {
                System.out.println(e.getMessage());
            }
        } while (!validNotZero);
    }

    private void validateZero(int money) {
        if (money == ZERO) {
            throw new ZeroException();
        }
    }

    private void validateDivideThousand(int money) {
        if (money % THOUSAND != 0) {
            throw new DivideThousandException();
        }
    }
}

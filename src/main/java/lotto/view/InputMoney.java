package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Money;

public class InputMoney {
    private Money money;
    private final static String INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private final static String DIVIDE_ERROR = "[ERROR] 구입 금액을 1,000원 단위로 입력해주세요.";
    private final static String NOT_NUMBER = "[ERROR] 숫자를 입력해주세요.";
    private final static String NUMBER = "개를 구매했습니다.";

    public Money enterAmountOfMoney() {
        System.out.println(INPUT_MESSAGE);
        while(true) {
            try {
                money = new Money(Integer.parseInt(Console.readLine()));
                break;
            } catch (NumberFormatException e){
                System.out.println(NOT_NUMBER);
            } catch (IllegalArgumentException e) {
                System.out.println(DIVIDE_ERROR);
            }
        }
        decideNumberOfLotto(money.getTicketQuantity());
        return money;
    }

    private void decideNumberOfLotto(int numberOfLotto) {
        System.out.println();
        System.out.println(numberOfLotto + NUMBER);
    }
}

package lotto;

import camp.nextstep.edu.missionutils.Console;

public class User {
    private int numberOfLotto;
    private int money;
    private Lotto winningNumber;
    private int bonusNumber;

    private final static String START = "구입금액을 입력해 주세요.";
    private final static String NUMBER = "개를 구입했습니다.";
    private final static String WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private final static String BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private final static String DIVIDE_ERROR = "[ERROR] 구입 금액을 1,000원 단위로 입력해주세요.";
    private final static String NOT_NUMBER = "[ERROR] 숫자를 입력해주세요.";

    public void enterAmount() {
        System.out.println(START);
        while(true) {
            try {
                money = Integer.parseInt(Console.readLine());
                validateNumber();
                break;
            } catch (NumberFormatException e){
                System.out.println(NOT_NUMBER);
            } catch (IllegalArgumentException e) {
                System.out.println(DIVIDE_ERROR);
            }
        }
    }

    public void enterWinningNumber() {

    }

    public void enterBonusNumber() {

    }

    private void validateNumber() {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    private void validateLotto() {

    }

    private void decideNumberOfLotto() {
        numberOfLotto = money / 1000;
        System.out.println(numberOfLotto + NUMBER);
    }
}

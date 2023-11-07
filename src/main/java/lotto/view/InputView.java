package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static final String USER_INPUT_BILL = "구입금액을 입력해 주세요.";
    public static final String INPUT_JACKPOT_NUMBER = "\n당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요.";
    public static final String BILL_MUST_INTEGER = "[ERROR] 구입금액은 숫자여야합니다.";
    public static final String BONUS_MUST_INTEGER = "[ERROR] 구입금액은 숫자여야합니다.";

    public static int requestAmount() {
        try {
            System.out.println(USER_INPUT_BILL);
            int Bill = Integer.parseInt(Console.readLine());
            return Bill;
        } catch (NumberFormatException e){
            System.out.println(BILL_MUST_INTEGER);
            return requestAmount();
        }
    }
    public static String requestJackpotNumber() {
        System.out.println(INPUT_JACKPOT_NUMBER);
        String jackpot = Console.readLine();
        return jackpot;
    }
    public static String requestBonusNumber() {
        try {
            System.out.println(INPUT_BONUS_NUMBER);
            String bonus = Console.readLine();
            return bonus;
        } catch (NumberFormatException e) {
            System.out.println(BONUS_MUST_INTEGER);
            return requestBonusNumber();
        }
    }



}

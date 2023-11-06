package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import lotto.domain.Lotto;
public class InputView {
    public static final String USER_INPUT_BILL = "구입금액을 입력해 주세요.";
    public static final String INPUT_JACKPOT_NUMBER = "당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static int requestAmount() {
        System.out.println(USER_INPUT_BILL);
        int Bill = Integer.parseInt(Console.readLine());
        return Bill;
    }
    public static String requestJackpotNumber() {
        System.out.println(INPUT_JACKPOT_NUMBER);
        String jackpot = Console.readLine();
        return jackpot;


    }
    public static String requestBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        String bonus = Console.readLine();
        return bonus;

    }



}

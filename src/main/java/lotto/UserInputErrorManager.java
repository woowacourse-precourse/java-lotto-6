package lotto;

import java.util.List;

public class UserInputErrorManager {
    public static LottoTicket getuntilNotInvalidAmount() {
        System.out.println("구입금액을 입력해 주세요.");

        int number;
        LottoTicket lottoTicket;
        while (true) {
            try {
                number = InputHandler.getUserInputAmount();
                lottoTicket = new LottoTicket(number);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
        return lottoTicket;
    }

    public static Lotto getuntilNotInvalidLotto() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요");

        Lotto lotto;
        while (true) {
            try {
                List<Integer> inputList = InputHandler.getUserInputlotto();
                lotto = new Lotto(inputList);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
        return lotto;
    }

    public static Bonus getuntilNotInvalidBonus(Lotto lotto) {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요");

        int number;
        Bonus bonus;
        while (true) {
            try {
                number = InputHandler.getUserInputBonus();
                bonus = new Bonus(number, lotto);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
        return bonus;
    }
}

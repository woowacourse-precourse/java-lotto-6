package lotto.View;

import java.util.List;

public class OutputLottoUI {

    public static void inputMoneyView() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void answerLottoView() {
        System.out.println(("\n당첨 번호를 입력해 주세요."));
    }

    public static void answerBonusNumberView() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }


    public static void rankViewStart(){ System.out.println("\n당첨 통계\n---"); }

    public static void answerViewReInput(){ System.out.println("[ERROR] 당첨 숫자 6개를 입력해주세요."); }
    public static void moneyViewReInput(){ System.out.println("[ERROR] 돈을 다시 입력해주세요."); }

    public static void bonusViewReInput(){ System.out.println("[ERROR] 보너스 번호를 다시 입력해주세요."); }

}

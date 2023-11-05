package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.utils.Validator;

public class UserView {

    public static String startMessage() {
        System.out.println("구입금액을 입력해 주세요.");
        String money = Console.readLine();
        Validator.validateMoney(money);
        return money;
    }

    public static List<Integer> printLotto(List<Integer> lotto) {
        System.out.println("8개를 구매했습니다.");
        return lotto;
    }

    public static String winNumberMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public static String bonusNumberMessage() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();
        Validator.validateBonusNumber(bonusNumber);
        return bonusNumber;
    }

    public static void winStatisticsMessage(int count) {
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + count + "개");
        System.out.println("4개 일치 (5,0000원) - " + count + "개");
        System.out.println("5개 일치 (1,500,000원) - " + count + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + count + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + count + "개");
    }

    public static void totalYieldMessage(int yield) {
        System.out.println("총 수익률은 " + yield + "%입니다.");
    }
}

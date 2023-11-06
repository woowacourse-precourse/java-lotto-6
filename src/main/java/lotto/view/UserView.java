package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.enums.Rank;
import lotto.model.Lotto;
import lotto.utils.Validator;

public class UserView {

    public static String startMessage() {
        System.out.println("구입금액을 입력해 주세요.");
        String money = Console.readLine();
        Validator.validateMoney(money);
        System.out.println(money);
        return money;
    }

    public static void printLottoMessage(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void showLottoList(List<Lotto> lottoList){
        for (Lotto lotto : lottoList) {
            System.out.println(lotto);
        }
    }

    public static String winNumberMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public static void showWinNumber(List<Integer> winNumber) {
        List<String> winList = new ArrayList<>();
        for (Integer win : winNumber) {
            winList.add(Integer.toString(win));
        }
        String joinedNumber = String.join(",", winList);
        System.out.println(joinedNumber);
    }

    public static String bonusNumberMessage() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();
        Validator.validateBonusNumber(bonusNumber);
        return bonusNumber;
    }

    public static void showBonusNumber(int bonusNumber) {
        System.out.println(bonusNumber);
    }

    public static void winStatisticsMessage(List<Rank> rankList) {
        System.out.println("당첨 통계");
        System.out.println("---");

        for (Rank rank : Rank.values()) {
            long count = rankList.stream()
                    .filter(r -> r == rank)
                    .count();
            System.out.println(rank.getCountMatch() + "개 일치 (" + rank.getPrize() + "원) - " + count + "개");
        }
    }

    public static void totalYieldMessage(int yield) {
        System.out.println("총 수익률은 " + yield + "%입니다.");
    }
}

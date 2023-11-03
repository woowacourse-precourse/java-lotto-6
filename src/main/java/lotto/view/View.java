package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.Lotto;

public class View {

    public static void printStartMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static String input() {
        String input =  Console.readLine();
        System.out.println();
        return input;
    }

    public static void printPurchaseMessage(int quantity) {
        System.out.println(quantity + "개를 구매했습니다.");
    }

    public static void printPurchasedLotto(List<Lotto> purchasedLotto) {
        for (Lotto lotto : purchasedLotto) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    public static String printInputNumberMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return input();
    }

    public static String printInputBonusNumberMessage() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return input();
    }

}

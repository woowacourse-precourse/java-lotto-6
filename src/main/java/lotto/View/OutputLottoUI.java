package lotto.View;

import java.util.List;

public class OutputLottoUI {

    public static void inputMoneyView() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void lottoCountView(int lottoCount) {
        System.out.println("\n" +lottoCount + "개를 구매했습니다.");
    }

    public static void lottoNumbersView(List<Integer> lotto) {
        for (int number : lotto) {
            System.out.print(number + " ");
        }
    }

    public static void answerLottoView() {
        System.out.println(("당첨 번호를 입력해 주세요."));
    }

    public static void answerBonusNumberView() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void lottoSalse(List<List<Integer>> lottos) {
        for(List<Integer> lotto : lottos) {
            System.out.println(lotto);
        }
    }

}

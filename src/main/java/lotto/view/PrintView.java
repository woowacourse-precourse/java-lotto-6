package lotto.view;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.User;

public class PrintView {

    public static void inputMoneyView() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void inputWinningNumbersView() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void inputBonusNumberView() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }

    public static void printLottos(User user) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append(user.getCount()).append("개를 구매했습니다.\n");

        for (Lotto lotto : user.getLottos()) {
            List<Integer> numbers = lotto.getNumbers();
            sb.append("[");

            for (int i = 0; i < numbers.size(); i++) {
                sb.append(numbers.get(i));

                if (i < numbers.size() - 1) {
                    sb.append(", ");
                }
            }

            sb.append("]\n");
        }

        System.out.println(sb.toString());
    }


}

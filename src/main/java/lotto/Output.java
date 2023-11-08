package lotto;

import lotto.Domain.Lotto;
import lotto.Domain.Result;
import lotto.Domain.User;

import java.util.List;
import java.util.Map;

public class Output {
    final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    final String INPUT_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요.";

    private final Map<Integer, String> gradeSet = Map.of(
            3, "5,000", 4, "50,000", 5, "1,500,000",
            6, "2,000,000,000", 7, "30,000,000"
    );

    public void printInputMoney() {
        System.out.println(INPUT_MONEY);
    }

    public void printInputWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER);
    }

    public void printInputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
    }

    public void printBuyLotto(User user) {
        List<Lotto> lottos = user.getLottos();
        int lottoCount = lottos.size();
        System.out.println("\n" + lottoCount + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
        System.out.println();
    }

    public void printResult(Result result, int inputMoney) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        Map<Integer, Integer> resultMap = result.getResult();

        for(int i = 3; i <= 6; i++) {
            System.out.println(i + "개 일치 (" + gradeSet.get(i) + "원) - " + resultMap.getOrDefault(i, 0) + "개");
            if (i == 5) {
                System.out.println(i + "개 일치, 보너스 볼 일치 (" + gradeSet.get(7) + "원) - " + resultMap.getOrDefault(7, 0) + "개");
            }
        }
        double resultValue = (double)result.getReward() / (double)inputMoney * 100;

        System.out.printf("총 수익률은 %.1f%%입니다.\n", resultValue);
    }

}

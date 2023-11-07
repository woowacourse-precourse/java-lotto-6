package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import java.text.DecimalFormat;
import java.util.Map;

public class GameView {
    private DecimalFormat lottoReturnsFormat = new DecimalFormat("###,###,###.0");

    public void inputLottoPurchaseAmount(Player player) {
        while (true) {
            System.out.println("구매금액을 입력해 주세요.");
            String input = Console.readLine();

            try {
                player.setPurchaseAmount(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 로또 구매 금액은 1,000 단위의 숫자여야 합니다.");
            }
        }
    }

    public void printLottos(Map<Lotto, Double> lottos) {
        System.out.println("\n" + lottos.size() + "개를 구매했습니다.");

        for (Lotto lotto : lottos.keySet()) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void inputLottoWinningNumbers(Player player) {
        System.out.println();
        while (true) {
            System.out.println("당첨 번호를 입력해 주세요.");
            String input = Console.readLine();

            try {
                player.setWinningNumbers(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 로또 당첨 번호는 1부터 45 사이의 숫자 6개여야 합니다.");
            }
        }
    }

    public void inputLottoBonusNumber(Player player) {
        System.out.println();
        while (true) {
            System.out.println("보너스 번호를 입력해 주세요.");
            String input = Console.readLine();

            try {
                player.setBonusNumber(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 로또 보너스 번호는 1부터 45 사이의 숫자이며, 당첨 번호에 포함되지 않아야 합니다.");
            }
        }
    }

    public void printLottoWinAndLottoReturns(double lottoReturns) {
        System.out.println("\n당첨 통계");
        System.out.println("---");

        for (LottoRanking lottoRanking : LottoRanking.values()) {
            System.out.println(lottoRanking.getResult());
        }

        System.out.println("총 수익률은 " + lottoReturnsFormat.format(lottoReturns) + "%입니다.");
    }
}

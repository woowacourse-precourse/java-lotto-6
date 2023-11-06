package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.domain.result.WinningRank;
import lotto.domain.result.WinningResult;
import lotto.io.Input;
import lotto.io.Output;

public class LottoView {

    private final Input input;
    private final Output output;

    public LottoView(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public int askPurchaseMoney() {
        output.println("구입금액을 입력해 주세요.");
        return input.getInteger();
    }

    public List<Integer> askLottoNumbers() {
        output.println("");
        output.println("당첨 번호를 입력해 주세요.");
        return input.getIntegers();
    }

    public int askBonusNumber() {
        output.println("");
        output.println("보너스 번호를 입력해 주세요.");
        return input.getInteger();
    }

    public void printLottos(Lottos lottos) {
        List<Lotto> findLottos = lottos.getLottos();
        System.out.printf("\n%d개를 구매했습니다.\n", findLottos.size());
        for (Lotto lotto : findLottos) {
            output.println(lotto.getNumbers().toString());
        }
    }

    public void printWinningResult(WinningResult winningResult) {
        System.out.println("\n당첨 통계 \n---");
        Map<WinningRank, Integer> winningResults = winningResult.getResult();
        for (WinningRank winningRank : winningResults.keySet()) {
            if (winningRank == WinningRank.EMPTY) {
                continue;
            }
            int matchCount = winningRank.getCount();
            int money = winningRank.getMoney();
            boolean hasBonusNumber = winningRank.isBonusNumber();
            if (hasBonusNumber) {
                System.out.printf("%d개 일치, 보너스 볼 일치 (%,d원) - %d개 \n", matchCount, money,
                        winningResults.get(winningRank));
                continue;
            }
            System.out.printf("%d개 일치 (%,d원) - %d개 \n", matchCount, money,
                    winningResults.get(winningRank));
        }
    }

    public void printWinningProfit(float rateOfReturn) {
        double result = Math.round(rateOfReturn * 100) / 100.0;
        output.printf("총 수익률은 %.1f%%입니다.", result);
    }
}

package lotto.view;

import lotto.domain.wrapper.Lotto;
import lotto.domain.wrapper.LottoResult;
import lotto.handler.LottoHandler;
import lotto.handler.OutputHandler;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

import static lotto.handler.ConstantsHandler.DEFAULT_VALUE;
import static lotto.handler.LottoHandler.OTHER;

public class ConsoleOutput implements OutputHandler {

    @Override
    public void printInputMoneyMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    @Override
    public void printBuyLottoList(List<Lotto> buyLottos) {
        System.out.println();
        System.out.println(buyLottos.size() + "개를 구매했습니다.");

        for (Lotto buyLotto : buyLottos) {
            System.out.println(buyLotto.sortLottoNumbers());
        }
    }

    @Override
    public void printInputWinningLottoMessage() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    @Override
    public void printInputBonusLottoMessage() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    @Override
    public void printLottoResult(LottoResult lottoResult) {
        DecimalFormat prizeFormat = new DecimalFormat("###,###");
        Map<LottoHandler, Integer> result = lottoResult.getLottoResult();

        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");

        for (LottoHandler lottoHandler : LottoHandler.values()) {
            if (lottoHandler == OTHER) {
                continue;
            }

            System.out.printf("%d개 일치%s (%s원) - %d개\n", lottoHandler.getCount(), lottoHandler.getMessage(), prizeFormat.format(lottoHandler.getPrize()), result.getOrDefault(lottoHandler, DEFAULT_VALUE));
        }
    }

    @Override
    public void printProfit(LottoResult lottoResult) {
        System.out.printf("총 수익률은 %.1f%%입니다.", lottoResult.getProfit());
    }
}

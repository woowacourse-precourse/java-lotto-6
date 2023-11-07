package lotto.view;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;

public class OutputView {
    //todo
    /**
     * 메세지 상수로 관리
     */

    private final StringBuilder stringBuilder;

    public OutputView(StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
    }

    public void printRequestPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
    }
    
    public void printLottoQuantity(int lottoQuantity) {
        String message = stringBuilder.append(lottoQuantity).append("개를 구매했습니다.").toString();

        System.out.println(message);
    }

    public void printLottoNumbers(List<Lotto> lottoNumbers) {
        for (Lotto lotto : lottoNumbers) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printRequestLottoNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printRequestBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printLotteryResult(EnumMap<LottoRank, Integer> lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("---");

        for (Map.Entry<LottoRank, Integer> rank : lottoResult.entrySet()) {
            System.out.println(rank.getKey().getMessage() + rank.getValue());
        }
    }

    public void printPrizeRatio(double ratio) {
        System.out.println("총 수익률은 " + ratio + "%입니다.");
    }
}

package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoList;
import lotto.model.PurchaseAmount;
import lotto.model.Result;
import lotto.model.value.Matching;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Stream;

import static lotto.view.LottoFormatter.*;

public class LottoView {

    public void printInputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printLottoNumber(LottoList lottoList) {
        System.out.println("\n8개를 구매했습니다.");
        Stream.of(lottoList.getLottoList())
                .forEach(lotto -> lotto.forEach(this::printLotto));
        System.out.println();
    }

    private void printLotto(Lotto lotto) {
        System.out.println(getLottoFormat(lotto));
    }

    public void printInputWinningNumber() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }

    public void printInputBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }

    public void printResult(Result result, PurchaseAmount purchaseAmount) {
        System.out.println("\n당첨 통계");
        System.out.println("---");

        Map<Matching, Integer> map = result.getResult();

        Arrays.stream(Matching.values())
                .sorted(Comparator.comparingInt(Matching::getPrizeMoney))
                .forEach(matching -> System.out.println(getStatisticsFormat(matching, map.get(matching))));

        System.out.println(getStatisticsRateFormat(result, purchaseAmount));
    }

}

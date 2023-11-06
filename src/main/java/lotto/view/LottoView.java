package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoList;
import lotto.model.PurchaseAmount;
import lotto.model.Result;
import lotto.model.value.Matching;

import java.util.Map;
import java.util.stream.Stream;

public class LottoView {

    public void printInputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printLottoNumber(LottoList lottoList) {
        System.out.println("8개를 구매했습니다.");
        Stream.of(lottoList.getLottoList())
                .forEach(lotto -> lotto.forEach(this::printLotto));
        System.out.println();
    }

    private void printLotto(Lotto lotto) {
        System.out.print("[" + String.join(",", lotto.getNumbersForString()) + "]");
    }

    public void printInputWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printInputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printResult(Result result, PurchaseAmount purchaseAmount) {
        System.out.println("당첨 통계");
        System.out.println("---");

        Map<Matching, Integer> map = result.getResult();
        map.forEach((matching, count) -> {
            System.out.println(String.format(
                    "%s (%s) - %d개",
                    matching.getMatchingNumber(),
                    matching.getPrizeMoney(),
                    count
            ));
        });
        System.out.println("총 수익률은 " + result.getRate(purchaseAmount) + "%입니다.");
    }

}

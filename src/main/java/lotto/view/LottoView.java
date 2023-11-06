package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoList;

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

}

package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {

    public static void purchaseLottoMessage(int purchasableLotto) {
        System.out.println(purchasableLotto+"개를 구매했습니다.");
    }

    public static void LottoNumberMessage(List<Lotto> lottoTickets) {
        for (Lotto lotto: lottoTickets) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void LineBreakMessage() {
        System.out.println();
    }
}

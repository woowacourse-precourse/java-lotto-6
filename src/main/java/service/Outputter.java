package service;

import java.util.List;
import lottomachine.Lotto;
import lottomachine.LottoResult;

public class Outputter {
    public void promptPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void promptLottoAmount(int amount) {
        System.out.println(amount + "개를 구매했습니다.");
    }

    public void promptLottoList(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getLottoNumbers();
            System.out.println(numbers);
        }
        System.out.println();
    }

    public void prmoptBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }


    public void promptWiningTicketNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void promptStatistics(List<LottoResult> resultList) {
        System.out.println("통계입니다.");
        for (LottoResult result : resultList) {
            System.out.println(result.getPrize());
            System.out.println(result.getRank());
        }

    }
}

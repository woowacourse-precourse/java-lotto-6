package service;

import java.util.List;
import lottomachine.Lotto;

public class Outputter {
    public void promptPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void promptLottoAmount(int amount) {
        System.out.println(amount + "개를 구입했습니다.");
    }

    public void promptLottoList(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getLottoNumbers();
            System.out.println(numbers);
        }
        System.out.println();
    }

    public void prmoptBunusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }


    public void promptWiningTicketNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }
}

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
            // Lotto 객체에서 번호 리스트를 가져오는 메소드가 있다고 가정합니다.
            List<Integer> numbers = lotto.getNumbers();
            System.out.println(numbers);
        }
    }


    public void promptWiningTicketNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }
}

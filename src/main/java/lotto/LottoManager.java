package lotto;


import java.util.List;

public class LottoManager {
    private List<Lotto> lottos;

    public LottoManager() {

    }

    public void run() {
        ConsoleView.print("구입금액을 입력해 주세요.");
        getMoney();

    }

    public void getMoney() {
        long money = ConsoleView.getLongInput();
        try {
            lottos = LottoPublisher.getInstance().sell(money);
        } catch (IllegalArgumentException e) {
            ConsoleView.print("[ERROR] 1000원 단위 양수로 입력해야 합니다.");
            getMoney();
        }
    }

}

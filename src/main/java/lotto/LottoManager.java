package lotto;


import java.util.List;

public class LottoManager {
    private List<Lotto> lottos;

    public LottoManager() {

    }

    public void run() {
        ConsoleView.print("구입금액을 입력해 주세요.");
        getMoney();
        showLottos();

    }

    public void getMoney() {
        long money = ConsoleView.getLongInput();
        try {
            lottos = LottoPublisher.getInstance().sell(money);
            ConsoleView.print(String.format("%d개를 구매했습니다.", lottos.size()));

        } catch (IllegalArgumentException e) {
            ConsoleView.print("[ERROR] 1000원 단위 양수로 입력해야 합니다.");
            getMoney();
        }
    }

    public void showLottos(){
        for(Lotto l: lottos){
            ConsoleView.print(l.toString());
        }
        ConsoleView.print("");
    }
}

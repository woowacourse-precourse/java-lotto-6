package lotto;

import java.util.List;

public class Program {
    private List<Lotto> consumerLottos = null;
    private Lotto winning = null;
    private Integer bonus = null;

    public void purchaseLottos() {
        Integer payment = 0;
        List<Lotto> lottos = null;
        while (true) {
            try {
                payment = UI.inputMoney();
                lottos = Store.sellLottos(payment);
                UI.printPurchases(lottos);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
                continue;
            }
            break;
        }
        this.consumerLottos = lottos;
    }

    public void insertWinningNumbers() {
        Lotto winning = null;
        while (true) {
            try {
                List<Integer> winningNumbers = UI.inputWinningNumbers();
                winning = new Lotto(winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
                continue;
            }
            break;
        }

        this.winning = winning;
    }

    public void insertBonusNumber() {
        Integer bonus = null;
        while (true) {
            try {
                bonus = UI.inputBonusNumber();
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
                continue;
            }
            break;
        }
        this.bonus = bonus;
    }
}
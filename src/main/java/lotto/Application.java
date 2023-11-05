package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Integer payment = UI.inputMoney();
        List<Lotto> lottos = Store.sellLottos(payment);
        UI.printPurchases(lottos);

        List<Integer> winningNumbers = UI.inputWinningNumbers();
        Integer bonusNumber = UI.inputBonusNumber();
        Lotto lotto = new Lotto(winningNumbers);
        LottoDrawResult drawResult = BroadCastingStation.drawLotto(lotto, bonusNumber);
        UI.printWinningStats(lottos, drawResult);
    }
}

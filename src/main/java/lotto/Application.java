package lotto;

import java.util.ArrayList;
import java.util.List;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        Money money = new Money(InputView.inputMoney());

        List<Lotto> lottoList = createdLottos(money);
        OutputView.printLottos(lottoList);
        List<Integer> winningLottoNumbers = InputView.inputWinningLotto();
        int bonusNumber = InputView.inputBonusNumber();
        WinningLotto winningLotto = new WinningLotto(new Lotto(winningLottoNumbers), bonusNumber);

        for (Lotto lotto : lottoList) {
            int matchCount = winningLotto.matchCount(lotto);
            boolean isBonus = winningLotto.isBonus(lotto);
        }
    }

    private static List<Lotto> createdLottos(Money money) {
        int ticketCount = money.geBuyTicket();
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            lottoList.add(new Lotto(LottoGenerator.generate()));
        }
        return lottoList;
    }
}

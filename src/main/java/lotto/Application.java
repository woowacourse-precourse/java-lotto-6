package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        Money money = new Money(InputView.inputMoney());

        List<Lotto> lottoList = createdLottos(money);
        OutputView.printLottos(lottoList);
        WinningLotto winningLotto = createdWinningLotto();

        Map<Result, Integer> resultCount = getResultCount(lottoList, winningLotto);

        OutputView.printResult(ticketCount, resultCount);
    }

    private static WinningLotto createdWinningLotto() {
        List<Integer> winningLottoNumbers = InputView.inputWinningLotto();
        int bonusNumber = InputView.inputBonusNumber();
        WinningLotto winningLotto = new WinningLotto(new Lotto(winningLottoNumbers), bonusNumber);
        return winningLotto;
    }

    private static Map<Result, Integer> getResultCount(List<Lotto> lottoList, WinningLotto winningLotto) {
        Map<Result, Integer> resultCount = new HashMap<>();
        for (Lotto lotto : lottoList) {
            int matchCount = winningLotto.matchCount(lotto);
            boolean isBonus = winningLotto.isBonus(lotto);
            Result result = Result.valueOf(matchCount, isBonus);
            resultCount.put(result, resultCount.getOrDefault(result, 0) + 1);
        }
        return resultCount;
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

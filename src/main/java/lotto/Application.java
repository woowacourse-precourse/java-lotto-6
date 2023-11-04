package lotto;

import lotto.domain.LottoNumbers;
import lotto.domain.PlayerLottoAmount;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        PlayerLottoAmount playerLottoAmount =
                new PlayerLottoAmount(InputView.inputPurchaseAmount());

        OutputView.printTicketCount(playerLottoAmount.calculateLottoCount());

        LottoNumbers lottoNumbers = new LottoNumbers();
        List<Integer> list = lottoNumbers.setRandomNumbers();
        System.out.println(list);

        Lotto lotto = new Lotto(InputView.inputLottoWinningNumber());

    }
}

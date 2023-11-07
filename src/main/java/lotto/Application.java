package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.util.LottoRandomNumbersGenerator;
import lotto.util.WinnerJudgementer;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {

        int lottoPurchaseAmount = InputView.getLottoPurchaseAmount();

        List<Lotto> lottoNumbers = LottoRandomNumbersGenerator.generateLottoNumbers(lottoPurchaseAmount);
        OutputView.printLottoNumbersByPurchaseAmount(lottoNumbers);

        Lotto winningNumbers = InputView.getWinningNumbers();
        int bonusNumber = InputView.getBonusNumber();

        Map<WinnerRating, Integer> winners = new HashMap<>();
        WinnerJudgementer.judgeWinners(lottoNumbers, winningNumbers, bonusNumber, winners);

    }
}

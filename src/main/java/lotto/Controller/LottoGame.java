package lotto.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import lotto.Domain.Lotto;
import lotto.Domain.LottoGenerator;
import lotto.Domain.CompareResults;
import lotto.View.InputView;
import lotto.View.OutputView;

public class LottoGame {

    private static List<Lotto> lottoList;
    private static List<Integer> lotto = new ArrayList<>();
    private static List<Integer> winningNumbers;
    private static int bonusNumber;

    public static void LottoGameRun()
    {
        int purchaseAmount = InputView.inputLottoPurchaseAmount();
        OutputView.printLottoAmount(purchaseAmount);

        lottoList = makeLottoList(purchaseAmount);
        winningNumbers = InputView.inputLottoNumbers();
        bonusNumber = InputView.inputBonusNumber();

        CompareResults.compareLottoResults(lottoList, winningNumbers, bonusNumber);


    }
    private static List<Lotto> makeLottoList(int ticketCount) {
        lottoList = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            lottoList.add(makeLotto());
        }
        return lottoList;
    }

    private static Lotto makeLotto() {
        LottoGenerator lottoNumbers = new LottoGenerator();
        lotto = new ArrayList<>();

        lotto = lottoNumbers.generateLottoNumbers();
        System.out.println(lotto);
        return new Lotto(lotto);
    }


}

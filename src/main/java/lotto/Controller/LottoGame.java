package lotto.Controller;

import java.util.ArrayList;
import java.util.List;
import lotto.Domain.Lotto;
import lotto.Domain.LottoGenerator;
import lotto.View.InputView;
import lotto.View.OutputView;

public class LottoGame {

    private static List<Lotto> lottoList;
    private static List<Integer> lotto = new ArrayList<>();

    public static void LottoGameRun()
    {
        int purchaseAmount = InputView.inputLottoPurchaseAmount();
        OutputView.printLottoAmount(purchaseAmount);

        lottoList = makeLottoList(purchaseAmount);


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

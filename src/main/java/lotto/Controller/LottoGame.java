package lotto.Controller;

import java.util.ArrayList;
import java.util.List;
import lotto.Domain.LottoPurchaseAmount;
import lotto.Domain.Lotto;
import lotto.Domain.LottoGenerator;
import lotto.Domain.CompareResults;
import lotto.View.InputView;
import lotto.View.OutputView;

public class LottoGame {

    public LottoGame() {}

/*    private static List<Lotto> lottoList;
    private static List<Integer> winningNumbers;
    private static int bonusNumber;*/

    private static LottoPurchaseAmount lottoPurchaseAmount;
    private static List<Integer> lotto = new ArrayList<>();
    private static List<Lotto> lottoList = new ArrayList<>();

    public void LottoGameRun() {

        int lottoPurchaseCount = inputPurchaseAmount();
        lottoList = makeLottoList(lottoPurchaseCount);

        OutputView.printLottoAmount(lottoPurchaseCount);
        OutputView.printPurchasedLottoList(lottoList);


    }

    public int inputPurchaseAmount() {
        try {
            lottoPurchaseAmount = new LottoPurchaseAmount(InputView.inputLottoPurchaseAmount());
            return lottoPurchaseAmount.calculatePurchaseLottoCount();
        } catch (IllegalArgumentException e) {
            return inputPurchaseAmount();
        }
    }

    private static List<Lotto> makeLottoList(int purchaseAmount) {
        lottoList = new ArrayList<>();

        for (int i = 0; i < purchaseAmount; i++) {
            lottoList.add(makeLotto());
        }
        return lottoList;
    }

    private static Lotto makeLotto() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Integer> lottoNumbers = lottoGenerator.generateLottoNumbers();

        return new Lotto(lottoNumbers);
    }

    private static List<Integer> parseLottoNumbers(String input) {

        List<Integer> lottoNumbers = new ArrayList<>();
        ;

        String[] eachLottoNumbers = input.split(",");

        for (String token : eachLottoNumbers) {
            int lottoNumber = Integer.parseInt(token);
            lottoNumbers.add(lottoNumber);
        }

        return lottoNumbers;
    }

}

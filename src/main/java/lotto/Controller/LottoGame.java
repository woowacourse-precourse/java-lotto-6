package lotto.Controller;

import java.util.ArrayList;
import java.util.List;
import lotto.Domain.BonusNumber;
import lotto.Domain.CompareResult;
import lotto.Domain.LottoPurchaseAmount;
import lotto.Domain.Lotto;
import lotto.Domain.LottoGenerator;
import lotto.Domain.WinningResult;
import lotto.View.InputView;
import lotto.View.OutputView;

public class LottoGame {

    public LottoGame() {}
    private static LottoPurchaseAmount lottoPurchaseAmount;
    private static BonusNumber bonusNumber;
    private static Lotto lotto;
    private static List<Lotto> lottoList;
    private static List<Integer> winningLottoNumbers;
    private static int winningBonusNumber;
    private static CompareResult compareResult;

    public void LottoGameRun() {

        int lottoPurchaseCount = inputPurchaseAmount();
        lottoList = makeLottoList(lottoPurchaseCount);

        OutputView.printLottoAmount(lottoPurchaseCount);
        OutputView.printPurchasedLottoList(lottoList);

        winningLottoNumbers = inputLottoNumbers();
        winningBonusNumber = inputBonusNumber();

        lottoList = makeLottoList(lottoPurchaseCount);
        compareResult = validateBonusNumber();



    }

    public int inputPurchaseAmount() {
        try {
            lottoPurchaseAmount = new LottoPurchaseAmount(InputView.inputLottoPurchaseAmount());
            return lottoPurchaseAmount.calculatePurchaseLottoCount();
        } catch (IllegalArgumentException e) {
            return inputPurchaseAmount();
        }
    }

    private List<Integer> inputLottoNumbers()
    {
        try{
            lotto = new Lotto(InputView.inputLottoNumbers());
            return lotto.getLottoNumbers();
        }
        catch(IllegalArgumentException e){
            return inputLottoNumbers();
        }
    }

    private static int inputBonusNumber()
    {
        try{
            bonusNumber = new BonusNumber(InputView.inputBonusNumber());
            return bonusNumber.conveyBonusNumber();
        }
        catch(IllegalArgumentException e){
            return inputBonusNumber();
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

    public CompareResult validateBonusNumber() {
        Lotto lotto = new Lotto(InputView.inputLottoNumbers()));
        List<Integer> compareNumber = lotto.getLottoNumbers();
        int bonusNum = inputBonusNumber();
        lotto.validateBonusNumberDuplicate(compareNumber, bonusNum);
        compareResult= new CompareResult(new Lotto(compareNumber), bonusNum);

        return compareResult;
    }
}

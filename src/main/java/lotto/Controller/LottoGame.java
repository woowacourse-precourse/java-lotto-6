package lotto.Controller;

import java.util.ArrayList;
import java.util.List;
import lotto.Domain.BonusNumber;
import lotto.Domain.LottoPurchaseAmount;
import lotto.Domain.Lotto;
import lotto.Domain.LottoGenerator;
import lotto.Domain.CompareResults;
import lotto.View.InputView;
import lotto.View.OutputView;

public class LottoGame {

    public LottoGame() {}
    private static LottoPurchaseAmount lottoPurchaseAmount;
    private static List<Lotto> lottoList;
    private static List<Integer> winningLottoNumbers;
    private static int bonusNumber;



    public void LottoGameRun() {

        int lottoPurchaseCount = inputPurchaseAmount();
        lottoList = makeLottoList(lottoPurchaseCount);

        OutputView.printLottoAmount(lottoPurchaseCount);
        OutputView.printPurchasedLottoList(lottoList);

        winningLottoNumbers = parseLottoNumbers(InputView.inputLottoNumbers());
        bonusNumber = inputBonusNumber();


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

    private static int inputBonusNumber()
    {
        try{
            bonusNumber = new BonusNumber(InputView.inputBonusNumber());
            return bonusNumber;
        }
        catch(IllegalArgumentException e){
            return inputBonusNumber();
        }
    }




}

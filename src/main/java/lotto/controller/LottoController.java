package lotto.controller;

import static lotto.domain.BonusNumber.bonusNumber;
import static lotto.domain.WinningNumbers.createWinningNumbers;
import static lotto.domain.WinningNumbers.getWinningNumbers;
import static lotto.exception.ErrorMessage.RUN_MESSAGE;
import static lotto.view.InputView.requestBonusNumber;
import static lotto.view.InputView.requestLotteryNumber;
import static lotto.view.InputView.requestPurchaseAmount;
import static lotto.view.OutputView.responseCount;
import static lotto.view.OutputView.responseLottoNumber;
import static lotto.view.OutputView.responseResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.domain.PurchaseAmount;
import lotto.domain.Result;
import lotto.exception.LottoException;

public class LottoController {
    private static int count;
    private static int bonusNumber;
    private static List<Integer> randomNumbers = new ArrayList<>();
    private static List<Lotto> lotto;
    private static List<Integer> winningNumbers;
    public static void prosess (){
        start();
        createLottoNumber();
        inputWinningNumbers();
        result();
    }

    public static void start() {
            PurchaseAmount.creat(requestPurchaseAmount());
            count = PurchaseAmount.count;
            responseCount(count);

    }

    public static List<Lotto> createLottoNumber() {

        lotto = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lotto.add(createLotto());
        }
        return lotto;
    }

    private static Lotto createLotto() {
        LottoNumbers lottoNumbers = new LottoNumbers();

        randomNumbers = lottoNumbers.setLottoNumbers();
        responseLottoNumber(randomNumbers);
        return new Lotto(randomNumbers);
    }


    public static void inputWinningNumbers() {
        String input = requestLotteryNumber();
        createWinningNumbers(input);

    }

    public static void inputBonusNumber(List<Integer> winningNumbers){
        String input = requestBonusNumber();
        bonusNumber = bonusNumber(input, winningNumbers);
    }

    public static void result() {

        winningNumbers = getWinningNumbers();
        inputBonusNumber(winningNumbers);

        Map<String, Object> result = Result.calculateResult(lotto, winningNumbers, bonusNumber);
        responseResult(result);
    }


}
package lotto.controller;

import static lotto.parser.Parser.parseWinningNumbers;
import static lotto.view.InputView.requestBonusNumber;
import static lotto.view.InputView.requestLotteryNumber;
import static lotto.view.InputView.requestPurchaseAmount;
import static lotto.view.OutputView.responseCount;
import static lotto.view.OutputView.responseLottoNumber;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.domain.PurchaseAmount;

public class LottoController {

    private static int count;
    private static List<Integer> lotto = new ArrayList<>();
    private static List<Lotto> lottoList;
    public static void prosess (){
        start();
        createRandomNumber();
    }

    public static void start() {
        PurchaseAmount.creat(requestPurchaseAmount());

        count = PurchaseAmount.count;
        responseCount(count);
    }

    public static List<Lotto> createRandomNumber() {

        lottoList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottoList.add(createLotto());
        }
        return lottoList;

    }

    private static Lotto createLotto() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        lotto = new ArrayList<>();

        lotto = lottoNumbers.setRandomNumbers();
        responseLottoNumber(lotto);

        return new Lotto(lotto);
    }


    public static void inputWinningNumber() {
        parseWinningNumbers(requestLotteryNumber());
        requestBonusNumber();
    }

}
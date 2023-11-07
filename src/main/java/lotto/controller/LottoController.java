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
import lotto.domain.WinningNumbers;
import lotto.validator.InputValidator;
import lotto.view.InputView;

public class LottoController {

    private static int count;
    private static List<Integer> randomNumbers = new ArrayList<>();
    private static List<Lotto> lotto;
    private static List<Integer> winningNumbers;
    public static void prosess (){
        start();
        createLottoNumber();
        inputWinningNumber();
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


    public static void inputWinningNumber() {
        String input = requestLotteryNumber();
        InputValidator.validateEmpty(input);
        InputValidator.validateInputFormat(input);

        WinningNumbers.createWinningNumber(input);
    }

}
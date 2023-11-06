package lotto.controller;

import static lotto.util.Constant.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Result;
import lotto.model.WinnerLotto;
import lotto.util.converter.NumericConverter;
import lotto.util.converter.NumericListConverter;
import lotto.util.validator.AmountValidator;
import lotto.util.validator.BonusValidator;
import lotto.util.validator.WinnerLottoValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {


    private final NumericListConverter numericListConverter = new NumericListConverter();
    private final NumericConverter numericConverter = new NumericConverter();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final AmountValidator amountValidator = new AmountValidator();
    private final WinnerLottoValidator winnerLottoValidator = new WinnerLottoValidator();
    private final BonusValidator bonusValidator = new BonusValidator();

    public void run() {
        int amount = getAmount();
        outputView.printAmount(amount);
        Lottos lottos = new Lottos(buyLotto(amount));
        Lotto winnerLottoOnlyNumbers = getWinnerLotto();
        WinnerLotto winnerLotto = new WinnerLotto(winnerLottoOnlyNumbers, getBonusNumber(winnerLottoOnlyNumbers));
        Result result = new Result(lottos.calculateResult(winnerLotto));
        outputView.printResult(result);
        outputView.printProfitRate(result.calculateProfitRate(amount));
    }

    private int getBonusNumber(Lotto winnerLottoOnlyNumbers) {
        String input;
        do{
            input = inputView.readBonusNumber();
        }while(!bonusValidator.validation(input,winnerLottoOnlyNumbers));
        return numericConverter.convert(input);
    }

    private Lotto getWinnerLotto() {
        String input;
        do {
            input = inputView.readWinnerLottoNumbers();
        }while (!winnerLottoValidator.validation(input));
        return new Lotto(numericListConverter.convert(input));
    }

    private int getAmount() {
        String input;
        int amount;
        do {
            input = inputView.readAmount();
        } while (!amountValidator.validation(input));
        amount = numericConverter.convert(input) / LOTTO_PRICE;
        return amount;
    }

    private List<Lotto> buyLotto(int count) {
        List<Lotto> lottos = IntStream.range(0, count)
                .mapToObj(i -> new Lotto(Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, LOTTO_LENGTH)))
                .collect(Collectors.toList());
        outputView.printLottoInformation(lottos);
        return lottos;
    }


}

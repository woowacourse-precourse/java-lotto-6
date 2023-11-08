package lotto.controller;

import static lotto.constants.LottoConstants.MAX_LOTTO_NUMBER;
import static lotto.constants.LottoConstants.MIN_LOTTO_NUMBER;
import static lotto.constants.LottoConstants.NUMBER_OF_LOTTO_NUMBERS;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import lotto.converter.MessageConverter;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Result;
import lotto.model.dto.PayDTO;
import lotto.model.dto.WinningNumDTO;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final Lottos lottos;

    public LottoController() {
        List<Lotto> newLottos = buyLottos();
        this.lottos = new Lottos(newLottos);
    }
    private static List<Lotto> buyLottos() {
        PayDTO payDTO = InputView.readPayment();
        List<Lotto> new_lottos = new ArrayList<>();
        IntStream.range(0, payDTO.getNumberOfLotto()).forEach(i -> new_lottos.add(createLotto()));
        return new_lottos;
    }
    private static Lotto createLotto() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, NUMBER_OF_LOTTO_NUMBERS));
        Collections.sort(numbers);
        return new Lotto(numbers);
    }

    public void checkPurchasedLottos() {
        int numberOfLotto = lottos.getNumberOfLotto();
        String purchasedLottos = lottos.writePurchasedLottos();
        OutputView.printPurchasedLottos(numberOfLotto, purchasedLottos);
    }

    public void checkResult() {
        WinningNumDTO winningNumDTO = readWinningNumsAndBonus();
        Result result = lottos.checkResult(winningNumDTO);
        OutputView.printResult(result);
    }

    public WinningNumDTO readWinningNumsAndBonus() {
        return InputView.readWinningNumsAndBonus();
    }
}

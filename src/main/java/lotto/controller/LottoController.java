package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
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
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(numbers);
        return new Lotto(numbers);
    }

    public void checkPurchasedLottos() {
        String resultOfPurchasedLottos = lottos.getPurchasedLottos();
        int numberOfLotto = lottos.getNumberOfLotto();
        OutputView.printPurchasedLottos(numberOfLotto, resultOfPurchasedLottos);
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

package lotto.controller;

import static lotto.constant.LottoConstant.LOTTO_NUMBER_AMOUNT;
import static lotto.constant.LottoConstant.MAX_LOTTO_NUMBER;
import static lotto.constant.LottoConstant.MIN_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Money;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView(outputView);

    public void run() {
        Money money = inputMoney();
        List<Lotto> lottos = purchaseLottos(money.getCount());

        WinningNumbers winningNumbers = getTotalWinningNumbers();
        LottoResult lottoResult = winningNumbers.checkLottos(lottos);
    }

    private Money inputMoney() {
        try {
            int amount = inputView.readLottoPurchaseMoney();
            return new Money(amount);
        } catch (IllegalArgumentException error) {
            outputView.printErrorMessage(error);
            return inputMoney();
        }
    }

    private List<Lotto> purchaseLottos(int count) {
        List<Lotto> lottos = generateLottos(count);
        printLottos(lottos);
        return lottos;
    }

    private List<Lotto> generateLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(generateLottoNumbers()));
        }

        return lottos;
    }

    private List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBER_AMOUNT);
    }

    private void printLottos(List<Lotto> lottos) {
        outputView.printLottos(lottos);
    }

    private WinningNumbers getTotalWinningNumbers() {
        Lotto winningNumbers = getWinningNumbers();
        return createTotalWinningNumbers(winningNumbers);
    }

    private Lotto getWinningNumbers() {
        try {
            return new Lotto(inputView.readWinningNumbers());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return getWinningNumbers();
        }
    }

    private WinningNumbers createTotalWinningNumbers(Lotto lotto) {
        try {
            return new WinningNumbers(lotto, inputView.readBonusNumber());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return createTotalWinningNumbers(lotto);
        }
    }
}

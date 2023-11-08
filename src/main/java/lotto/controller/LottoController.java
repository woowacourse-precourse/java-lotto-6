package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        int purchaseAmount = inputView.getPurchaseAmount();
        List<Lotto> lottoList = generateLotto(purchaseAmount);

        outputView.showMessage(lottoList.size() + "개를 구매했습니다.");
        outputView.showLottos(lottoList);

        List<Integer> winningNumbers = inputView.getWinningNumbers();
        int bonusNumber = inputView.getBonusNumber();

        Result result = new Result(lottoList, winningNumbers, bonusNumber);

        outputView.showResult(result);
    }

    private static List<Lotto> generateLotto(int purchaseAmount) {
        List<Lotto> lottoList = new ArrayList<>();
        int numberOfLottoList = purchaseAmount / 1000;

        for (int i = 0; i < numberOfLottoList; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(lottoNumbers);
            lottoList.add(lotto);
        }
        return lottoList;
    }

}

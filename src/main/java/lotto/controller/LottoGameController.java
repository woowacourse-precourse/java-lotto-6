package lotto.controller;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.ArrayList;
import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.Price;
import lotto.model.WinnerNumber;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

public class LottoGameController {
    private InputView inputView;
    private OutputView outputView;

    public LottoGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        List<Lotto> lottos = buyLotto();
        List<Integer> winnerAndBonus = selectWinnerNumberAndBonusNumber();

        for (Lotto lotto : lottos) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            int matchCount = countMatchingNumbers(lottoNumbers, winnerAndBonus);

        }
        outputView.printWinningStatistics();

    }

    private List<Lotto> buyLotto() {
        outputView.printInputPrice();
        Price price = new Price(inputView.inputPrice());
        outputView.printLottoCount(price.getCount());

        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < price.getCount(); i++) {
            Lotto lotto = new Lotto(createLottoNumbers());
            outputView.printLottoNumber(lotto);
            lottos.add(lotto);
        }

        return lottos;
    }

    private List<Integer> createLottoNumbers() {
        return pickUniqueNumbersInRange(1, 45, 6);
    }

    private List<Integer> selectWinnerNumberAndBonusNumber() {
        outputView.printWinnerNumber();
        WinnerNumber winnerNumber = new WinnerNumber(inputView.inputWinnerNumber());

        outputView.printBonusNumber();
        BonusNumber bonusNumber = new BonusNumber(inputView.inputBonusNumber());

        List<Integer> winnerAndBonus = new ArrayList<>();
        winnerAndBonus.addAll(winnerNumber.getWinnerNumbers());
        winnerAndBonus.add(bonusNumber.getBonusNumber());

        return winnerAndBonus;
    }

    private int countMatchingNumbers(List<Integer> lottoNumbers, List<Integer> winnerAndBonus) {
        int count = 0;
        for (Integer lottoNumber : lottoNumbers) {
            if (winnerAndBonus.contains(lottoNumber)) {
                count++;
            }
        }
        return count;
    }
}

package lotto.controller;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.Price;
import lotto.model.PrizeMoney;
import lotto.model.Statistics;
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
        // 로또 구입
        outputView.printInputPrice();
        Price price = new Price(inputView.inputPrice());
        outputView.printLottoCount(price.getCount());

        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < price.getCount(); i++) {
            Lotto lotto = new Lotto(createLottoNumbers());
            outputView.printLottoNumber(lotto);
            lottos.add(lotto);
        }

        // 당첨 번호 입력
        outputView.printWinnerNumber();
        WinnerNumber winnerNumber = new WinnerNumber(inputView.inputWinnerNumber());

        // 보너스 번호 입력
        outputView.printBonusNumber();
        BonusNumber bonusNumber = new BonusNumber(inputView.inputBonusNumber());

        //로또 통계

        Map<Integer, Integer> matchingCount = new HashMap<>();
        List<Statistics> result = new ArrayList<>();
        PrizeMoney prizeMoney = new PrizeMoney();
        int earningMoney = 0;

        for (int i = 3; i <= 6; i++) {
            matchingCount.put(i, 0);
        }

        //당첨 번호 & 로또 번호 비교 - 통계 계산 전으로 옮겨야할듯....
        for (Lotto lotto : lottos) {
            int matchCount = countMatchingNumbers(lotto.getNumbers(), winnerNumber.getWinnerNumbers());
            boolean matchBonus = isMatchingBonusNumber(lotto.getNumbers(), bonusNumber.getBonusNumber());
            result.add(new Statistics(matchCount, matchBonus));
        }

        for (Statistics statistics : result) {
            int matchCount = statistics.getMatchCount();
            int currentCount = matchingCount.getOrDefault(matchCount, 0);
            matchingCount.put(matchCount, currentCount + 1);

            earningMoney += prizeMoney.getPrizeMoney(matchCount);
            if (matchCount == 5 && statistics.isMatchBonus()) {
                earningMoney += 1500000;
            }
        }

        outputView.printWinningStatistics();
        outputView.printMatchingCount(matchingCount);
        outputView.printEarningPercent(earningMoney, price.getPrice());
    }

    private boolean isMatchingBonusNumber(List<Integer> lotto, int bonusNumber) {
        for (Integer number : lotto) {
            if (number.equals(bonusNumber)) {
                return true;
            }
        }
        return false;
    }


    private List<Integer> createLottoNumbers() {
        return pickUniqueNumbersInRange(1, 45, 6);
    }


    private int countMatchingNumbers(List<Integer> lottoNumbers, List<Integer> winnerNumbers) {
        int count = 0;
        for (Integer lottoNumber : lottoNumbers) {
            if (winnerNumbers.contains(lottoNumber)) {
                count++;
            }
        }
        return count;
    }

}

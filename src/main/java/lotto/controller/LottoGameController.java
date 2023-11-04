package lotto.controller;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.PrizeMoney;
import lotto.model.PurchasePrice;
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
        outputView.printInputPurchasePrice();
        PurchasePrice purchasePrice = new PurchasePrice(inputView.inputPurchasePrice());
        outputView.printLottoCount(purchasePrice.getCount());

        List<Lotto> lottos = buyLotto(purchasePrice);

        // 당첨 번호 입력
        outputView.printWinnerNumber();
        WinnerNumber winnerNumber = new WinnerNumber(inputView.inputWinnerNumber());

        // 보너스 번호 입력
        outputView.printBonusNumber();
        BonusNumber bonusNumber = new BonusNumber(inputView.inputBonusNumber());

        //당첨 번호 & 로또 번호 비교
        List<Statistics> result = calculateMatching(lottos, winnerNumber, bonusNumber);

        //로또 통계
        Map<Statistics, Integer> matchingCount = new HashMap<>();
        PrizeMoney prizeMoney = new PrizeMoney();

        int earningMoney = calculateStatistics(result, matchingCount, prizeMoney);

        outputView.printWinningStatistics();
        outputView.printMatchingCount(matchingCount);
        outputView.printEarningPercent(earningMoney, purchasePrice.getPurchasePrice());
    }

    private List<Lotto> buyLotto(PurchasePrice purchasePrice) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < purchasePrice.getCount(); i++) {
            Lotto lotto = new Lotto(createLottoNumbers());
            outputView.printLottoNumber(lotto);
            lottos.add(lotto);
        }
        return lottos;
    }

    private List<Integer> createLottoNumbers() {
        return pickUniqueNumbersInRange(1, 45, 6);
    }

    private int calculateStatistics(List<Statistics> result, Map<Statistics, Integer> matchingCount,
                                           PrizeMoney prizeMoney) {
        int earningMoney = 0;

        for (Statistics statistics : result) {
            Statistics matchCount = new Statistics(statistics.getMatchCount(), statistics.isMatchBonus());
            int currentCount = matchingCount.getOrDefault(matchCount, 0);
            matchingCount.put(matchCount, currentCount + 1);

            earningMoney += prizeMoney.getPrizeMoney(matchCount.getMatchCount());
            if (matchCount.getMatchCount() == 5 && statistics.isMatchBonus()) {
                earningMoney += 1500000;
            }
        }
        return earningMoney;
    }

    private List<Statistics> calculateMatching(List<Lotto> lottos, WinnerNumber winnerNumber, BonusNumber bonusNumber) {
        List<Statistics> result = new ArrayList<>();
        for (Lotto lotto : lottos) {
            int matchCount = countMatchingNumbers(lotto.getNumbers(), winnerNumber.getWinnerNumbers());
            boolean matchBonus = isMatchingBonusNumber(lotto.getNumbers(), bonusNumber.getBonusNumber());
            result.add(new Statistics(matchCount, matchBonus));
        }
        return result;
    }

    private boolean isMatchingBonusNumber(List<Integer> lotto, int bonusNumber) {
        for (Integer number : lotto) {
            if (number.equals(bonusNumber)) {
                return true;
            }
        }
        return false;
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

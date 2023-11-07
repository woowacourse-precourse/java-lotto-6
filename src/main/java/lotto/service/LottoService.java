package lotto.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lotto.Lotto;
import lotto.enums.WinningRank;
import lotto.utils.RandomGenerator;
import lotto.view.OutputView;

public class LottoService {
    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 45;
    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final int LOTTO_AMOUNT = 1000;
    private final List<Lotto> lottos = new ArrayList<>();

    public LottoService() {
    }

    public void publishLottos(int payAmount) {
        int lottoCount = calculateLottoCount(payAmount);
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumbers = generateLottoNumbers();
            lottos.add(new Lotto(lottoNumbers));
        }

        OutputView.printPaySuccessMessageMessage(lottoCount);
        OutputView.printLottos(lottos);

    }

    public List<Integer> generateLottoNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>();
        while (lottoNumbers.size() < LOTTO_NUMBER_SIZE) {
            int randomNumber = RandomGenerator.getRandomNumber(MINIMUM_NUMBER, MAXIMUM_NUMBER);
            if (!lottoNumbers.contains(randomNumber)) {
                lottoNumbers.add(randomNumber);
            }
        }
        return lottoNumbers;
    }

    public int calculateLottoCount(int payAmount) {
        int lottoCount = payAmount / LOTTO_AMOUNT;
        return lottoCount;
    }

    public void announceWinningResult(List<Integer> jackpotNumbers, int bonusNumber) {
        OutputView.printWinningStatisticsMessage();
        HashMap<WinningRank, Integer> winningStatistics = getWinningStatistics(jackpotNumbers, bonusNumber);
        OutputView.printWinningStatistics(winningStatistics);

        // TODO : 총 수익률 계산
    }

    private HashMap<WinningRank, Integer> getWinningStatistics(List<Integer> jackpotNumbers, int bonusNumber) {
        HashMap<WinningRank, Integer> winningStatistics = new HashMap<>();
        initHashMap(winningStatistics);

        for (Lotto lotto : lottos) {
            int winningRank = countMatchNumber(lotto, jackpotNumbers, bonusNumber);
            if (winningRank >= 3) {
                WinningRank rank = WinningRank.fromMatchNumber(winningRank);
                int oldValue = winningStatistics.get(rank);
                winningStatistics.put(rank, oldValue + 1);
            }
        }
        return winningStatistics;
    }

    private static void initHashMap(HashMap<WinningRank, Integer> winningStatistics) {
        winningStatistics.put(WinningRank.FIRST, 0);
        winningStatistics.put(WinningRank.SECOND, 0);
        winningStatistics.put(WinningRank.THIRD, 0);
        winningStatistics.put(WinningRank.FOURTH, 0);
        winningStatistics.put(WinningRank.FIFTH, 0);
    }

    private int countMatchNumber(Lotto lotto, List<Integer> jackpotNumbers, int bonusNumber) {
        int matchCount = 0;
        for (int number : lotto.getNumbers()) {
            if (jackpotNumbers.contains(number)) {
                matchCount++;
            }
        }

        if (matchCount == 5 && lotto.getNumbers().contains(bonusNumber)) {
            return 7;
        }

        return matchCount;
    }
}

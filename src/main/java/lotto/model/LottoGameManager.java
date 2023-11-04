package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGameManager {
    private static final LottoNumberComparator lottoNumberComparator = new LottoNumberComparator();

    public static int calculateLottoCount(Amount amount) {
        return amount.getAmount() / 1000;
    }

    public static List<Lotto> buyLotto(int lottoCount) {
        OutputView.displayLottoCount(lottoCount);
        return IntStream.range(0, lottoCount)
                .mapToObj(i -> new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)))
                .collect(Collectors.toList());
    }

    public static void generateWinningLotto(List<String> numbersStr) {
        lottoNumberComparator.setWinningLotto(new WinningLotto(numbersStr));
    }

    public static void generateBonusNumber(String bonusNumberStr) {
        lottoNumberComparator.setBonusNumber(new BonusNumber(bonusNumberStr));
    }

    public static List<LottoMatch> getWinningResults(List<Lotto> lottoList) {
        return lottoNumberComparator.calculateMatches((lottoList));
    }

    public static Double calculateYield(List<LottoMatch> winningResults, Amount amount) {
        return (calculatePrize(winningResults) / Double.valueOf(amount.getAmount()) - 1) * 100;
    }

    private static int calculatePrize(List<LottoMatch> lottoResultCount) {
        return lottoResultCount.stream()
                .mapToInt(LottoMatch::getAmount)
                .sum();
    }
}

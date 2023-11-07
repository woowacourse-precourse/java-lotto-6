package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGameManager {
    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int PERCENTAGE = 100;
    private static final int LOTTO_PRICE = 1000;
    private static LottoNumberComparator lottoNumberComparator;

    public static int calculateLottoCount(Amount amount) {
        return amount.getAmount() / LOTTO_PRICE;
    }

    public static List<Lotto> buyLotto(int lottoCount) {
        return IntStream.range(0, lottoCount)
                .mapToObj(i -> new Lotto(Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBER_SIZE)))
                .collect(Collectors.toList());
    }

    public static void generateWinningNumbers(Lotto winningLotto, String bonusNumberStr) {
        lottoNumberComparator = LottoNumberComparator.init(WinningLotto.create(winningLotto, bonusNumberStr));
    }

    public static List<LottoMatch> getWinningResults(List<Lotto> lottoList) {
        return lottoNumberComparator.calculateMatches(lottoList);
    }

    public static Double calculateYield(List<LottoMatch> winningResults, Amount amount) {
        return calculatePrize(winningResults) / Double.valueOf(amount.getAmount()) * PERCENTAGE;
    }

    private static int calculatePrize(List<LottoMatch> lottoMatchList) {
        return lottoMatchList.stream()
                .mapToInt(LottoMatch::getAmount)
                .sum();
    }
}

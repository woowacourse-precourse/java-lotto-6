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
    private static LottoNumberComparator lottoNumberComparator;

    public static int calculateLottoCount(Amount amount) {
        return amount.getAmount() / 1000;
    }

    public static List<Lotto> buyLotto(int lottoCount) {
        return IntStream.range(0, lottoCount)
                .mapToObj(i -> new Lotto(Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBER_SIZE)))
                .collect(Collectors.toList());
    }

    public static void generateWinningNumbers(List<String> numbersStr, String bonusNumberStr) {
        if (numbersStr.contains(bonusNumberStr)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
        lottoNumberComparator = LottoNumberComparator.create(generateWinningLotto(numbersStr), generateBonusNumber(bonusNumberStr));
    }

    public static WinningLotto generateWinningLotto(List<String> numbersStr) {
        return new WinningLotto(numbersStr);
    }

    public static BonusNumber generateBonusNumber(String bonusNumberStr) {
        return new BonusNumber(bonusNumberStr);
    }

    public static List<LottoMatch> getWinningResults(List<Lotto> lottoList) {
        return lottoNumberComparator.calculateMatches(lottoList);
    }

    public static Double calculateYield(List<LottoMatch> winningResults, Amount amount) {
        return calculatePrize(winningResults) / Double.valueOf(amount.getAmount()) * PERCENTAGE;
    }

    private static int calculatePrize(List<LottoMatch> lottoResultCount) {
        return lottoResultCount.stream()
                .mapToInt(LottoMatch::getAmount)
                .sum();
    }
}

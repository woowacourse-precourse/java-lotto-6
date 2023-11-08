package lotto.util;

import static lotto.Constants.DECIMAL_PLACES;
import static lotto.Constants.LOTTO_NUMBER_MAX;
import static lotto.Constants.LOTTO_NUMBER_MIN;
import static lotto.Constants.MAX_LOTTO_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import lotto.model.Lotto;
import lotto.model.Prize;
import lotto.model.WinningLotto;
import lotto.util.parser.LottoParser;

public class LottoUtil {
    /**
     * Description: 로또들을 생성해 반환한다.
     */
    public static List<Lotto> generateLottos(int lottoCount) {
        List<Lotto> generatedLottos = new ArrayList<>();
        IntStream.range(0, lottoCount).forEach(i -> {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX,
                    MAX_LOTTO_SIZE);
            generatedLottos.add(new Lotto(numbers));
        });
        return generatedLottos;
    }

    /**
     * Description: 당첨 번호와 구입한 로또들을 비교하여 각 Prize별 당첨 횟수를 계산해 Map으로 반환한다.
     */
    public static Map<Prize, Integer> calculatePrizeCounts(List<Lotto> purchasedLottos, WinningLotto winningLotto) {
        Map<Prize, Integer> prizeCounts = new LinkedHashMap<>();
        for (Prize prize : Prize.values()) {
            prizeCounts.put(prize, 0);
        }
        purchasedLottos.forEach(lotto -> {
            try {
                Prize prize = LottoParser.parseLottoToPrize(lotto, winningLotto);
                prizeCounts.put(prize, prizeCounts.get(prize) + 1);
            } catch (IllegalArgumentException ignored) {
            }
        });
        return prizeCounts;
    }

    /**
     * Description: 총 상금을 계산해 반환한다.
     */
    public static double calculateTotalPrizeAmount(Map<Prize, Integer> prizeCounts) {
        return prizeCounts.keySet().stream()
                .mapToDouble(prize -> prize.getPrizeMoney() * prizeCounts.get(prize))
                .sum();
    }

    /**
     * Description: 수익률을 소수점 둘째 자리에서 반올림해 계산해 반환한다.
     */
    public static double calculateProfitPercentage(double totalPrizeAmount, int purchaseAmount) {
        BigDecimal roundedValue = BigDecimal.valueOf((totalPrizeAmount / purchaseAmount) * 100.0)
                .setScale(DECIMAL_PLACES, RoundingMode.HALF_UP);
        return roundedValue.doubleValue();
    }
}

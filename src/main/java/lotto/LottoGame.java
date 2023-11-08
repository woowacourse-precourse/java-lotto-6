package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoGame {
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final int LOTTO_NUMBERS_COUNT = 6;


    public static void startGame() {
        try {
            int purchaseAmount = LottoUI.inputPurchaseAmount();
            int lottoCount = purchaseAmount / LOTTO_PRICE;

            List<Lotto> lottos = purchaseLottos(lottoCount);
            LottoUI.printLottos(lottos);

            List<Integer> winningNumbers = LottoUI.inputWinningNumbers();
            int bonusNumber = LottoUI.inputBonusNumbers(winningNumbers);

            showResults(lottos, winningNumbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    private static List<Lotto> purchaseLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(generateRandomLottoNumbers()));
        }
        return lottos;
    }

    private static List<Integer> generateRandomLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, LOTTO_NUMBERS_COUNT)
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }



    private static void showResults(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        Map<LottoRank, Integer> rankCounts = new EnumMap<>(LottoRank.class);

        for (Lotto lotto : lottos) {
            int matchCount = getMatchCount(lotto, winningNumbers);
            boolean bonusMatch = isBonusMatch(lotto, bonusNumber, matchCount);
            LottoRank rank = LottoRank.valueOf(matchCount, bonusMatch);

            rankCounts.merge(rank, 1, Integer::sum);
        }

        LottoUI.printResults(rankCounts);
        LottoUI.calculateEarnings(rankCounts, lottos.size());
    }

    private static int getMatchCount(Lotto lotto, List<Integer> winningNumbers) {
        return (int) lotto.getNumbers().stream().filter(winningNumbers::contains).count();
    }

    private static boolean isBonusMatch(Lotto lotto, int bonusNumber, int matchCount) {
        return matchCount == 5 && lotto.getNumbers().contains(bonusNumber);
    }

    private static void updateWinCounts(int[] winCounts, int matchCount, boolean bonusMatch) {
        if (matchCount < 5 && matchCount > 2) {
            winCounts[matchCount]++;
        } else if (matchCount == 5) {
            if (bonusMatch) {
                winCounts[2]++; // 2등
            } else {
                winCounts[3]++; // 3등
            }
        } else if (matchCount == 6) {
            winCounts[1]++; // 1등
        }
    }


}

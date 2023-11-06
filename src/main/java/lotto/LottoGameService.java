package lotto;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoGameService {

    private static final int lottoPrice = 1000;
    private static final int initialCount = 0;
    private final List<List<Integer>> purchasedLottoNumbers = new ArrayList<>();
    private final EnumMap<LottoRank, Integer> lottoRakingMap = new EnumMap<>(LottoRank.class);

    public LottoGameService() {
        for (LottoRank rank : LottoRank.values()) {
            lottoRakingMap.put(rank, initialCount);
        }
    }

    public void generateLottoNumbers() {
        Lotto lotto = new Lotto(LottoNumbersGenerator.generateLottoNumbers());
        purchasedLottoNumbers.add(lotto.getNumbers());
    }

    public int getLottoTicketCount(int lottoPurchaseAmount) {
        return lottoPurchaseAmount / lottoPrice;
    }

    public List<List<Integer>> getPurchasedLottoNumbers() {
        return purchasedLottoNumbers;
    }

    public List<Integer> convertWinningNumbersToCollection(String lottoWinningNumbers) {
        return Stream.of(lottoWinningNumbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public long getCollectNumberCount(List<Integer> purchasedLotto, List<Integer> winningLotto) {
        return winningLotto.stream()
                .filter(purchasedLotto::contains)
                .count();
    }

    public boolean isContainBonusNumber(List<Integer> purchasedLotto, int bonusNumber) {
        return purchasedLotto.contains(bonusNumber);
    }
}

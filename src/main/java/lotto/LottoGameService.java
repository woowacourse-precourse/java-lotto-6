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
        initLottoRakingMap();
    }

    private void initLottoRakingMap() {
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

    public LottoRank determineWinningRank(List<Integer> purchasedLotto,
                                          List<Integer> winningLotto,
                                          int bonusNumber) {
        return LottoRank.determineRank(getCollectNumberCount(purchasedLotto, winningLotto),
                isContainBonusNumber(purchasedLotto, bonusNumber));
    }

    public void updateWinningCount(LottoRank lottoRank) {
        int currentCount = lottoRakingMap.getOrDefault(lottoRank, 0);
        lottoRakingMap.put(lottoRank, currentCount + 1);
    }

    public double calculateProfitRate(int purchaseAmount, EnumMap<LottoRank, Integer> lottoRakingMap) {
        return (double) lottoRakingMap.keySet().stream()
                .filter(rank -> rank != LottoRank.LAST_PLACE)
                .mapToInt(rank ->
                        rank.getPrizeMoney() * lottoRakingMap.get(rank))
                .sum() / purchaseAmount * 100;
    }

    public EnumMap<LottoRank, Integer> getLottoRakingMap() {
        return lottoRakingMap;
    }
}

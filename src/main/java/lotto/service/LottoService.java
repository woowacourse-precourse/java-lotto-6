package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.utils.RandomNumberGenerator;

import java.util.*;
import java.util.stream.Collectors;

import static lotto.constants.LottoConstants.*;

public class LottoService {

    private final RandomNumberGenerator randomNumberGenerator;
    private final List<Lotto> userLottos = new ArrayList<>();
    private final HashMap<LottoRank, Integer> winningRankCount = new HashMap<>();
    private List<Integer> winningNumbers = new ArrayList<>();
    private long totalPrizeAmount = 0;
    private int bonusNumber;

    public LottoService(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public long getTotalPrizeAmount() {
        return totalPrizeAmount;
    }

    public List<Lotto> purchase (int purchaseQuantity) {
        for (int i = 0; i < purchaseQuantity; i++) {
            List<Integer> lottoNumbers = randomNumberGenerator.uniqueNumbers();
            Lotto lotto = generateLotto(lottoNumbers);
            userLottos.add(lotto);
        }
        return userLottos;
    }

    public void initWinningNumbers(String[] winningNumbers) {
        this.winningNumbers = convertStringArrayToIntegerList(winningNumbers);
    }

    public void initBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public HashMap<LottoRank, Integer> checkLottoResult() {
        for (Lotto lotto : userLottos) {
            int matchingCount = lotto.checkMatchingNumbers(winningNumbers);
            boolean hasBonusNumber = lotto.hasBonusNumber(bonusNumber);

            if (matchingCount >= MIN_MATCHING_COUNT) {
                LottoRank lottoRank = LottoRank.findRank(matchingCount,hasBonusNumber);
                countWinningRank(lottoRank);
            }
        }
        return winningRankCount;
    }

    public double calculateProfitRate() {
        calculateTotalPrizeAmount();
        int  purchaseQuantity = getPurchaseQuantity();
        double profitRate = getProfitRate(purchaseQuantity);
        return calculateRoundedProfitRate(profitRate);
    }

    private Lotto generateLotto(List<Integer> lottoNumbers) {
        List<Integer> sortedAscendingLottoNumbers = sortAscendingOrder(lottoNumbers);
        return new Lotto(sortedAscendingLottoNumbers);
    }

    private List<Integer> sortAscendingOrder(List<Integer> numbers) {
        List<Integer> lottoNumbers = new ArrayList<>(numbers);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    private List<Integer> convertStringArrayToIntegerList(String[] winningNumbers) {
        return Arrays.stream(winningNumbers)
                .mapToInt(Integer::valueOf)
                .boxed()
                .collect(Collectors.toList());
    }

    private void countWinningRank(LottoRank lottoRank) {
        winningRankCount.put(lottoRank, winningRankCount.getOrDefault(lottoRank, 0) + 1);
    }

    private void calculateTotalPrizeAmount() {
        for (LottoRank lottoRank: winningRankCount.keySet()) {
            this.totalPrizeAmount += lottoRank.getPrizeMoney() * winningRankCount.get(lottoRank);
        }
    }

    private int getPurchaseQuantity() {
        return userLottos.size();
    }

    private double getProfitRate(int purchaseQuantity) {
        return ((double) totalPrizeAmount / (purchaseQuantity * LOTTO_PRICE)) * PERCENTAGE;
    }

    /**
     *  수익률을 소수점 둘째 자리에서 반올림하는 메서드
     *  테스트 코드를 위해 접근제어자를 public으로 변경 (직접 호출 X)
     */
    public double calculateRoundedProfitRate(double profitRate) {
        return Math.round(profitRate * ROUNDING_PRECISION) / ROUNDING_PRECISION ;
    }
}

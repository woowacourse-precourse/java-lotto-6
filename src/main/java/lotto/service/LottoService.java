package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;

import java.util.*;
import java.util.stream.Collectors;

import static lotto.constants.LottoConstants.*;

public class LottoService {

    private final List<Lotto> userLottos = new ArrayList<>();
    private List<Integer> winningNumbers = new ArrayList<>();
    private HashMap<LottoRank, Integer> winningRankCount = new HashMap<>();
    private int bonusNumber;

    public List<Lotto> purchase (int purchaseQuantity) {
        for (int i = ZERO; i < purchaseQuantity; i++) {
            List<Integer> lottoNumbers = generateUniqueRandomLottoNumbers();
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
        long totalPrizeAmount = calculateTotalPrizeAmount();
        int  purchaseQuantity = getPurchaseQuantity();
        double profitRate = getProfitRate((double) totalPrizeAmount, purchaseQuantity);
        return calculateRoundedProfitRate(profitRate);
    }

    private List<Integer> generateUniqueRandomLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, LOTTO_NUMBER_COUNT);
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
        winningRankCount.put(lottoRank, winningRankCount.getOrDefault(lottoRank, ZERO) + ONE);
    }

    private long calculateTotalPrizeAmount() {
        long totalPrizeAmount = ZERO;

        for (LottoRank lottoRank: winningRankCount.keySet()) {
            totalPrizeAmount += lottoRank.getPrizeMoney() * winningRankCount.get(lottoRank);
        }
        return totalPrizeAmount;
    }

    private int getPurchaseQuantity() {
        return userLottos.size();
    }

    private double getProfitRate(double totalPrizeAmount, int purchaseQuantity) {
        return (totalPrizeAmount / (purchaseQuantity * LOTTO_PRICE)) * PERCENTAGE;
    }

    /**
     *  수익률을 소수점 둘째 자리에서 반올림하는 메서드
     */
    private double calculateRoundedProfitRate(double profitRate) {
        return Math.round(profitRate * ROUNDING_PRECISION) / ROUNDING_PRECISION ;
    }
}

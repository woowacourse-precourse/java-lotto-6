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
    private int bonusNumber = ZERO;
    private HashMap<LottoRank, Integer> winningRankCount = new HashMap<>();

    public List<Lotto> purchase (int quantity) {
        for (int i = ZERO; i < quantity; i++) {
            List<Integer> lottoNumbers = generateUniqueRandomLottoNumbers();
            Lotto lotto = new Lotto(sortAscendingOrder(lottoNumbers));
            userLottos.add(lotto);
        }
        return userLottos;
    }

    private List<Integer> generateUniqueRandomLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, LOTTO_NUMBER_COUNT);
    }

    public void initWinningNumbers(String[] winningNumbers) {
        this.winningNumbers = Arrays.stream(winningNumbers)
                .mapToInt(Integer::valueOf)
                .boxed()
                .collect(Collectors.toList());
    }

    public void initBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    private List<Integer> sortAscendingOrder(List<Integer> numbers) {
        List<Integer> lottoNumbers = new ArrayList<>(numbers);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    public HashMap<LottoRank, Integer> checkLottoResult() {
        for (Lotto userLotto : userLottos) {
            int matchingCount = userLotto.checkMatchingNumbers(winningNumbers);
            boolean hasBonusNumber = userLotto.hasBonusNumber(bonusNumber);
            if (matchingCount >= MIN_MATCHING_COUNT) {
                LottoRank lottoRank = LottoRank.findRank(matchingCount,hasBonusNumber);
                winningRankCount.put(lottoRank, winningRankCount.getOrDefault(lottoRank, ZERO) + ONE);
            }
        }
        return winningRankCount;
    }

    public double calculateProfitRate() {
        double totalPrizeAmount = ZERO;

        for (LottoRank lottoRank: winningRankCount.keySet()) {
            totalPrizeAmount += lottoRank.getPrizeMoney() * winningRankCount.get(lottoRank);
        }

        int  purchaseQuantity= userLottos.size();
        double profitRate = (totalPrizeAmount / (purchaseQuantity * LOTTO_PRICE)) * PERCENTAGE;
        return calculateRoundedProfitRate(profitRate);
    }

    /**
     *  수익률을 소수점 둘째 자리에서 반올림하는 메서드
     */
    private double calculateRoundedProfitRate(double profitRate) {
        return Math.round(profitRate * ROUNDING_PRECISION) / ROUNDING_PRECISION ;
    }
}

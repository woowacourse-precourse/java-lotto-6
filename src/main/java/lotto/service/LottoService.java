package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;

import java.util.*;
import java.util.stream.Collectors;

public class LottoService {

    private final List<Lotto> userLottos = new ArrayList<>();
    private List<Integer> winningNumbers = new ArrayList<>();
    private int bonusNumber = 0;
    private HashMap<LottoRank, Integer> winningRankCount = new HashMap<>();

    public List<Lotto> purchase (int purchaseQuantity) {
        for (int i = 0; i < purchaseQuantity; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(sortAscendingOrder(lottoNumbers));
            userLottos.add(lotto);
        }
        return userLottos;
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
            if (matchingCount >= 3) {
                LottoRank lottoRank = LottoRank.findRank(matchingCount,hasBonusNumber);
                winningRankCount.put(lottoRank, winningRankCount.getOrDefault(lottoRank, 0) + 1);
            }
        }
        return winningRankCount;
    }

    private double calculateTotalPrizeAmount() {
        double totalPrizeAmount = 0;
        for (LottoRank lottoRank: winningRankCount.keySet()) {
            totalPrizeAmount += lottoRank.getPrizeMoney() * winningRankCount.get(lottoRank);
        }
        return totalPrizeAmount;
    }

    public double getProfitRate() {
        double totalPrizeAmount = 0;
        for (LottoRank lottoRank: winningRankCount.keySet()) {
            totalPrizeAmount += lottoRank.getPrizeMoney() * winningRankCount.get(lottoRank);
        }
        return (totalPrizeAmount / (userLottos.size() * 1000)) * 100;
    }
}

package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import consts.Rank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static consts.Rule.*;

public class LottoService {
    private int purchaseAmount;
    private List<Lotto> lottos;
    private LottoAnswer lottoAnswer;

    private LottoService(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        this.lottos = new ArrayList<>();
    }

    public static LottoService create(int purchaseAmount) {
        return new LottoService(purchaseAmount);
    }

    public void purchaseLotto() {
        for (int i = 0; i < purchaseAmount / LOTTO_PRICE; i++) {
            lottos.add(new Lotto(generateLottoNumbers()));
        }
    }

    private List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_NUMBER_COUNT);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void settingLottoAnswer(List<Integer> winningNumbers, int bonusNumber) {
        lottoAnswer = new LottoAnswer(winningNumbers, bonusNumber);
    }

    public Map<Rank, Integer> makeLottoResult() {
        return lottos.stream()
                .map(lottoAnswer::compareAndReturnRank)
                .collect(Collectors.groupingBy(rank -> rank, Collectors.summingInt(rank -> 1)));
    }

    public double calculateProfitRate(Map<Rank, Integer> ranks) {
        return ranks.entrySet().stream()
                .mapToDouble(rank -> rank.getKey().getWinningMoney() * rank.getValue())
                .sum() / purchaseAmount * 100;
    }
}

package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.TreeMap;

public class LottoPlayer {
    private static final int LOTTO_PRICE = 1000;
    private final int purchaseAmount;
    private final List<Lotto> lottos = new ArrayList<>();
    private final Map<LottoRank, Integer> result = new HashMap<>();


    public LottoPlayer(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;

        for (LottoRank rank : LottoRank.values()) {
            result.put(rank, 0);
        }
    }

    public void buyLottos() {
        int numberOfLottoTickets = purchaseAmount / LOTTO_PRICE;

        for (int i = 0; i < numberOfLottoTickets; i++) {
            Lotto lotto = new Lotto(makeRandomNumbers());
            lottos.add(lotto);
        }
    }

    public List<Integer> makeRandomNumbers() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return randomNumbers.stream()
                .sorted()
                .toList();
    }

    public int getLottoTicketCount() {
        return lottos.size();
    }

    public String getLottoNumbers() {
        StringJoiner lottoNumbers = new StringJoiner("\n");
        for (Lotto lotto : lottos) {
            lottoNumbers.add(lotto.getLottoNumbers());
        }
        return lottoNumbers.toString();
    }

    public void checkLottoResult(List<Integer> winningNumbers, int bonusNumber) {
        for (Lotto lotto : lottos) {
            LottoRank rank = determineLottoRank(lotto, winningNumbers, bonusNumber);

            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
    }

    public LottoRank determineLottoRank(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        int matchCount = lotto.countMatchingNumbers(winningNumbers);
        int bonusMatchCount = lotto.countMatchingBonusNumber(bonusNumber);

        for (LottoRank rank : LottoRank.values()) {
            if (rank.isMatch(matchCount, bonusMatchCount)) {
                return rank;
            }
        }

        return LottoRank.NONE;
    }

    // 수익률 계산
    public double getRateOfReturn() {
        return (double) getReturn() / purchaseAmount * 100;
    }

    public int getReturn() {
        int returnPrice = 0;
        for (LottoRank rank : LottoRank.values()) {
            returnPrice += rank.getPrize() * result.get(rank);
        }
        return returnPrice;
    }

    // 당첨 통계 글자 생성
    public String getLottoResult() {

        StringJoiner lottoResult = new StringJoiner("\n");
        Map<LottoRank, Integer> sortedResult = new TreeMap<>(Collections.reverseOrder());

        sortedResult.putAll(result);

        for (Map.Entry<LottoRank, Integer> entry : sortedResult.entrySet()) {
            LottoRank rank = entry.getKey();
            int count = entry.getValue();

            if (rank != LottoRank.NONE) {
                lottoResult.add(rank.printStatus() + " - " + count + "개");
            }
        }

        return lottoResult.toString();
    }
}

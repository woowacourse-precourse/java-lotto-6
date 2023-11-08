package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.util.Constant;

import java.util.*;

public class LottoService {


    private List<Lotto> lottoTickets;

    public LottoService() {
        this.lottoTickets = new ArrayList<>();
    }

    // Additional constructor
    public LottoService(List<Lotto> lottoTickets) {
        this.lottoTickets = new ArrayList<>(lottoTickets);
    }

    public void generateLottoTickets(int purchaseAmount) {
        int numberOfTickets = calculateTicketAmount(purchaseAmount);

        for (int i = 0; i < numberOfTickets; i++) {
            List<Integer> lottoNumbers = generateSortedLottoNumbers();
            Lotto lotto = new Lotto(lottoNumbers);
            lottoTickets.add(lotto);
        }
    }

    public int calculateTicketAmount(int purchaseAmount) {
        return purchaseAmount / Constant.LOTTO_PRICE;
    }

    private List<Integer> generateSortedLottoNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>(
                Randoms.pickUniqueNumbersInRange(
                        Constant.MIN_LOTTO_NUMBER,
                        Constant.MAX_LOTTO_NUMBER,
                        Constant.LOTTO_NUMBER_COUNT));
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }

    // Setter for lottoTickets (for testcode)
    public void setLottoTickets(List<Lotto> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }


    public Map<Prize, Integer> calculateResults(List<Integer> winningNumbers, int bonusNumber) {
        Map<Prize, Integer> prizeResults = new HashMap<>();

        for (Prize prize : Prize.values()) {
            prizeResults.put(prize, 0);
        }

        for (Lotto lotto : lottoTickets) {
            int matchCount = lotto.countMatches(winningNumbers);
            boolean bonusMatch = lotto.contains(bonusNumber);
            Prize prize = Prize.determinePrize(matchCount, bonusMatch);
            prizeResults.put(prize, prizeResults.get(prize) + 1);
        }

        return prizeResults;
    }

    public int calculateTotalEarnings(Map<Prize, Integer> prizeResults) {
        return prizeResults.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrizeMoney() * entry.getValue())
                .sum();
    }

    public double calculateYield(int purchaseAmount, int totalEarnings) {
        return (double) totalEarnings / purchaseAmount * Constant.HUNDRED_PERCENT;
    }
}

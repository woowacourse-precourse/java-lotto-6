package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class LottoService {

    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_PRICE = 1000;
    private List<Lotto> lottoTickets;

    public LottoService() {
        this.lottoTickets = new ArrayList<>();
    }

    // Additional constructor
    public LottoService(List<Lotto> lottoTickets) {
        this.lottoTickets = new ArrayList<>(lottoTickets);
    }

    public void generateLottoTickets(int purchaseAmount) {
        int numberOfTickets = purchaseAmount / LOTTO_PRICE;

        for (int i = 0; i < numberOfTickets; i++) {
            List<Integer> lottoNumbers = generateSortedLottoNumbers();
            Lotto lotto = new Lotto(lottoNumbers);
            lottoTickets.add(lotto);
        }
    }

    private List<Integer> generateSortedLottoNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>(Randoms
                .pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBER_COUNT));
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
        return (double) totalEarnings / purchaseAmount * 100;
    }
}

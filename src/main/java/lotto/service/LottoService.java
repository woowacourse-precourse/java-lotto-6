package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;

public class LottoService {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int NUMBER_SIZE = 6;
    private static final int LOTTO_PRICE = 1000;

    public List<Lotto> purchaseLottoTickets(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        int numberOfTickets = purchaseAmount / LOTTO_PRICE;

        List<Lotto> tickets = new ArrayList<>();
        for (int i = 0; i < numberOfTickets; i++) {
            tickets.add(new Lotto(generateLottoNumbers()));
        }
        return tickets;
    }

    public Map<LottoRank, Integer> checkWinningResults(List<Lotto> lottoTickets, List<Integer> winningNumbers, int bonusNumber) {
        Map<LottoRank, Integer> results = new HashMap<>();
        for (Lotto ticket : lottoTickets) {
            LottoRank lottoRank = LottoRank.calculateRank(ticket.getNumbers(), winningNumbers, bonusNumber);
            results.put(lottoRank, results.getOrDefault(lottoRank, 0) + 1);
        }
        return results;
    }

    public double calculateProfitRate(Map<LottoRank, Integer> results, int purchasesAmount) {
        int totalPrize = results.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrizeAmount() * entry.getValue())
                .sum();
        double profitRate =  (double) totalPrize / purchasesAmount;

        return Math.round(profitRate*100.0) / 100.0;
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount <= 0 || purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }

    public List<Integer> generateLottoNumbers() {
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        Collections.sort(numbers);
        return numbers;
    }
}

package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.text.DecimalFormat;
import java.util.ArrayList;
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
        int numberOfTickets = purchaseAmount / LOTTO_PRICE;

        List<Lotto> tickets = new ArrayList<>();
        for (int i = 0; i < numberOfTickets; i++) {
            tickets.add(new Lotto(generateLottoNumbers()));
        }
        return tickets;
    }

    public Map<LottoRank, Integer> checkWinningResults(List<Lotto> lottoTickets, List<Integer> winningNumbers,
                                                       int bonusNumber) {
        Map<LottoRank, Integer> results = new HashMap<>();
        for (Lotto ticket : lottoTickets) {
            LottoRank lottoRank = LottoRank.calculateRank(ticket.getNumbers(), winningNumbers, bonusNumber);
            results.merge(lottoRank, 1, Integer::sum);
        }
        return results;
    }

    public String calculateProfitRate(Map<LottoRank, Integer> results, int purchasesAmount) {
        int totalPrize = results.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrizeAmount() * entry.getValue())
                .sum();
        double profitRate = ((double) totalPrize / (purchasesAmount * LOTTO_PRICE)) * 100;
        DecimalFormat df = new DecimalFormat("0.0");

        return df.format(profitRate) + "%";
    }

    public List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, NUMBER_SIZE);
    }

}

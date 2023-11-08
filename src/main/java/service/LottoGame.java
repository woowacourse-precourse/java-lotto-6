package service;

import domain.Buyer;
import domain.Lotto;
import domain.LottoMachine;
import domain.Ranking;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import utils.Utils;

public class LottoGame {
    private static final int LOTTO_MIN_VALUE = 1;
    private static final int LOTTO_MAX_VALUE = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int LOTTO_PRICE = 1_000;
    private static final int COUNT_ONE = 1;
    private static final int COUNT_ZERO = 0;
    private static final int COUNT_PLUS_ONE = 1;
    private static final int SAME_NUMBER_COUNT_THREE = 3;
    private static final int SAME_NUMBER_COUNT_FOUR = 4;
    private static final int SAME_NUMBER_COUNT_FIVE = 5;
    private static final int SAME_NUMBER_COUNT_SIX = 6;
    private static final int PERCENTAGE = 100;

    public List<Lotto> generateLottoTickets(int spend) {
        List<Lotto> lottoTickets = new ArrayList<>();
        int purchasedLottoCount = calculatePurchasedLottoCount(spend);
        for (int count = COUNT_ONE; count <= purchasedLottoCount; count++) {
            lottoTickets.add(generateLottoNumbers());
        }
        return lottoTickets;
    }

    private int calculatePurchasedLottoCount(int spend) {
        return spend / LOTTO_PRICE;
    }

    private Lotto generateLottoNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>(
                Utils.generateRandomUniqueNumbers(LOTTO_MIN_VALUE, LOTTO_MAX_VALUE, LOTTO_NUMBER_COUNT));
        Collections.sort(lottoNumbers);
        return new Lotto(lottoNumbers);
    }

    public Map<Ranking, Integer> checkYourLottoNumbers(LottoMachine lottoMachine, Buyer buyer) {
        Map<Ranking, Integer> lottoResult = new HashMap<>();
        for (Lotto lottoTicket : lottoMachine.getLottoTickets()) {
            int sameWinningNumberCount = countSameWinningNumbers(lottoTicket, buyer);
            boolean isSameBonusNumber = isSameBonusNumber(lottoTicket, buyer);
            updateResult(sameWinningNumberCount, isSameBonusNumber, lottoResult);
        }
        return lottoResult;
    }

    private int countSameWinningNumbers(Lotto lottoTicket, Buyer buyer) {
        return (int) lottoTicket.getNumbers()
                                .stream()
                                .filter(buyer.getWinningNumbers()::contains)
                                .count();
    }

    private boolean isSameBonusNumber(Lotto lottoTicket, Buyer buyer) {
        return lottoTicket.getNumbers()
                          .contains(buyer.getBonusNumber());
    }

    private void updateResult(int sameWinningNumberCount, boolean isSameBonusNumber,
                              Map<Ranking, Integer> lottoResult) {
        if (sameWinningNumberCount == SAME_NUMBER_COUNT_THREE && !isSameBonusNumber) {
            lottoResult.put(Ranking.FIFTH, lottoResult.getOrDefault(Ranking.FIFTH, COUNT_ZERO) + COUNT_PLUS_ONE);
        }
        if (sameWinningNumberCount == SAME_NUMBER_COUNT_FOUR && !isSameBonusNumber) {
            lottoResult.put(Ranking.FOURTH, lottoResult.getOrDefault(Ranking.FOURTH, COUNT_ZERO) + COUNT_PLUS_ONE);
        }
        if (sameWinningNumberCount == SAME_NUMBER_COUNT_FIVE && !isSameBonusNumber) {
            lottoResult.put(Ranking.THIRD, lottoResult.getOrDefault(Ranking.THIRD, COUNT_ZERO) + COUNT_PLUS_ONE);
        }
        if (sameWinningNumberCount == SAME_NUMBER_COUNT_FIVE && isSameBonusNumber) {
            lottoResult.put(Ranking.SECOND, lottoResult.getOrDefault(Ranking.SECOND, COUNT_ZERO) + COUNT_PLUS_ONE);
        }
        if (sameWinningNumberCount == SAME_NUMBER_COUNT_SIX && !isSameBonusNumber) {
            lottoResult.put(Ranking.FIRST, lottoResult.getOrDefault(Ranking.FIRST, COUNT_ZERO) + COUNT_PLUS_ONE);
        }
    }

    public double calculateEarningsRate(Map<Ranking, Integer> lottoResult, LottoMachine lottoMachine) {
        long totalPrize = lottoResult.entrySet()
                                     .stream()
                                     .mapToLong(entry -> entry.getKey()
                                                              .getPrize() * entry.getValue())
                                     .sum();

        double earningsRate = (double) (totalPrize * PERCENTAGE) / lottoMachine.getSpend();
        return earningsRate;
    }
}
package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.PurchasePrice;
import lotto.domain.RankInfo;
import lotto.domain.WinningNumbers;
import lotto.dto.LottoGameResult;
import lotto.dto.PurchaseResult;
import lotto.dto.YieldResult;
import lotto.util.RandomNumbersGenerator;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoService {

    private static final LottoService instance = new LottoService();

    public static LottoService getInstance() {
        return instance;
    }

    private LottoService() {
    }

    public List<PurchaseResult> purchaseLottos(PurchasePrice money) {
        List<Lotto> generateLotto = generateLottoTickets(money.getPurchaseLottoAmount());

        return generateLotto.stream()
                .map(lotto -> new PurchaseResult(lotto.getNumbers()))
                .collect(Collectors.toList());
    }

    private List<Lotto> generateLottoTickets(int purchaseLottoAmount) {
        return Stream.generate(() -> Lotto.of(RandomNumbersGenerator.generate()))
                .limit(purchaseLottoAmount)
                .toList();
    }

    public LottoGameResult calcRank(List<Lotto> lottoTickets, WinningNumbers winningNumbers) {
        HashMap<RankInfo, Integer> gameResult = calculateGameResults(lottoTickets, winningNumbers);

        return new LottoGameResult(gameResult);
    }

    private HashMap<RankInfo, Integer> calculateGameResults(List<Lotto> lottoTickets, WinningNumbers winningNumbers) {
        HashMap<RankInfo, Integer> gameResult = new HashMap<>();

        for (Lotto lottoTicket : lottoTickets) {
            RankInfo rankInfo = winningNumbers.compareTo(lottoTicket);
            gameResult.put(rankInfo, gameResult.getOrDefault(rankInfo, 0) + 1);
        }
        return gameResult;
    }

    public YieldResult calcYield(PurchasePrice money, LottoGameResult lottoGameResult) {
        HashMap<RankInfo, Integer> rankCounts = lottoGameResult.gameResult();
        long totalWinningPrizes = calculateTotalWinningPrizes(rankCounts);
        double yieldOfGame = money.calcYieldBy(totalWinningPrizes);

        return new YieldResult(yieldOfGame);
    }

    private long calculateTotalWinningPrizes(HashMap<RankInfo, Integer> rankCounts) {
        return rankCounts.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrizeMoney() * entry.getValue())
                .sum();
    }
}

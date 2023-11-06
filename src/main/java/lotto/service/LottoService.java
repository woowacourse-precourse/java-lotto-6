package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.RankInfo;
import lotto.domain.WinningNumbers;
import lotto.dto.LottoGameResult;
import lotto.dto.PurchaseResult;
import lotto.dto.YieldResult;
import lotto.util.RandomNumbersGenerator;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoService {

    private static final LottoService instance = new LottoService();

    public static LottoService getInstance() {
        return instance;
    }

    private LottoService() {
    }

    public List<PurchaseResult> purchaseLottos(int purchaseLottoAmount) {
        return Stream.generate(() -> new PurchaseResult(RandomNumbersGenerator.generate()))
                .limit(purchaseLottoAmount)
                .collect(Collectors.toList());
    }

    public LottoGameResult calcRank(List<Lotto> lottoTickets, WinningNumbers winningNumbers) {
        HashMap<RankInfo, Integer> gameResult = new HashMap<>();

        for (Lotto lottoTicket : lottoTickets) {
            RankInfo rankInfo = winningNumbers.compareTo(lottoTicket);
            gameResult.put(rankInfo, gameResult.getOrDefault(rankInfo, 0) + 1);
        }

        return new LottoGameResult(gameResult);
    }

    public YieldResult calcYield(int purchaseLottoAmount, LottoGameResult lottoGameResult) {
        long totalWinningPrize = 0L;
        for (RankInfo rankInfo : lottoGameResult.gameResult().keySet()) {
            Integer countOfWinners = lottoGameResult.gameResult().get(rankInfo);
            totalWinningPrize += rankInfo.getPrizeMoney() * countOfWinners;
        }

        double yield = (double) totalWinningPrize / (purchaseLottoAmount * 1000) * 100;
        return new YieldResult(yield);
    }
}

package lotto.service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.LottoGame;
import lotto.domain.Lottos;
import lotto.domain.RankPrize;
import lotto.domain.RankResult;
import lotto.dto.BonusNumberDto;
import lotto.dto.LottosDto;
import lotto.dto.PurchaseAmountDto;
import lotto.dto.RankPrizeDto;
import lotto.dto.RankResultDto;
import lotto.dto.WinningNumbersDto;

public class LottoGameService {
    private final LottoGame lottoGame;

    public LottoGameService(LottoGame lottoGame) {
        this.lottoGame = lottoGame;
    }

    public LottosDto purchaseLottos(PurchaseAmountDto purchaseAmount) {
        lottoGame.initializePurchaseAmount(purchaseAmount.purchaseAmount());
        lottoGame.purchaseLottos();
        Lottos purchasedLottos = lottoGame.getPurchasedLottos();
        return LottosDto.from(purchasedLottos);
    }

    public void determineWinningNumbers(WinningNumbersDto winningNumbersDto) {
        lottoGame.determineWinningNumbers(winningNumbersDto.winningNumbers());
    }

    public void determineBonusNumber(BonusNumberDto bonusNumber) {
        lottoGame.determineBonusNumber(bonusNumber.bonusNumber());
    }

    public RankResultDto calculateRank() {
        RankResult rankResult = lottoGame.calculateRank();
        int purchaseAmount = lottoGame.getPurchaseAmount();
        Map<RankPrizeDto, Integer> rank = getRank(rankResult.getRankResult());
        return new RankResultDto(rank, rankResult.calculateReturn(purchaseAmount));
    }

    private static Map<RankPrizeDto, Integer> getRank(Map<RankPrize, Integer> rankResult) {
        return rankResult.entrySet().stream()
                .collect(Collectors.toMap(
                        entry -> new RankPrizeDto(entry.getKey().getRankMessage(),
                                entry.getKey().getMatchCounts(),
                                entry.getKey().getPrizeAmount()),
                        Map.Entry::getValue, (a, b) -> b, LinkedHashMap::new
                ));
    }
}

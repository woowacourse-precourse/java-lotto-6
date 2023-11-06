package lotto.application;

import lotto.domain.Lotto;
import lotto.domain.repository.LottoRepository;
import lotto.domain.exception.LottoException;
import lotto.global.exception.GlobalError;
import lotto.global.exception.GlobalException;
import lotto.global.constant.enums.MatchResultType;

import java.util.*;

public class LottoGame {
    private static final int LOTTO_PRICE = 1_000;
    private final LottoRepository lottoRepository;

    private Lotto winningLotto;
    private int winningBonus;

    private Map<MatchResultType, Long> resultBoard;

    private LottoGame(List<Lotto> purchasedLottos) {
        initBoard();
        this.lottoRepository = LottoRepository.createRepository(purchasedLottos);
    }

    public static LottoGame createLottoGame(long paymentAmount) {
        long quantity = calculateLottoQuantity(paymentAmount);

        List<Lotto> lottos = new ArrayList<>();
        for (long purchase = 0; purchase < quantity; purchase++) {
            lottos.add(LottoMachine.issueAutomaticLotto());
        }
        return new LottoGame(lottos);
    }

    private static long calculateLottoQuantity(long paymentAmount) {
        return paymentAmount / LOTTO_PRICE;
    }

    public void registerWinningNumbers(List<Integer> winningNumbers) throws LottoException{
        this.winningLotto = LottoMachine.issueManualLotto(winningNumbers);
    }

    public void registerWinningBonus(int winningBonus) {
        if (winningLotto.isExist(winningBonus)) {
            throw new GlobalException(GlobalError.ALREADY_EXIST_IN_WINNING_NUMBERS);
        }
        this.winningBonus = winningBonus;
    }

    public LottoGameInfo.PurchaseStatus checkPurchaseStatus() {
        return new LottoGameInfo.PurchaseStatus(
                lottoRepository.count(),
                lottoRepository.lottos()
        );
    }

    public LottoGameInfo.MatchResult checkMatchResult() throws GlobalException{
        if (lottoRepository.lottos().isEmpty()) {
            throw new GlobalException(GlobalError.NOT_PAID_YET);
        }
        matchWinning();
        return new LottoGameInfo.MatchResult(
                resultBoard
        );
    }
    public LottoGameInfo.RevenueInfo checkRevenue() {
        long totalReward = 0L;
        for (Map.Entry<MatchResultType, Long> eachResult: resultBoard.entrySet()) {
            MatchResultType matchType = eachResult.getKey();
            totalReward += matchType.calculateReward(eachResult.getValue());
        }
        return new LottoGameInfo.RevenueInfo(
                lottoRepository.count() * LOTTO_PRICE,
                totalReward
        );
    }

    private void matchWinning() {
        initBoard();
        for (Lotto lotto : lottoRepository.lottos()) {
            MatchResultType matchType = LottoMachine.match(lotto, winningLotto, winningBonus);
            if (!matchType.equals(MatchResultType.BOOM)) {
                Long currentPoint = resultBoard.get(matchType);
                resultBoard.put(matchType, currentPoint + 1);
            }
        }
    }

    private void initBoard() {
        Map<MatchResultType, Long> board = Map.of(
                MatchResultType.MATCH_THREE, 0L,
                MatchResultType.MATCH_FOUR, 0L,
                MatchResultType.MATCH_FIVE, 0L,
                MatchResultType.MATCH_FIVE_WITH_BONUS, 0L,
                MatchResultType.MATCH_SIX, 0L
        );
        this.resultBoard = new HashMap<>(board);
    }
}

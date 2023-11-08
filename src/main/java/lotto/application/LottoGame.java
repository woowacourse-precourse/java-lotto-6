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
    private Integer winningBonus;

    private Map<MatchResultType, Long> resultBoard;

    /**
     * <p>
     *     사용자가 입력한 구매 금액에 따라 자동으로 로또를 발행한 후, 발행된 로또들을 본 게임 로또 저장소에 저장합니다.
     * </p>
     *
     * @param purchasedLottos 본 게임에 대해 자동 발행된 로또들을 입력 받습니다.
     * @see LottoRepository
     */
    private LottoGame(List<Lotto> purchasedLottos) {
        initBoard();
        this.lottoRepository = LottoRepository.createRepository(purchasedLottos);
    }

    /**
     * 본 게임을 생성합니다.
     *
     * @param paymentAmount 사용자 로또 구매 금액
     * @return 입력 금액 기반으로 생성된 LottoGame 객체를 외부로 반환합니다.
     */
    public static LottoGame createLottoGame(long paymentAmount) {
        long quantity = calculateLottoQuantity(paymentAmount);

        List<Lotto> lottos = new ArrayList<>();
        // 로또들을 통해 본 게임 객체를 생성합니다.
        for (long purchase = 0; purchase < quantity; purchase++) {
            lottos.add(LottoMachine.issueAutomaticLotto());
        }
        return new LottoGame(lottos);
    }

    private static long calculateLottoQuantity(long paymentAmount) {
        return paymentAmount / LOTTO_PRICE;
    }

    /** 본 게임의 당첨 번호를 등록합니다. */
    public void registerWinningNumbers(List<Integer> winningNumbers) throws LottoException{
        this.winningLotto = LottoMachine.issueManualLotto(winningNumbers);
    }

    /** 본 게임의 보너스 번호를 등록합니다. */
    public void registerWinningBonus(int winningBonus) {
        if (winningLotto.isExist(winningBonus)) {
            throw new GlobalException(GlobalError.ALREADY_EXIST_IN_WINNING_NUMBERS);
        }
        this.winningBonus = winningBonus;
    }

    /**
     * 구매 현황에 대해 반환 합니다.
     * @return 구매 금액에 따라 자동 발행된 로또 정보를 반환합니다.
     * @see LottoGameInfo.PurchaseStatus
     */
    public LottoGameInfo.PurchaseStatus checkPurchaseStatus() {
        return new LottoGameInfo.PurchaseStatus(
                lottoRepository.count(),
                lottoRepository.lottos()
        );
    }

    /**
     * <p>
     *     당첨 번호 혹은 보너스 번호가 입력되기 전에 본 메서드를 호출할 경우,<br/>
     *     그에 상응하는 에러를 발생시킵니다.
     * </p>
     * @return 본 로또 게임의 통계 결과를 반환합니다.
     * @see LottoGameInfo.MatchResult
     * @exception  GlobalException : Lotto 도메인의 에러가 아닌 전체적인 LottoGame 규모의 에러
     * @see GlobalError#NOT_REGISTER_WINNING_YET
     * @see GlobalError#NOT_REGISTER_BONUS_YET
     */
    public LottoGameInfo.MatchResult checkMatchResult() throws GlobalException {
        if (Objects.isNull(winningLotto)) {
            throw new GlobalException(GlobalError.NOT_REGISTER_WINNING_YET);
        }
        if (Objects.isNull(winningBonus)) {
            throw new GlobalException(GlobalError.NOT_REGISTER_BONUS_YET);
        }
        matchWinning();
        return new LottoGameInfo.MatchResult(
                resultBoard
        );
    }

    /**
     * 수익률 관련 정보를 반환합니다.
     * @return 본 계임의 수익률 계산에 필요한 정보들을 반환합니다.
     * @see LottoGameInfo.RevenueInfo
     */
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
        // 이전에 수행되었을 수도 있는 당첨 통계 결과를 중복 연산을 방지하고 초기화합니다.
        initBoard();
        for (Lotto lotto : lottoRepository.lottos()) {
            MatchResultType matchType = LottoMachine.match(lotto, winningLotto, winningBonus);
            if (!matchType.equals(MatchResultType.BOOM)) {
                Long currentPoint = resultBoard.get(matchType);
                resultBoard.put(matchType, currentPoint + 1);
            }
        }
    }

    /** 본 게임의 점수판을 초기화합니다. */
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

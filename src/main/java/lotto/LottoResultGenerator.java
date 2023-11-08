package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResultGenerator {

    public static final Long RANK_DEFAULT_VALUE = 0L;

    public static LottoResultGenerator getInstance() {
        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        public static final LottoResultGenerator INSTANCE = new LottoResultGenerator();
    }

    public LottoResultBoard generateLottoResultBoard(
            final LottoTickets lottoTickets,
            final WinningLotto winningLotto
    ) {
        List<LottoRank> lottoResult = match(lottoTickets, winningLotto);
        Map<LottoRank, Long> lottoResultBoard = updateTotalLottoResultOnBoard(lottoResult);
        return LottoResultBoard.of(lottoResultBoard);
    }

    private List<LottoRank> match(LottoTickets lottoTickets, WinningLotto winningLotto) {
        return lottoTickets.match(winningLotto);
    }

    private Map<LottoRank, Long> updateTotalLottoResultOnBoard(List<LottoRank> lottoRanks) {
        Map<LottoRank, Long> lottoResultBoard = initBoard();
        lottoRanks.forEach(lottoRank -> updateLottoResultOnBoard(lottoResultBoard, lottoRank));
        return lottoResultBoard;
    }

    private void updateLottoResultOnBoard(Map<LottoRank, Long> lottoRankBoard, LottoRank lottoRank) {
        long currentLottoRankCount = lottoRankBoard.get(lottoRank);
        lottoRankBoard.put(lottoRank, currentLottoRankCount + 1);
    }

    private Map<LottoRank, Long> initBoard() {
        return Arrays.stream(LottoRank.values())
                .collect(Collectors.toMap(key -> key, key -> RANK_DEFAULT_VALUE));
    }
}

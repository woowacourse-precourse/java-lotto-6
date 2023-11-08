package lotto.service.manager;

import lotto.domain.entity.Lotto;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RankBoard {

    private final Map<Rank, Count> board;
    private long totalPrize;

    public RankBoard() {
        this.totalPrize = 0L;
        this.board = new LinkedHashMap<>(Lotto.COUNT);

        for (Rank rank : Rank.values()) {
            board.put(rank, new Count());
        }
    }

    public void note(final List<Rank> ranks) {
        ranks.forEach(this::plusCount);
    }

    private void plusCount(Rank rank) {
        board.get(rank).plus();
        this.totalPrize += rank.getPrize();
    }

    /**
     * 읽기 전용 결과 보드 반환 메서드
     * @return unmodifiable LinkHashMap
     */
    public Map<Rank, Long> getResultBoard() {
        Map<Rank, Long> resultBoard = new LinkedHashMap<>(Lotto.COUNT);
        board.keySet()
                .forEach(r ->
                        putCountTo(resultBoard, r)
                );
        return Collections.unmodifiableMap(resultBoard);
    }

    private void putCountTo(Map<Rank, Long> resultBoard, Rank rank) {
        long count = getCount(rank);
        resultBoard.put(rank, count);
    }

    public long getTotalPrize() {
        return totalPrize;
    }

    private long getCount(Rank rank) {
        return board.get(rank).getCount();
    }
}

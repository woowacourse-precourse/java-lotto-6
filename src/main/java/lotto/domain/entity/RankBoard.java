package lotto.domain.entity;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RankBoard {

    private final Map<Rank, Count> board;

    public RankBoard() {
        this.board = new LinkedHashMap<>(LottoGenerator.COUNT);

        for (Rank rank : Rank.values()) {
            board.put(rank, new Count());
        }
    }

    public void note(final List<Rank> ranks) {
        ranks.forEach(this::plusCount);
    }

    private void plusCount(Rank rank) {
        board.get(rank).plus();
    }

    /**
     * 읽기 전용 결과 보드 반환 메서드
     * @return unmodifiable LinkHashMap
     */
    public Map<Rank, Long> getResultBoard() {
        Map<Rank, Long> resultBoard = new LinkedHashMap<>(LottoGenerator.COUNT);
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
        return board.keySet()
                .stream()
                .mapToLong(this::calculatePrizePer)
                .sum();
    }

    private long calculatePrizePer(Rank rank) {
        return rank.getPrize() * getCount(rank);
    }

    private long getCount(Rank rank) {
        return board.get(rank).getCount();
    }
}

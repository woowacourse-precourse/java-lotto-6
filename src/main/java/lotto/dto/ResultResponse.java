package lotto.dto;

import lotto.utils.Rank;

public record ResultResponse(Rank rank, int count) {
    private static final String BASIC_RESULT_FORMAT = "%d개 일치 (%,d원) - %d개\n";
    private static final String SECOND_RESULT_FORMAT = "%d개 일치 (%,d원) - %d개\n";

    @Override
    public String toString() {
        if (rank == Rank.SECOND) {
            return String.format(SECOND_RESULT_FORMAT, rank.getMatchCount(), rank.getPrize(), count);
        }
        return String.format(BASIC_RESULT_FORMAT, rank.getMatchCount(), rank.getPrize(), count);
    }
}

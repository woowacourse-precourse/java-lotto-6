package lotto.domain;

import static lotto.config.WiningRank.NOTHING;
import static lotto.config.WiningRank.RANK1;
import static lotto.config.WiningRank.RANK2;
import static lotto.config.WiningRank.RANK3;
import static lotto.config.WiningRank.RANK4;
import static lotto.config.WiningRank.RANK5;

import lotto.config.WiningRank;

public class RankBoard {
    private int rank1Count = 0;
    private int rank2Count = 0;
    private int rank3Count = 0;
    private int rank4Count = 0;
    private int rank5Count = 0;

    public RankBoard() {}

    public RankBoard(int rank1Count, int rank2Count, int rank3Count, int rank4Count, int rank5Count) {
        this.rank1Count = rank1Count;
        this.rank2Count = rank2Count;
        this.rank3Count = rank3Count;
        this.rank4Count = rank4Count;
        this.rank5Count = rank5Count;
    }

    public int getRankCount(WiningRank rank) {
        if(rank == RANK1) {
            return rank1Count;
        }
        if(rank == RANK2) {
            return rank2Count;
        }
        if(rank == RANK3) {
            return rank3Count;
        }
        if(rank == RANK4) {
            return rank4Count;
        }
        if(rank == RANK5) {
            return rank5Count;
        }
        return 0;
    }

    public void setRankCount(WiningRank rank) {
        if(rank == RANK1) {
            rank1Count++;
        }
        if(rank == RANK2) {
            rank2Count++;
        }
        if(rank == RANK3) {
            rank3Count++;
        }
        if(rank == RANK4) {
            rank4Count++;
        }
        if(rank == RANK5) {
            rank5Count++;
        }
    }
}

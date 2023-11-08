package lotto.domain;

import lotto.rank.domain.Rank;
import org.junit.jupiter.api.Test;

class RankTest {

    @Test
    void rank_First(){
        Rank rank = Rank.valueOf(6, true);
        System.out.println(rank);
    }
    @Test
    void rank_Second(){
        Rank rank = Rank.valueOf(5, true);
        System.out.println(rank);
    }
    @Test
    void rank_Third(){
        Rank rank = Rank.valueOf(5, false);
        System.out.println(rank);
    }
    @Test
    void rank_Fourth(){
        Rank rank = Rank.valueOf(4, true);
        System.out.println(rank);
    }
    @Test
    void rank_Fifth(){
        Rank rank = Rank.valueOf(3, true);
        System.out.println(rank);
    }
}
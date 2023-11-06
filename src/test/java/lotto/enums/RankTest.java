package lotto.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RankTest {

    @DisplayName("매칭 실험1")
    @Test
    void match1() {
        Rank[] ranks = Rank.values();
        List<Rank> newRanks = new ArrayList<>();
        for (Rank rank : ranks) {
            if (rank.getMatchedCount() == 5) {
                newRanks.add(rank);
            }
        }
        assertThat(newRanks.size()).isEqualTo(2);
        List<Rank> newRanks2 = new ArrayList<>();

        for (Rank rank : newRanks) {
            if (rank.containsBonus()) {
                newRanks2.add(rank);
            }
        }

        assertThat(newRanks2.get(0)).isEqualTo(Rank.SECOND);
    }

    @DisplayName("매칭 실험2")
    @Test
    void match2() {
        Rank[] ranks = Rank.values();
        List<Rank> newRanks = new ArrayList<>();
        for (Rank rank : ranks) {
            if (rank.getMatchedCount() == 5) {
                newRanks.add(rank);
            }
        }

        assertThat(newRanks.size()).isEqualTo(2);
        List<Rank> newRanks2 = new ArrayList<>();

        for (Rank rank : newRanks) {
            if (!rank.containsBonus()) {
                newRanks2.add(rank);
            }
        }

        assertThat(newRanks2.get(0)).isEqualTo(Rank.THIRD);
    }

    @DisplayName("매칭 실험3")
    @Test
    void match3() {
        Rank[] ranks = Rank.values();
        List<Rank> newRanks = new ArrayList<>();
        for (Rank rank : ranks) {
            if (rank.getMatchedCount() == 3) {
                newRanks.add(rank);
            }
        }
        assertThat(newRanks.size()).isEqualTo(1);
        List<Rank> newRanks2 = new ArrayList<>();
        for (Rank rank : newRanks) {
            if (!rank.containsBonus()) {
                newRanks2.add(rank);
            }
        }
        assertThat(newRanks2.get(0)).isEqualTo(Rank.FIFTH);
    }

    @DisplayName("순서 반대 실험")
    @Test
    void valuesByReverseOrder() {
        Rank[] original = Rank.values();
        Rank[] reversed = new Rank[original.length];

        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }

        assertThat(Arrays.stream(reversed).map(rank -> rank.name())).containsExactly("FIFTH", "FOURTH", "THIRD", "SECOND", "FIRST");


        assertThat(Arrays.stream(original).sorted(Comparator.reverseOrder()).map(rank -> rank.name())).containsExactly("FIFTH", "FOURTH", "THIRD", "SECOND", "FIRST");
    }
}
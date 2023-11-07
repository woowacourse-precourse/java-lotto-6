package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {
    private static final List<Lotto> LOTTOS = List.of(
            new Lotto(List.of(8, 21, 23, 41, 42, 43)),
            new Lotto(List.of(3, 5, 11, 16, 32, 38)),
            new Lotto(List.of(7, 11, 16, 35, 36, 44)),
            new Lotto(List.of(1, 8, 11, 31, 41, 42)),
            new Lotto(List.of(13, 14, 16, 38, 42, 45)),
            new Lotto(List.of(7, 11, 30, 40, 42, 43)),
            new Lotto(List.of(2, 13, 22, 32, 38, 45)),
            new Lotto(List.of(1, 3, 5, 14, 22, 45))
    );
    Lottos lottos;

    @BeforeEach
    void setUp() {
        lottos = new Lottos(LOTTOS);
    }

    @Test
    void getSize() {
        assertThat(lottos.getSize()).isEqualTo(LOTTOS.size());
    }

    @Test
    void iterator() {
        List<Lotto> result = new ArrayList<>();

        Iterator<Lotto> iterator = lottos.iterator();
        while (iterator.hasNext()) {
            result.add(iterator.next());
        }

        assertThat(result).isEqualTo(LOTTOS);
    }
}
package lotto.domain.lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class LottoTest {
    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto(List.of(6, 5, 4, 3, 2, 1));
    }

    @DisplayName("로또를 오른 차순으로 정리")
    @Test
    void organizeLotto() {
        // when
        List<Integer> result = lotto.organizeNumbers();
        System.out.println("result = " + result);

        // than
        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    void showInformation() {
        // when
        StringBuilder result = lotto.giveInformation();

        // than
        assertThat(result).contains("[1, 2, 3, 4, 5, 6]");
    }
}
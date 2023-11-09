package lotto.domain.lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @DisplayName("로또의 정보를 확인한다.")
    @Test
    public void giveInformation() throws Exception {
        // given
        lotto = new Lotto(List.of(6, 5, 4, 3, 2, 1));

        // when
        StringBuilder result = lotto.giveInformation();

        // then
        assertThat(result).contains("[1, 2, 3, 4, 5, 6]");
    }

    @DisplayName("로또의 정보를 확인한다_2")
    @Test
    public void giveInformation_2() throws Exception {
        // given
        lotto = new Lotto(List.of(20, 30, 10, 40, 25, 35));

        // when
        StringBuilder result = lotto.giveInformation();

        // then
        assertThat(result).contains("[10, 20, 25, 30, 35, 40]");
    }

    @Test
    void showInformation() {
        // when
        StringBuilder result = lotto.giveInformation();

        // than
        assertThat(result).contains("[1, 2, 3, 4, 5, 6]");
    }
}
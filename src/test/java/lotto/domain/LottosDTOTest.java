package lotto.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottosDTOTest {

    private static Lottos lottos;

    @BeforeAll
    static void setUp() {
        Lotto one = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto two = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto three = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        lottos = new Lottos(List.of(one, two, three));
    }

    @Test
    @DisplayName("LottosDTO가 모든 로또들을 List로 반환한다.")
    void Lottos_DTO_테스트() {
        //given
        List<List<Integer>> expected = List.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 6)
        );
        //when
        LottosDTO lottosDTO = lottos.toLottosDTO();

        //then
        Assertions.assertThat(lottosDTO.getLottos()).isEqualTo(expected);
    }
}

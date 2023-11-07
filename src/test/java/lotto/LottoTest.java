package lotto;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능

    //컨벤션상 위에 있어야 하지만, 윗 부분을 변경하지 않기 위해 작성하였음.

    Lotto target = new Lotto(List.of(1, 2, 3, 4, 5, 6));

    @DisplayName("로또 번호의 개수가 6개 보다 작아도 예외가 발생한다.")
    @Test
    void createLottoByUnderSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Lotto(List.of()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("1등은 모든 숫자가 맞아야 한다. 순서는 상관 없다.")
    void 등수확인_1등() {
        //given
        Lotto lotto = new Lotto(List.of(6, 5, 4, 3, 2, 1));
        int bonus = 7;

        //when
        Rank rank = lotto.match(target, bonus);

        //then
        assertThat(rank).isEqualTo(Rank.FIRST);
    }

    @Test
    @DisplayName("2등은 5개의 숫자와 보너스 숫자가 맞아야한다.")
    void 등수확인_2등() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        int bonus = 7;

        //when
        Rank rank = lotto.match(target, bonus);

        //then
        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @Test
    @DisplayName("3등은 5개의 숫자가 맞아야한다. 보너스는 틀려야한다.")
    void 등수확인_3등() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 10));
        int bonus = 7;

        //when
        Rank rank = lotto.match(target, bonus);

        //then
        assertThat(rank).isEqualTo(Rank.THIRD);
    }

    @Test
    @DisplayName("4등은 4개의 숫자가 맞아야한다. 보너스는 무시한다.")
    void 등수확인_4등() {
        //given
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 12, 13));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 7, 11));
        int bonus = 7;

        //when
        Rank rank1 = lotto1.match(target, bonus);
        Rank rank2 = lotto2.match(target, bonus);

        //then
        assertThat(rank1).isEqualTo(Rank.FORTH);
        assertThat(rank2).isEqualTo(Rank.FORTH);
    }

    @Test
    @DisplayName("5등은 3개의 숫자가 맞아야한다. 보너스는 무시한다.")
    void 등수확인_5등() {
        //given
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 11, 12, 13));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 7, 11, 12));
        int bonus = 7;

        //when
        Rank rank1 = lotto1.match(target, bonus);
        Rank rank2 = lotto2.match(target, bonus);

        //then
        assertThat(rank1).isEqualTo(Rank.FIFTH);
        assertThat(rank2).isEqualTo(Rank.FIFTH);
    }

    @ParameterizedTest
    @MethodSource("failSource")
    @DisplayName("0~2개는 FAIL에 매치된다. 보너스는 무시된다.")
    void 등수확인_무효(List<Integer> list) {
        //given
        Lotto lotto = new Lotto(list);
        int bonus = 7;

        //when
        Rank rank = lotto.match(target, bonus);

        //then
        assertThat(rank).isEqualTo(Rank.FAIL);
    }

    private static Stream<List<Integer>> failSource() {
        return Stream.of(
                List.of(1, 2, 14, 11, 12, 13),
                List.of(1, 2, 7, 14, 11, 12),
                List.of(1, 25, 7, 14, 11, 12),
                List.of(33, 25, 7, 14, 11, 12));
    }
}
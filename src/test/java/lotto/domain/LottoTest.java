package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    private Lotto lotto;
    private static final int COUNT = 5;
    private static final int BONUS = 6;
    private static final int MONEY = 3000;

    @BeforeEach
    void setUp() {
        lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    void 로또_번호_비교() {
        int compare = lotto.compare(List.of(1, 2, 3, 4, 5, 45));
        assertThat(compare).isEqualTo(COUNT);
    }

    @Test
    void 로또_번호_비교_결과() {
        Rank rank = lotto.compareResult(COUNT, BONUS);
        assertThat(rank).isEqualTo(Rank.SECOND_PLACE);
    }

    @Test
    void 로또_전체_비교_결과() {
        List<Integer> result = lotto.allCompare(List.of(List.of(1, 2, 3, 4, 5, 45), List.of(1, 2, 3, 4, 5, 6)),
                BONUS);
        assertThat(result).isEqualTo(List.of(1, 1, 0, 0, 0, 0));
    }

    @Test
    void 수익률_계산() {
        String profit = Lotto.profitCalc(List.of(0, 0, 1, 0, 0, 0), MONEY);
        assertThat(profit).isEqualTo("50000.0");
    }
}
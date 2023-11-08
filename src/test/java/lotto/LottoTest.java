package lotto;

import lotto.domain.Lotto;
import lotto.util.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    @Test
    void 로또_당첨_등수_확인_1등(){
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));

        assertThat(lotto.getLottoRank(List.of(1,2,3,4,5,6),7))
                .isEqualTo(LottoRank.FIRST_PRIZE);
    }
    @Test
    void 로또_당첨_등수_확인_2등(){
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));

        assertThat(lotto.getLottoRank(List.of(1,2,3,4,5,7),6))
                .isEqualTo(LottoRank.SECOND_PRIZE);
    }

    @Test
    void 로또_당첨_등수_확인_3등(){
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));

        assertThat(lotto.getLottoRank(List.of(1,2,3,4,5,7),8))
                .isEqualTo(LottoRank.THIRD_PRIZE);
    }
    @Test
    void 로또_당첨_등수_확인_4등(){
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));

        assertThat(lotto.getLottoRank(List.of(1,2,3,4,9,7),8))
                .isEqualTo(LottoRank.FOURTH_PRIZE);
    }
    @Test
    void 로또_당첨_등수_확인_5등(){
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));

        assertThat(lotto.getLottoRank(List.of(1,2,3,10,9,7),8))
                .isEqualTo(LottoRank.FIFTH_PRIZE);
    }
    @Test
    void 로또_당첨_등수_확인_미당첨(){
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));

        assertThat(lotto.getLottoRank(List.of(1,2,31,10,9,7),8))
                .isEqualTo(LottoRank.NO_PRIZE);
    }


}
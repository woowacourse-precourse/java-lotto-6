package lotto;

import lotto.domain.Grade;
import lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.domain.Grade.*;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

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
    @DisplayName("로또 생성 시 로또 번호가 오름차순 정렬된다.")
    @Test
    void lottoNumbersSorted() {
        final Lotto lotto = new Lotto(List.of(6, 5, 4, 3, 2, 1));
        assertThat(lotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @DisplayName("로또 당첨 결과를 얻을 수 있다")
    @Test
    void lottoGrade() {
        final List<Integer> answer = List.of(1, 2, 3, 4, 5, 6);
        final Integer bonus = 45;
        final Lotto none = new Lotto(List.of(6, 7, 8, 9, 10, 11));
        final Lotto three = new Lotto(List.of(4, 5, 6, 7, 8, 9));
        final Lotto four = new Lotto(List.of(3, 4, 5, 6, 7, 8));
        final Lotto five = new Lotto(List.of(2, 3, 4, 5, 6, 7));
        final Lotto fiveAndBonus = new Lotto(List.of(2, 3, 4, 5, 6, 45));
        final Lotto six = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertAll(
                () -> assertThat(none.grade(answer, bonus)).isEqualTo(NONE),
                () -> assertThat(three.grade(answer, bonus)).isEqualTo(THREE),
                () -> assertThat(four.grade(answer, bonus)).isEqualTo(FOUR),
                () -> assertThat(five.grade(answer, bonus)).isEqualTo(FIVE),
                () -> assertThat(fiveAndBonus.grade(answer, bonus)).isEqualTo(FIVE_AND_BONUS),
                () -> assertThat(six.grade(answer, bonus)).isEqualTo(SIX)
        );
    }

}
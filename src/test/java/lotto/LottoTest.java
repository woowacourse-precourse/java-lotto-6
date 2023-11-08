package lotto;

import static lotto.domain.Grade.FIVE;
import static lotto.domain.Grade.FIVE_AND_BONUS;
import static lotto.domain.Grade.FOUR;
import static lotto.domain.Grade.NONE;
import static lotto.domain.Grade.SIX;
import static lotto.domain.Grade.THREE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.WinningNumbers;
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
    @DisplayName("로또 생성 시 로또 번호가 오름차순 정렬된다.")
    @Test
    void lottoNumbersSorted() {
        final Lotto lotto = new Lotto(List.of(6, 5, 4, 3, 2, 1));
        assertThat(lotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @DisplayName("로또 당첨 결과를 얻을 수 있다")
    @Test
    void lottoGrade() {
        final WinningNumbers ANSWER = WinningNumbers.of("1,2,3,4,5,6");
        final BonusNumber BONUS = BonusNumber.from("45", ANSWER);
        final Lotto none = new Lotto(List.of(6, 7, 8, 9, 10, 11));
        final Lotto three = new Lotto(List.of(4, 5, 6, 7, 8, 9));
        final Lotto four = new Lotto(List.of(3, 4, 5, 6, 7, 8));
        final Lotto five = new Lotto(List.of(2, 3, 4, 5, 6, 7));
        final Lotto fiveAndBonus = new Lotto(List.of(2, 3, 4, 5, 6, 45));
        final Lotto six = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertAll(
                () -> assertThat(none.grade(ANSWER, BONUS)).isEqualTo(NONE),
                () -> assertThat(three.grade(ANSWER, BONUS)).isEqualTo(THREE),
                () -> assertThat(four.grade(ANSWER, BONUS)).isEqualTo(FOUR),
                () -> assertThat(five.grade(ANSWER, BONUS)).isEqualTo(FIVE),
                () -> assertThat(fiveAndBonus.grade(ANSWER, BONUS)).isEqualTo(FIVE_AND_BONUS),
                () -> assertThat(six.grade(ANSWER, BONUS)).isEqualTo(SIX)
        );
    }

}
package lotto;

import lotto.model.Lotto;
import lotto.model.LottoPaper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

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
    @DisplayName("로또 번호를 오름차순으로 정렬 확인")
    @Test
    void 오름차순_정렬_테스트() {
        // given
        List<Integer> numbers = Arrays.asList(6, 5, 4, 3, 2, 1);
        Lotto lotto = new Lotto(numbers);

        // when
        List<Integer> sortedNumbers = lotto.ascendingSort(numbers);

        // then
        assertThat(sortedNumbers)
                .containsExactly(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("로또 용지 생성 확인")
    @Test
    public void 로또_용지_생성() {
        // given
        List<Integer> numbers = Arrays.asList(6, 5, 4, 3, 2, 1);
        Lotto lotto = new Lotto(numbers);

        // when
        LottoPaper lottoPaper = lotto.toLottoPaper();  // 오름차순 정렬 후 생성

        // then
        assertAll(
                "로또 번호를 오름차순 정렬 후 로또 용지 생성 확인",
                () -> assertThat(lottoPaper).isInstanceOf(LottoPaper.class),
                () -> assertThat(lottoPaper.getLottoNumbers())
                        .containsExactly(1, 2, 3, 4, 5, 6)
        );
    }
}
package lotto.dto;

import lotto.dto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;

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

    @DisplayName("numbers private 접근 금지 테스트")
    @Test
    void numbers_private() {
        // Given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6)); // YourClass는 테스트하려는 클래스 이름으로 대체해야 합니다.
        // When
        try {
            Field privateNumbersField = Lotto.class.getDeclaredField("lottoNumbers");
            privateNumbersField.get(lotto); // private 필드에 접근 시 예외가 발생해야 함
            throw new AssertionError("private로 수정 해야 합니다.");
        } catch (NoSuchFieldException | IllegalAccessException e) {
        }
    }
}
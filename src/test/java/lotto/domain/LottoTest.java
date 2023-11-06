package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

class LottoTest {

    @Test
    @DisplayName("기능1,2 테스트 : 입력된 숫자조합에 이상이 없으면 로또가 하나 정상적으로 발행된다.")
    void LottoGeneratorShouldGenerateLottoInstance(){
        // given
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);

        // when, then
        assertThatCode(() -> new Lotto(list))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("기능3 테스트 : validate 메서드는 로또를 발행하기 위해 입력된 숫자의 개수가 6개가 아니면 IllegalArgumentException이 발생시킨다.")
    void validateShouldThrowIllegalArgumentExceptionWhenListSizeIsNotSix(){
        // given
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7);

        // when, then
        assertThatThrownBy(() -> new Lotto(list))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.LOTTO_COMBINATION_HAVE_SIX_NUMBER.getErrorMessage());
    }


}
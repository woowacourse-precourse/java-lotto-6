package lotto.utility.vo.request;

import static lotto.constants.ErrorMessage.NOT_INTEGER;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import lotto.domain.Lotto;
import lotto.vo.request.WinningNumberRequest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningNumberRequestTest {
    @ParameterizedTest
    @ValueSource(strings = {"1,3,4.6,7,8,9", "1,2,3,d,5,6"})
    void 당첨번호가_정수가_아니면_예외가_발생한다(String 당첨번호_입력) {
        // when & then
        assertThatThrownBy(() -> {
            new WinningNumberRequest(당첨번호_입력);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(NOT_INTEGER);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5, 6", " 1, 2, 3, 4, 5, 6 "})
    void 양옆공백이_포함된_당첨번호입력을_파싱한다(String 당첨번호_입력) {
        // when
        WinningNumberRequest 당첨번호_요청 = new WinningNumberRequest(당첨번호_입력);

        // then
        Lotto 생성된_당첨번호 =  당첨번호_요청.convertToValidLotto();
        String 확인용_로또번호_출력 = 생성된_당첨번호.convertToResponse().createMessage();

        assertEquals("[1, 2, 3, 4, 5, 6]", 확인용_로또번호_출력);
    }
}
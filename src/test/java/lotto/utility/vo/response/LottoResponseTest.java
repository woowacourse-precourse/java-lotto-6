package lotto.utility.vo.response;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;
import lotto.vo.response.LottoResponse;

class LottoResponseTest {
    @Test
    void 올바른_형식으로_발행된로또_출력메세지를_생성한다() {
        // given
        Lotto 로또 = new Lotto(List.of(5, 6, 3, 4, 1, 2));

        // when
        LottoResponse 출력용_응답 = 로또.convertToResponse();

        // then
        assertEquals("[1, 2, 3, 4, 5, 6]", 출력용_응답.createMessage());
    }

}
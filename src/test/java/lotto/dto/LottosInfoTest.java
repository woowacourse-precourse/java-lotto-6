package lotto.dto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosInfoTest {

    @DisplayName("로또번호들 정보의 개수를 출력가능한 문자열 형태로 변환한다.")
    @Test
    void getLottoCountText() {
        // given
        List<String> numbers = List.of("1,2,3,4,5,6", "1,2,3,4,5,6");
        LottosInfo lottosInfo = new LottosInfo(numbers);

        // when
        String result = lottosInfo.getLottoCountText();

        // then
        assertThat(result).contains(String.valueOf(numbers.size()))
                .contains("개를 구매했습니다.");
    }
}

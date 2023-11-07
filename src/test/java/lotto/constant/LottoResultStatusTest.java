package lotto.constant;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoResultStatusTest {
    @DisplayName("3을 입력하면 3개 일치 상태를 반환한다.")
    @Test
    void matchFromThreeToResultStatus() {
        LottoResultStatus actual = LottoResultStatus.from(3);
        assertThat(actual).isEqualTo(LottoResultStatus.THREE);
    }

    @DisplayName("7을 입력하면 5개+보너스 번호 일치 결과 상태를 반환한다.")
    @Test
    void matchFromSevenToResultStatus() {
        LottoResultStatus actual = LottoResultStatus.from(7);
        assertThat(actual).isEqualTo(LottoResultStatus.FIVE_BONUS);
    }

    @DisplayName("존재하지 않는 일치 개수(3~7 제외)를 입력하면 NOTHING 상태를 반환한다.")
    @ParameterizedTest
    @CsvSource({"0", "1", "2", "8"})
    void matchFromNotExistCountToResultStatus(int matchCount) {
        LottoResultStatus actual = LottoResultStatus.from(matchCount);
        assertThat(actual).isEqualTo(LottoResultStatus.NOTHING);
    }
}

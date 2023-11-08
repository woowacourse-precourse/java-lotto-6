package lotto.util;

import lotto.domain.LottoScore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoGameUtilTest {

    @Test
    @DisplayName("구입 금액 요청 포맷 검증 성공 케이스")
    void 구매_금액_요청_포맷_검증_성공() {
        assertThatCode(() -> LottoGameUtil.validPurchaseAmountFormat("1000"))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("구입 금액 요청 포맷 검증 실패 케이스")
    void 구매_금액_요청_포맷_검증_실패() {
        assertThatThrownBy(() -> LottoGameUtil.validPurchaseAmountFormat("1200"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("구매 금액 변환 성공 케이스")
    void 구매_금액_변환_성공() {
        assertThat(LottoGameUtil.convertPurchaseAmount("1000")).isEqualTo(1);
    }

    @Test
    @DisplayName("구매 금액 변환 실패 케이스")
    void 구매_금액_변환_실패() {
        assertThatThrownBy(() -> LottoGameUtil.convertPurchaseAmount("1200"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("로또 번호 생성 성공 케이스")
    void 로또_번호_생성_성공() {
        assertThat(LottoGameUtil.generateLottoNumbers(LottoGameUtil.convertPurchaseAmount("8000")).size()).isEqualTo(8);
    }

    @Test
    @DisplayName("당첨 로또 번호 입력 시 , 포함 검증 성공 케이스")
    void 당청_로또_번호_COMMA_포함_검증_성공() {
        assertThatCode(() -> LottoGameUtil.validNumbersContainsSeparator("1,2,3,4,5,6"))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("당첨 로또 번호 입력 시 , 포함 검증 실패 케이스")
    void 당첨_로또_번호_COMMA_포함_검증_실패() {
        assertThatThrownBy(() -> LottoGameUtil.validNumbersContainsSeparator("1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("로또 번호 변환 성공 케이스")
    void 로또_번호_변환_성공() {
        assertThat(LottoGameUtil.convertLottoNumber("1,2,3,4,5,6")).isInstanceOf(List.class);
    }

    @Test
    @DisplayName("로또 번호 변환 실패 케이스")
    void 로또_번호_변환_실패() {
        assertThatThrownBy(() -> LottoGameUtil.convertLottoNumber("a,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("GET RESULT 1등")
    void 로또_1등() {
        assertThat(LottoGameUtil.getResult(6, false).getName())
                .isEqualTo(LottoScore.FIRST_PLACE.getName());
    }

    @Test
    @DisplayName("GET RESULT 2등")
    void 로또_2등() {
        assertThat(LottoGameUtil.getResult(5, true).getName())
                .isEqualTo(LottoScore.SECOND_PLACE.getName());
    }

    @Test
    @DisplayName("GET RESULT 3등")
    void 로또_3등() {
        assertThat(LottoGameUtil.getResult(5, false).getName())
                .isEqualTo(LottoScore.THIRD_PLACE.getName());
    }

    @Test
    @DisplayName("GET RESULT 4등")
    void 로또_4등() {
        assertThat(LottoGameUtil.getResult(4, false).getName())
                .isEqualTo(LottoScore.FOURTH_PLACE.getName());
    }

    @Test
    @DisplayName("GET RESULT 5등")
    void 로또_5등() {
        assertThat(LottoGameUtil.getResult(3, false).getName())
                .isEqualTo(LottoScore.FIFTH_PLACE.getName());
    }

    @Test
    @DisplayName("GET RESULT 낫싱")
    void 로또_낫싱() {
        assertThat(LottoGameUtil.getResult(2, false).getName())
                .isEqualTo(LottoScore.NOTHING.getName());
        assertThat(LottoGameUtil.getResult(1, false).getName())
                .isEqualTo(LottoScore.NOTHING.getName());
        assertThat(LottoGameUtil.getResult(0, false).getName())
                .isEqualTo(LottoScore.NOTHING.getName());
    }
}
package lotto.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.HashMap;
import java.util.Map;
import lotto.util.MatchRanking;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoPriceTest {
    @DisplayName("입력 값이 숫자 형태가 아닐 시 예외 처리")
    @Test
    void isNumericDataType(){
        assertThatThrownBy(() -> new LottoPrice("100a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자 형식에 맞지 않습니다.");
    }

    @DisplayName("입력 값이 0일 때 예외 처리")
    @Test
    void inputNothing(){
        assertThatThrownBy(() -> new LottoPrice("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 살 수 없는 금액입니다.");
    }

    @DisplayName("구입 가격이 천만원을 넘을 시 예외 처리")
    @Test
    void buyLottoPriceLimit(){
        assertThatThrownBy(() -> new LottoPrice("10000001"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 너무 많은 갯수를 구입할 수 없습니다.");
    }

    @DisplayName("입력 값이 1000으로 나누어 떨어지지 않을 시 예외 처리")
    @Test
    void divisionByNotThousand(){
        assertThatThrownBy(() -> new LottoPrice("1001"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 천 단위로 입력해 주세요.");
    }

    @DisplayName("로또 구입 금액이 정수 형태로 변환되었는지 테스트")
    @Test
    void isCorrectDataTypeConvert() {

        assertSimpleTest(() -> {
            LottoPrice lottoPrice = new LottoPrice("8000");
            assertThat(lottoPrice.getLottoPrice()).isEqualTo(8000);
        });
    }


}

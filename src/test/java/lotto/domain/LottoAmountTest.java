package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoAmountTest {

    @ParameterizedTest
    @ValueSource(strings =  {"1000j","1234","-1"})
    @DisplayName("금액에 숫자 이외의 입력이 들어오면 예외가 발생한다.")
    void createLottoAmountByWrongInput(String inputAmount){
        assertThatThrownBy(()-> new LottoAmount(inputAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또의 장수가 정수가 아닌 경우 예외가 발생한다.")
    @Test
    void createLottoAmountByWrongLottoCount(){
        LottoAmount amount = new LottoAmount("1000");
        assertThat(amount.calculateLottoCount()).isEqualTo(1);
    }

}

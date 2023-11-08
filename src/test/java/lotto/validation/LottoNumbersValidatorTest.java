package lotto.validation;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumbersValidatorTest {
    private List<Integer> lottoNumbers;

    @BeforeEach
    void setUp() {
        lottoNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5));
    }

    @Test
    @DisplayName("로또에 들어가는 정수 List의 크기가 6보다 작은 경우")
    void lessSizeLottoNumbersTest(){
        //then
        assertThat(lottoNumbers.size()).isEqualTo(5);
        assertThatThrownBy(() -> LottoNumbersValidator.validate(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("로또에 들어가는 정수 List의 크기가 6보다 큰 경우")
    void largerSizeLottoNumbersTest(){
        //given
        lottoNumbers.add(6);
        lottoNumbers.add(7);
        //then
        assertThat(lottoNumbers.size()).isEqualTo(7);
        assertThatThrownBy(() -> LottoNumbersValidator.validate(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46, 50, -1})
    @DisplayName("정수 List 내에 1 ~ 45의 범위를 벗어나는 정수가 들어간 경우 예외 처리 테스트")
    void outOfRangeLottoNumberTest(int number){
        //given
        lottoNumbers.add(number);
        //then
        assertThat(lottoNumbers.size()).isEqualTo(6);
        assertThatThrownBy(() -> LottoNumbersValidator.validate(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 5})
    @DisplayName("정수 List 겹치는 수가 들어간 경우 예외 처리 테스트")
    void duplicateLottoNumberTest(int number){
        //given
        lottoNumbers.add(number);
        //then
        assertThat(lottoNumbers.size()).isEqualTo(6);
        assertThatThrownBy(() -> LottoNumbersValidator.validate(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
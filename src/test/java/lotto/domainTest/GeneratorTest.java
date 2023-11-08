package lotto.domainTest;

import lotto.domain.generators.WinningNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GeneratorTest {

    @DisplayName("당첨번호는 숫자가 아닌 값을 입력받을 경우 IllegalArgumentException 을 던진다.")
    @Test
    void lottoStringGenerateTest(){
        WinningNumberGenerator winningNumberGenerator = new WinningNumberGenerator();
        assertThatThrownBy(() -> winningNumberGenerator.generator("당첨번호"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호는 ',' 로 구분된 숫자를 입력받아 숫자 배열로 변환하여 반환한다")
    @Test
    void lottoNumberGenerateTest(){
        WinningNumberGenerator winningNumberGenerator = new WinningNumberGenerator();

        List<Integer> result = winningNumberGenerator.generator("1,2,3,4,5,6");
        List<Integer> expectedResult = List.of(1, 2, 3, 4, 5, 6);

        assertThat(result).isEqualTo(expectedResult);
    }

}

package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {
    LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService();
    }

    @Test
    @DisplayName("중복되지 않는 6개의 숫자 생성을 성공한다.")
    void test_GenerateNumbersSuccessful() {
        //when
        List<Integer> numbers = lottoService.generateNumbers();

        //then
        assertThat(numbers).allMatch(number -> (number > 1 && number < 45));
    }
}

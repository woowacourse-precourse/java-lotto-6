package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomTest {
    @DisplayName("로또 번호가 범위 안에서 생성된다.")
    @Test
    void generateLottoNumberTest() {
        Random random = new Random();
        int startNumber = 1;
        int endNumber = 45;
        int lottoNumber = random.generateLottoNumber(startNumber,endNumber);
        assertTrue(endNumber >= lottoNumber, "[Error] lottoNumber is too high");
        assertTrue(startNumber <= lottoNumber, "[Error] lottoNumber is too low");
        System.out.println("Test passed: " + lottoNumber + " is within " + endNumber + " and " + startNumber);
    }

    @DisplayName("각 로또 번호는 6개이다.")
    @Test
    void generateLottoNumbersTest() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        Random random = new Random();
        List<Integer> lottoNumbers = random.generateLottoNumbers();
        int lottoNumbersSize = lottoNumbers.size();
        assertThat(lottoNumbersSize).isEqualTo(6);
    }

    // 아래에 추가 테스트 작성 가능
}
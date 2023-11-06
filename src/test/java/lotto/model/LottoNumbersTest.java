package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersTest {
    private static List<Integer> lottoNumberList;

    @DisplayName("랜덤으로 생성되는 로또 개수가 6개를 넘을경우 예외가 발생한다.")
    @Test
    void createRandomNumber() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        lottoNumberList = lottoNumbers.setRandomNumbers();
        assertThat(lottoNumberList.size()).isEqualTo(6);
    }
    
}

package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    private LottoGenerator lottoGenerator = new LottoGenerator();

    @Test
    @DisplayName(value = "로또 번호가 중복 값 없이 범위에 맞는 알맞은 숫자들로 생성되는지 확인")
    void generateLottoNumber() {
        List<Integer> lottoNumbers = lottoGenerator.generateLottoNumbers();
        assertThatCode(() -> new Lotto(lottoNumbers)).doesNotThrowAnyException();
    }

}
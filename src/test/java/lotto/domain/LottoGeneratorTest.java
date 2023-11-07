package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGeneratorTest {
    LottoGenerator lottoGenerator;

    @BeforeEach
    void setUp() {
        lottoGenerator = new LottoGenerator();
    }

    @DisplayName("로또 번호가 잘 생성되는 지 확인한다.")
    @Test
    void generateLottoNumbers() {
        System.out.println(lottoGenerator.generateLottoNumbers());
    }
}

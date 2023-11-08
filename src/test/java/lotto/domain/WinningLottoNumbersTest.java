package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

class WinningLottoNumbersTest {
    WinningLottoNumbers winningLottoNumbers;
    @BeforeEach
    void setUp() {
        winningLottoNumbers = new WinningLottoNumbers("1,2,3,4,5,6", "7");
    }

    @Test
    void 인스턴스_잘_생성되었는지_테스트() {
        assertThat(winningLottoNumbers.getBonus()).isEqualTo(7);
    }

}
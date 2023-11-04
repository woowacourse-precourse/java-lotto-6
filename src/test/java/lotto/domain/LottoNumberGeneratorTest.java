package lotto.domain;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mockStatic;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.mockito.MockedStatic;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoNumberGeneratorTest {
    private static MockedStatic<Randoms> randoms;

    @BeforeEach
    void init() {
        randoms = mockStatic(Randoms.class);
    }

    @AfterEach
    void close() {
        randoms.close();
    }

    @DisplayName("[Success] 랜덤 생성된 로또 넘버를 오름차순으로 리턴한다.")
    @Test
    void generateSortedLottoNumber() {
        when(Randoms.pickUniqueNumbersInRange(1, 45, 6))
턴                .thenReturn(List.of(6, 5, 4, 3, 2, 1));

        assertThat(LottoNumberGenerator.generateLottoNumbers())
                .containsExactly(1, 2, 3, 4, 5, 6);
    }
}

package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    private Lotto lotto;

    @BeforeEach
    void setTest() {
        lotto = new Lotto(List.of(6, 5, 4, 3, 2, 1));
    }

    @DisplayName("toString 메소드 : 출력 결과 테스트")
    @Test
    void toString_validateFormat() {
        assertThat(lotto.toString()).isIn("[6, 5, 4, 3, 2, 1]", "[1, 2, 3, 4, 5, 6]");
    }

    @DisplayName("toString 메소드 : 오름차순 정렬 테스트")
    @Test
    void sort_validateAsc() {
        assertThat(lotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

}
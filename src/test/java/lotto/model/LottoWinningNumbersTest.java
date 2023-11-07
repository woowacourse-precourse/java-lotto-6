package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoWinningNumbersTest {
    private List<Integer> lottoNumber;

    // 나중에 검사할 메서드가 더 생길까보 ㅏ미리 만들어놨는데... 아니면 메서드 안으로 옮기기
    @BeforeEach
    void setUp() {
        lottoNumber = List.of(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("보너스 번호가 로또 번호랑 겹치면 예외가 발생한다.")
    @Test
    void createBonusNumberByDuplicatedNumber() {
        assertThatThrownBy(() -> new LottoWinningNumbers(lottoNumber, 5))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

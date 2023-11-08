package lotto;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTableTest {
    private LottoTable lottoTable;

    @BeforeEach
    void setUp() {
        lottoTable = new LottoTable(5); // Change the number of rows as needed.
    }

    @Test
    @DisplayName("생성한 테이블 갯수와 입력한 테이블 갯수가 같은지 확인")
    void testRowCount() {
        assertThat(lottoTable.getRow()).isEqualTo(5);
    }
}

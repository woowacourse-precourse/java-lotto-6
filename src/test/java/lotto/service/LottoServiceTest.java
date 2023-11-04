package lotto.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoServiceTest {
    LottoService lottoService = new LottoService();

    @DisplayName("Integer 리스트 오름차순 정렬 테스트 - 성공")
    @Test
    void orderNumbersByAsc() {
        List<Integer> testList = Arrays.asList(3, 2, 1, 4, 6, 5);
        List<Integer> expectedResult = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(lottoService.sortNumbersByAsc(testList)).isEqualTo(expectedResult);
    }
}

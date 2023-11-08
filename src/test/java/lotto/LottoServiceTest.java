package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import domain.LottoService;
import java.util.List;
import org.junit.jupiter.api.Test;


public class LottoServiceTest {

    LottoService lottoService = new LottoService();

    @Test
    void 로또_번호_생성_테스트() {
        List<List<Integer>> generatedTickets = lottoService.generateLottoNumbers(5);

        for (List<Integer> ticket : generatedTickets) {
            assertThat(ticket).doesNotHaveDuplicates();
            assertThat(ticket).hasSize(6);
        }
    }

    @Test
    void 숫자_문자열_변환_테스트() {
        LottoService lottoService = new LottoService();

        String numbers = "3,14,25,30,42,7"; // 예시 숫자 문자열

        List<Integer> integerList = lottoService.convertToIntegerList(numbers);

        // 예상한 정수 배열과 변환된 리스트가 일치하는지 확인
        Integer[] expected = {3, 14, 25, 30, 42, 7};
        assertArrayEquals(expected, integerList.toArray());
    }
}

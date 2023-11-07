package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {
    @Test
    @DisplayName("주어진 리스트를 오름차순으로 정렬합니다.")
    void sortTest(){
        // given
        List<Integer> numbers = Arrays.asList(new Integer[]{6,5,4,3,2,1});
        List<Integer> answer = Arrays.asList(new Integer[]{1,2,3,4,5,6});

        // when
            // 실제 구현에서 Collections.sort를 사용 시 통합 테스트에서 UnsupportedOperationException 발생
            // 구현에선 stream을 통해 정렬
        Collections.sort(numbers);

        // then
        assertThat(numbers).isEqualTo(answer);
    }
}

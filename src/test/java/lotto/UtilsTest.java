package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UtilsTest {
    @Test
    void 오름차순으로_정렬하는_기능_테스트() {
        List<Integer> result = Utils.generateRandomLottoNumbers();
        int base = Integer.MIN_VALUE;
        for (int r : result) {
            assertThat(r).isGreaterThan(base);
            base = r;
        }
    }
}

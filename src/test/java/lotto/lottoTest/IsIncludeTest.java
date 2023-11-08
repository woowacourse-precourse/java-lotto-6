package lotto.lottoTest;

import lotto.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class IsIncludeTest {
    @Test
    public void 입력받은_수가_포함되어_있음_오류없음() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Assertions.assertThat(lotto.isInclude(1)).isEqualTo(true);
    }

    @Test
    public void 입력받은_수가_포함안됨_오류없음() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Assertions.assertThat(lotto.isInclude(7)).isEqualTo(false);
    }
}

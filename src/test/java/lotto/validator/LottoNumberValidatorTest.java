package lotto.validator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberValidatorTest {
    @Test
    @DisplayName("주어진 리스트에 중복 숫자가 있는지 확인합니다.")
    void duplicationTest(){
        // given
        List<Integer> numbers = Arrays.asList(new Integer[]{2, 2, 3, 4, 5, 6});

        // when
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        // then
        Assertions.assertThat(uniqueNumbers.size()==6).isEqualTo(false);
    }
}

package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {

    @DisplayName("보너스 번호와 일치하는 번호가 있는지 확인하는 기능 테스트")
    @Test
    void isContains() {
        BonusNumber bonusNumber = new BonusNumber(5);
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
        boolean expected = true;

        boolean isContains = bonusNumber.isContains(numbers);

        assertThat(isContains).isEqualTo(expected);
    }
}
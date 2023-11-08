package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class LottoTest { //입력값 예외발생 로직은 InputView에서 담당.
    @Test
    @DisplayName("유효한 입력이 들어올 경우 Lotto 객체가 생성된다.")
    public void createLottoInstanceWhenGivenValidNumbers() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);

        Lotto lotto = new Lotto(numbers);

        assertThat(lotto.getNumbers()).hasSize(6);
        assertThat(lotto.getNumbers()).isSorted();
    }
}
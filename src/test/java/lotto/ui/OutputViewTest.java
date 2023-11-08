package lotto.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {

    @DisplayName("불변 리스트를 복사해 숫자를 오름차순으로 정렬하고 반환한다.")
    @Test
    void sortNumbers() {
        OutputView outputView = new OutputView();
        List<Integer> numbers = outputView.sortNumbers(List.of(6, 5, 4, 3, 2, 1));

        assertThat(numbers).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }
}
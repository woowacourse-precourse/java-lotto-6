package lotto.view;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

    private InputView inputView;

    @BeforeEach
    public void setUp() {
        inputView = new InputView();
    }

    @Test
    @DisplayName("공백을 제거한 문자열 변환 테스트")
    void trimTest() {
        List<Integer> lotto = inputView.convertWinningNumber("1, 2 , 3 , 4 , 5 , 6 ");
        Assertions.assertThat(List.of(1, 2, 3, 4, 5, 6)).isEqualTo(lotto);
    }

}
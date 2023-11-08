package lotto.view.inputview;

import lotto.Error;
import lotto.dto.InputDto;
import lotto.view.InputView;
import lotto.view.ParameterConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoBuyInputViewTest {
    private final InputView inputView = new LottoBuyInputView();

    @Test
    @DisplayName("해당 입력들에 대해 예외가 발생해야한다.")
    void 구입금액_예외_발생_테스트() {
        //given
        List<String> testParam = getTestParam();

        //when
        String join = String.join("\n", testParam);
        System.setIn(new ByteArrayInputStream(join.getBytes()));
        for (String input : testParam) {
            Map<String, InputDto> param = new HashMap<>();
            param.put(ParameterConfig.BUY_PRICE, null);
            //then
            assertThatThrownBy(() -> inputView.read(param))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(Error.View.NOT_NUMBER.getText());
        }

    }

    public List<String> getTestParam() {
        return List.of("-1m1  ",
                "1-000  ",
                "1  -0- 00 00 0 0 00 0 ",
                "가나다132  ",
                "  ",
                "  . ");
    }
}
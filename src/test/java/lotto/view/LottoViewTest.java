package lotto.view;

import static lotto.constant.ErrorMessage.ANOTHER_COMMA;
import static lotto.constant.ErrorMessage.CONTAIN_BLANK;
import static lotto.constant.ErrorMessage.EMPTY;
import static lotto.constant.ErrorMessage.INPUT_STRING;
import static lotto.constant.ErrorMessage.SEQUENCE_COMMA;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lotto.constant.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoViewTest {
/*
    @DisplayName("콤마가 2개 이상인 경우")
    @Test
    void 콤마_2개이상() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            String input = "1,2,3,4,,5,6";
            long commaCount = input.chars().filter(ch -> ch == ',').count();
            if (commaCount > 5) {
                throw new IllegalArgumentException(SEQUENCE_COMMA.getMessage());
            }
        });

        assertThat(exception.getMessage()).
                isEqualTo("[ERROR] ','를 연속해서 적었습니다");
    }


 */
    @DisplayName("입력값이 공백인 경우")
    @Test
    void 입력값_공백() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            String input = "";
            if (input.isEmpty()) {
                throw new IllegalArgumentException(EMPTY.getMessage());
            }
        });

        assertThat(exception.getMessage()).
                isEqualTo("[ERROR] 입력을 안 했습니다");
    }

    @DisplayName(", 로 구분을 하지 않았을 경우")
    @Test
    void 콤마_사용x() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            String input = "1,2,3.4,5,6";
            long commaCount = input.chars().filter(ch -> ch == ',').count();
            if (commaCount != 5) {
                throw new IllegalArgumentException(ANOTHER_COMMA.getMessage());
            }

        });

        assertThat(exception.getMessage()).
                isEqualTo(("[ERROR] 입력은 ',' 으로 구분해야합니다"));
    }

    @DisplayName("문자열에 공백이 포함된 경우")
    @Test
    void 입력값에_공백이_포함된_경우() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            String input = "1,2,3,  4,5,6";
            Pattern pattern = Pattern.compile("\\s");
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                throw new IllegalArgumentException(CONTAIN_BLANK.getMessage());
            }
        });

        assertThat(exception.getMessage()).
                isEqualTo("[ERROR] 입력에 공백이 섞여있습니다");
    }

    @DisplayName("','을 기준으로 잘 나눠지나")
    @Test
    void 리스트_나누기() {
        String input = "1,2,3,4,5,6";
        List<String> expected = Arrays.asList("1", "2", "3", "4", "5", "6");
        assertThat(Arrays.stream(input.split(","))).isEqualTo(expected);
    }

    @DisplayName("정수가 아닌경우 에러발생")
    @Test
    void 문자열_에러처리() {
        String input = "1,2,3,4,a,6";

        assertThrows(IllegalArgumentException.class, () -> {
            for (String part : input.split(",")) {
                Integer.parseInt(part);
            }
        });
    }

}

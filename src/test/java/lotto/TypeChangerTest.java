package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.TypeChanger;
import org.junit.jupiter.api.Test;

public class TypeChangerTest {
    private final TypeChanger typeChanger = TypeChanger.getTypeChanger();
    @Test
    void 쉼표를_기준으로_분리한다() {
        assertThat(typeChanger.stringToListWithComma("1,2,3,4,5,6")).isEqualTo(List.of("1","2","3","4","5","6"));
    }

    @Test
    void 문자열을_숫자로_바꾼다() {
        assertThat(typeChanger.from("1")).isInstanceOf(Integer.class);
    }

    @Test
    void String리스트를_Integer리스트로() {
        List<String> numbers = typeChanger.stringToListWithComma("1,2,3,4,5,6");
        typeChanger.from(numbers).forEach(number -> assertThat(number).isInstanceOf(Integer.class));
    }
}

package lotto.validation;

import lotto.property.ErrorProperty;
import lotto.validation.validator.RootValidator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
public class RootValidatorTest {

    @Test
    void 사용자_입력_값_공백_값_검증_로직_테스트(){
        //given
        String target = "";

        assertThatThrownBy(()->{
                RootValidator.valueIsEmpty(target);
            }
                ).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorProperty.VALUE_IS_EMPTY.toString());
    }

    @Test
    void 사용자_입력_값_공백_포함_검증_로직_테스트(){
        //given
        String target = "1,2 ,3,4,5,6";

        assertThatThrownBy(()->{
            RootValidator.valueContainsSpace(target);
        }
            ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorProperty.VALUE_CONTATIN_SPACE.toString());
    }
}

package lotto.entity.mapper;

import lotto.entity.Cost;
import lotto.property.ErrorProperty;
import lotto.property.MethodProperty;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class FieldMapperTest {

    @Test
    void FiledMapper_생성_시_예외_테스트(){
        //given
        String target = "TEST";

        //when
        assertThatThrownBy(()->{
                FiledMapper.getFieldValue(Cost.class, target);
            }
                ).isInstanceOf(IllegalStateException.class)
                    .hasMessage(ErrorProperty.FILED_MAPPER_IS_NOT_CORRECT_PARAMETER.toString());
    }
}

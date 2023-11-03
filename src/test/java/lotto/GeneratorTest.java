package lotto;

import java.util.List;
import lotto.model.Generator;
import lotto.model.LottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GeneratorTest {

    @DisplayName("로또 번호 6자리 생성 확인 테스트")
    @Test
    void createNumbers_IsResult_Equals_SixNumbers_Succes() {
        //given
        Generator generator = new Generator();
        List<Integer> numbers = generator.createNumbers();
        //when

        //then
        assertThat(numbers.size()).isEqualTo(6);
    }

    @DisplayName("로또 번호 6자리 중복 테스트")
    @Test
    void createNumbers_IsDuplicated_Fail(){
        //given
        Generator generator = new Generator();
        List<Integer> numbers = generator.createNumbers();
        //when

        //then
        assertThat(numbers.size()).isEqualTo(6);
        assertThat(numbers).doesNotHaveDuplicates();
    }





}

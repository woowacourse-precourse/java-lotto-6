package lotto.ModelTest;

import java.util.List;
import lotto.Model.BonusNumber.BonusNumber;
import lotto.Model.Lotto.Lotto;
import lotto.Model.LottoSet.LottoSet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ModelTest {
    @Test
    void 보너스_모델_객체_생성_테스트() {
        BonusNumber bonusNumber = new BonusNumber(1);
        assertThat(bonusNumber.getBonusNumber()).isEqualTo(1);
    }
    @Test
    void 보너스_모델_입력_범위_테스트 () {
        Assertions.assertThrows(IllegalArgumentException.class,
                ()-> new BonusNumber(-1));
    }

    @Test
    void Lotto모델_로또_수_가_6개_인지 () {
        List<Integer> numbers = List.of(1,2,3,4,5,6);
        Lotto lotto = new Lotto(numbers);
        assertThat(lotto.getNumbers().size()).isEqualTo(6);
    }

    @Test
    void Lotto모델_넘버가_정상_범위인지 (){
        List<Integer> numbers = List.of(3,4,43,23,21,56);
        Assertions.assertThrows(IllegalArgumentException.class,
                ()-> new Lotto(numbers));
    }

    @Test
    void Lotto모델_넘버에_중복이_있는지 (){
        List<Integer> numbers = List.of(3,4,23,21,43,43);
        Assertions.assertThrows(IllegalArgumentException.class,
                ()-> new Lotto(numbers));
    }

    @Test
    void Lotto모델_넘버가_오름차순_정렬_되있는지 (){
        List<Integer> numbers = List.of(3,4,5,6,43,21);
        Assertions.assertThrows(IllegalArgumentException.class,
                ()-> new Lotto(numbers));
    }

    @Test
    void LottoSet모델_NULL이_아닌지 (){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new LottoSet(null));
    }

}

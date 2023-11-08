package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoNumberCreatorTest {
    @Test
    public void 로또_숫자_생성_테스트() {
        //given
        int number = 5;
        String input = "1,2,3,4,5,6";
        LottoNumberCreator lottoNumberCreator = new LottoNumberCreator();

        //when
        Lottos lottos = lottoNumberCreator.createLottoNumbers(number);
        List<Integer> numbers = lottoNumberCreator.stringToList(input);

        //then
        Assertions.assertThat(lottos.getSize()).isEqualTo(number);

        for(int i = 1; i <= 6; i++) {
            Assertions.assertThat(i).isEqualTo(numbers.get(i - 1));
        }
    }
}

package lotto.domain.lotto.converter;

import java.util.List;
import lotto.domain.lotto.Lotto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottoMessageConverterTest {

    @Test
    void 로또_번호_컨버팅() {
        LottoMessageConverter converter = new LottoMessageConverter();
        List<Lotto> lottos = List.of(new Lotto(List.of(11, 24, 43, 26, 16, 7)), new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        String actualValue = converter.convertLottoNumberMessage(lottos);
        String expectedValue = """
                
                2개를 구매했습니다.
                [11, 24, 43, 26, 16, 7]
                [1, 2, 3, 4, 5, 6]
                """;
        Assertions.assertEquals(actualValue, expectedValue);
    }
}

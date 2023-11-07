package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class LottosTest {

    @Test
    public void 자동_로또리스트_생성() {
        // Given
        ThousandUnitMoney money = ThousandUnitMoney.create(8000);
        int oneLottoPrice = 1000;

        // When
        Lottos result = Lottos.createAutomatic(money, oneLottoPrice);

        // Then
        assertThat(result.size()).isEqualTo(8);
    }

    @Test
    public void 로또리스트_형식에맞춰_출력() {
        // Given
        List<Lotto> lottoList = List.of(
                Lotto.create("1,2,3,4,5,6"),
                Lotto.create("11,22,33,34,35,45"));
        Lottos lottos = Lottos.create(lottoList);

        // When
        String result = lottos.toString();

        // Then
        assertThat(result).isEqualTo("[1, 2, 3, 4, 5, 6]\n[11, 22, 33, 34, 35, 45]");
    }

}

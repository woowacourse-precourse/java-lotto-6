package lotto.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoServiceTest {
    @DisplayName("입력 변수 만큼의 Lotto를 생성하는 기능")
    @ParameterizedTest
    @ValueSource(ints = {3, 5, 7, 9})
    void 로또_여러개_생성_기능(int count) {
        LottoService lottoService = new LottoService();
        List<Lotto> lottos = lottoService.generateAutoLottos(count);

        assertThat(lottos.size()).isEqualTo(count);
    }

    @DisplayName("수동 로또 생성 로직")
    @Test
    void 당첨_로또_생성기능() {
        //given
        LottoService lottoService = new LottoService();
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));

        //when
        Lotto manualLotto = lottoService.generateManualLotto(numbers);

        //then
        assertThat(manualLotto.getNumbersMessage()).isEqualTo("[1, 2, 3, 4, 5, 6]");
        numbers.forEach((number) -> assertThat(manualLotto.isContains(new LottoNumber(number))).isTrue());
    }
}

package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.Arrays;
import java.util.List;
import lotto.util.LottoValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {
    private LottoMachine machine;
    private LottoBundle bundle;
    private List<Lotto> lottos;

    @BeforeEach
    void setup() {
        machine = new LottoMachine("8000");
        bundle = machine.makeLottoBundle();
        lottos = bundle.getBundle();
    }

    @DisplayName("입력한 금액만큼 로또를 생성하는지 확인")
    @Test
    void createLotto() {
        assertThat(lottos.size()).isEqualTo(8);
    }

    @DisplayName("생성된 로또가 정상적인지 확인")
    @Test
    void checkCompleteLotto() {
        for (Lotto lotto : lottos) {
            String test = lotto.toString();
            List<String> splitted = Arrays.asList(test.substring(1, test.length() - 1).split(",", -1));
            for (int i = 0; i < splitted.size(); i++) {
                splitted.set(i, splitted.get(i).trim());
            }
            assertDoesNotThrow(() -> new LottoValidator().lottoNumbers(splitted));
        }
    }
}
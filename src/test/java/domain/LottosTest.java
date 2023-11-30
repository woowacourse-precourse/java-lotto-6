package domain;

import util.constants.LottosConstants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static provider.TestProvider.createTestPurchaseLottos;

public class LottosTest {

    private Lottos testLottos;
    private int numberOfPurchased;

    @BeforeEach
    void init(){
        numberOfPurchased = 3;
        testLottos = createTestPurchaseLottos(numberOfPurchased);
    }

    @DisplayName("구매한 만큼 로또 목록을 생성한다. - 3개의 로또가 모두 서로 다른 숫자로 이루어졌는지 확인한다.")
    @Test
    void createRandomLottoNumbers() {
        List<Lotto> generatedLottos = testLottos.getLottos();

        assertNotNull(generatedLottos);
        assertEquals(numberOfPurchased, generatedLottos.size());

        for (Lotto lotto : generatedLottos) {
            validateLotto(lotto);
        }
    }

    private void validateLotto(Lotto lotto) {
        assertNotNull(lotto);
        List<Integer> numbers = lotto.getNumbers();

        assertNotNull(numbers);
        assertEquals(LottosConstants.LOTTO_SIZE.getValue(), numbers.size());
    }
}

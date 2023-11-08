package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

public class RandomLottoGeneratorTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10, 100})
    @DisplayName("랜덤 로또 생성 테스트")
    public void testIssueRandomLottos(int lottoQuantity) {
        RandomLottoGenerator randomLottoGenerator = new RandomLottoGenerator();
        List<Lotto> lottos = randomLottoGenerator.issueRandomLottos(lottoQuantity);

        assertEquals(lottoQuantity, lottos.size());
        for (Lotto lotto : lottos) {
            assertEquals(Lotto.LOTTO_SIZE, lotto.getLottoNumbers().size());
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "10,15,20,25,30,35", "7,14,21,28,35,42"})
    @DisplayName("사용자 입력으로 로또 생성 테스트")
    public void testInputToGenerateLotto(String input) {
        RandomLottoGenerator randomLottoGenerator = new RandomLottoGenerator();
        Lotto lotto = randomLottoGenerator.inputToGenerateLotto(input);

        assertEquals(Lotto.LOTTO_SIZE, lotto.getLottoNumbers().size());

        // 입력한 숫자들이 로또 번호에 포함되어 있는지 확인
        String[] inputNumbers = input.split(",");
        for (String num : inputNumbers) {
            int parsedNum = Integer.parseInt(num);
            assertTrue(lotto.getLottoNumbers().contains(new LottoNumber(parsedNum)));
        }
    }
}

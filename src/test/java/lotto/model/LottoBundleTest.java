package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.util.enums.LottoResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoBundleTest {
    Lotto lotto1;
    Lotto lotto2;
    Lotto lotto3;

    Map<Lotto, Integer> bundles;
    LottoBundle lottoBundle;

    @BeforeEach
    void setUp() {
        lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        lotto2 = new Lotto(List.of(2, 3, 4, 5, 6, 7));
        lotto3 = new Lotto(List.of(3, 4, 5, 6, 7, 8));

        bundles = new LinkedHashMap<>();
        bundles.put(lotto1, 0);
        bundles.put(lotto2, 0);
        bundles.put(lotto3, 0);

        lottoBundle = new LottoBundle(bundles);
    }

    @DisplayName("로또 번호 DTO 생성 테스트")
    @Test
    void 로또_번호로_DTO_생성() {
        List<LottoDTO> lottoDTOList = lottoBundle.generateLottoTicketReport();
        LottoDTO lottoDTO1 = lottoDTOList.get(0);
        LottoDTO lottoDTO2 = lottoDTOList.get(1);
        LottoDTO lottoDTO3 = lottoDTOList.get(2);

        assertThat(lottoDTO1.getNumbers()).containsExactlyElementsOf(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lottoDTO2.getNumbers()).containsExactlyElementsOf(List.of(2, 3, 4, 5, 6, 7));
        assertThat(lottoDTO3.getNumbers()).containsExactlyElementsOf(List.of(3, 4, 5, 6, 7, 8));
    }

    @DisplayName("당첨 번호와 보너스 번호를 로또 번호와 비교하는 테스트")
    @Test
    void 로또_번호_비교() {
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");
        BonusNumber bonusNumber = new BonusNumber("7", winningNumbers);

        Map<String, Integer> expectedResult = new HashMap<>();
        expectedResult.put(LottoResult.MATCH_3.getDescription(), 0);
        expectedResult.put(LottoResult.MATCH_4.getDescription(), 1);
        expectedResult.put(LottoResult.MATCH_5.getDescription(), 0);
        expectedResult.put(LottoResult.MATCH_5_BONUS.getDescription(), 1);
        expectedResult.put(LottoResult.MATCH_6.getDescription(), 1);

        Map<String, Integer> winningResult = lottoBundle.compareLotto(winningNumbers, bonusNumber);

        assertThat(winningResult).isEqualTo(expectedResult);
    }
}
package lotto.service;

import lotto.model.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import static lotto.Message.ErrorMessage.AMOUNT_RANGE_ERROR_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoServiceTest {
    @DisplayName("LottoService_당첨_로또_번호_개수_세기")
    @Test
    public void LottoService_count_equalNumber() {
        List<List<Integer>> userNumbers = Arrays.asList(
                Arrays.asList(3, 6, 8, 26, 44, 34),
                Arrays.asList(1, 2, 3, 4, 29, 30),
                Arrays.asList(1, 2, 3, 4, 5, 8),
                Arrays.asList(1, 2, 3, 4, 5, 7),
                Arrays.asList(1, 2, 3, 4, 5, 6)
        );
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        int bonusLotto = 7;

        LottoService lottoService = new LottoService(userNumbers, numbers, bonusLotto);
        ConcurrentHashMap<List<Integer>, Winning> winningResult = lottoService.compareLottoNumber();

        assertAll(
                () -> assertThat(winningResult.get(Arrays.asList(3, 6, 8, 26, 44, 34)).getEqualCount()).isEqualTo(2),
                () -> assertThat(winningResult.get(Arrays.asList(1, 2, 3, 4, 29, 30)).getEqualCount()).isEqualTo(4),
                () -> assertThat(winningResult.get(Arrays.asList(1, 2, 3, 4, 5, 8)).getEqualCount()).isEqualTo(5),
                () -> assertThat(winningResult.get(Arrays.asList(1, 2, 3, 4, 5, 7)).getEqualCount()).isEqualTo(5),
                () -> assertThat(winningResult.get(Arrays.asList(1, 2, 3, 4, 5, 6)).getEqualCount()).isEqualTo(6)
        );
    }
    @DisplayName("LottoService_로또_보너스_볼_확인_하기")
    @Test
    public void LottoService_check_lotto_bonus() {
        List<List<Integer>> userNumbers = Arrays.asList(
                Arrays.asList(3, 6, 8, 26, 44, 34),
                Arrays.asList(1, 2, 3, 4, 29, 30),
                Arrays.asList(1, 2, 3, 4, 5, 8),
                Arrays.asList(1, 2, 3, 4, 5, 7),
                Arrays.asList(1, 2, 3, 4, 5, 6)
        );
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        int bonusLotto = 7;

        LottoService lottoService = new LottoService(userNumbers, numbers, bonusLotto);
        ConcurrentHashMap<List<Integer>, Winning> winningResult = lottoService.compareLottoNumber();

        assertAll(
                () -> assertThat(winningResult.get(Arrays.asList(3, 6, 8, 26, 44, 34)).getBonus()).contains(""),
                () -> assertThat(winningResult.get(Arrays.asList(1, 2, 3, 4, 29, 30)).getBonus()).contains(""),
                () -> assertThat(winningResult.get(Arrays.asList(1, 2, 3, 4, 5, 8)).getBonus()).contains(""),
                () -> assertThat(winningResult.get(Arrays.asList(1, 2, 3, 4, 5, 7)).getBonus()).contains("보너스 볼"),
                () -> assertThat(winningResult.get(Arrays.asList(1, 2, 3, 4, 5, 6)).getBonus()).contains("")
        );
    }
}

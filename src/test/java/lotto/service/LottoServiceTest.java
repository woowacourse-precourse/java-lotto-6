package lotto.service;

import lotto.model.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import static lotto.Message.ErrorMessage.AMOUNT_RANGE_ERROR_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNull;

class LottoServiceTest {
    @DisplayName("LottoService_당첨_로또_번호_개수_세기_3_이상")
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
        ConcurrentHashMap<List<Integer>, Winning> winningResults = lottoService.compareLottoNumber();

        assertAll(
                () -> assertNull(winningResults.get(Arrays.asList(3, 6, 8, 26, 44, 34))),
                () -> assertThat(winningResults.get(Arrays.asList(1, 2, 3, 4, 29, 30))
                        .getEqualCount()).isNotNull().isEqualTo(4),
                () -> assertThat(winningResults.get(Arrays.asList(1, 2, 3, 4, 5, 8))
                        .getEqualCount()).isNotNull().isEqualTo(5),
                () -> assertThat(winningResults.get(Arrays.asList(1, 2, 3, 4, 5, 7))
                        .getEqualCount()).isNotNull().isEqualTo(5),
                () -> assertThat(winningResults.get(Arrays.asList(1, 2, 3, 4, 5, 6))
                        .getEqualCount()).isNotNull().isEqualTo(6)
        );
    }
    @DisplayName("LottoService_로또_보너스_볼_확인_하기_3_이상")
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
        ConcurrentHashMap<List<Integer>, Winning> winningResults = lottoService.compareLottoNumber();

        assertAll(
                () -> assertNull(winningResults.get(Arrays.asList(3, 6, 8, 26, 44, 34))),
                () -> assertThat(winningResults.get(Arrays.asList(1, 2, 3, 4, 29, 30))
                        .getBonus()).isNotNull().contains(""),
                () -> assertThat(winningResults.get(Arrays.asList(1, 2, 3, 4, 5, 8))
                        .getBonus()).isNotNull().contains(""),
                () -> assertThat(winningResults.get(Arrays.asList(1, 2, 3, 4, 5, 7))
                        .getBonus()).isNotNull().contains("보너스 볼"),
                () -> assertThat(winningResults.get(Arrays.asList(1, 2, 3, 4, 5, 6))
                        .getBonus()).isNotNull().contains("")
        );
    }
}

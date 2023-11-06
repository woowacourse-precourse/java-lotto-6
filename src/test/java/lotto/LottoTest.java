package lotto;

import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    LottoService lottoService = new LottoService();

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호를 잘 작동하는지 검사한다.")
    @Test
    void testValidBonusNumber1() {
        // 내가 산 로또 번호
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(lottoNumbers);
        LottoRank lottoRank[] = new LottoRank[1];
        lottoRank[0] = new LottoRank(lotto);

        // 로또 당첨 번호
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 6, 8);
        // 로또 보너스 번호
        int bonusNumber = 5;

        Rank[] ranks = lottoService.calculateWinningDetails(lottoRank, winningNumbers, bonusNumber);

        assertThat(ranks[3].getAmount()).isEqualTo(1);
    }

    @DisplayName("4개를 맞추고 보너스 번호를 맞출 경우 4개이다.")
    @Test
    void testValidBonusNumber2() {
        // 내가 산 로또 번호
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 9);
        Lotto lotto = new Lotto(lottoNumbers);
        LottoRank lottoRank[] = new LottoRank[1];
        lottoRank[0] = new LottoRank(lotto);

        // 로또 당첨 번호
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 6, 8);
        // 로또 보너스 번호
        int bonusNumber = 5;

        Rank[] ranks = lottoService.calculateWinningDetails(lottoRank, winningNumbers, bonusNumber);

        assertThat(ranks[1].getAmount()).isEqualTo(1);
    }
}
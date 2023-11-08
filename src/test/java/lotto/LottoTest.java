package lotto;

import lotto.domain.Lotto;
import lotto.domain.Match;
import lotto.repository.LottoRepository;
import lotto.repository.MemoryLottoRepository;
import lotto.service.LottoService;
import lotto.service.LottoServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

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

    // 아래에 추가 테스트 작성 가능

    @DisplayName("당첨 번호에 보너스 번호와 같은 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinLottoAndDuplicatedBonusNum() {
        AppConfig appConfig = new AppConfig();
        LottoService lottoService = appConfig.lottoService();

        Lotto winLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int duplicatedBonusNum = 1;

        assertThatThrownBy(() -> lottoService.setAnswer(winLotto, duplicatedBonusNum))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호의 숫자가 1~45의 값이 아니면 예외가 발생한다.")
    @Test
    void createLottoOutOfRange() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

//    @DisplayName("보너스 번호 당첨 + 5개 일치 시 2등으로 판단한다.")
//    @Test
//    void secondScoreCheck() {
//        AppConfig appConfig = new AppConfig();
//        LottoRepository lottoRepository = new MemoryLottoRepository();
//        LottoService lottoService = appConfig.lottoService();
//
//        lottoRepository.save(List.of(1, 2, 3, 4, 5, 6));
//        lottoService.setAnswer(new Lotto(List.of(1, 2, 3, 4, 5, 7)), 6);
//
//        lottoService.setScore();
//
//        Assertions.assertThat(lottoService.countMatch(Match.SECOND)).isEqualTo(1);
//    }
//
//    @DisplayName("보너스 번호 당첨 x + 5개 일치 시 3등으로 판단한다.")
//    @Test
//    void thirdScoreCheck() {
//        AppConfig appConfig = new AppConfig();
//        LottoRepository lottoRepository = new MemoryLottoRepository();
//        LottoService lottoService = appConfig.lottoService();
//
//        lottoRepository.save(List.of(1, 2, 3, 4, 5, 6));
//        lottoService.setAnswer(new Lotto(List.of(1, 2, 3, 4, 5, 7)), 8);
//
//        Assertions.assertThat(lottoService.countMatch(Match.THIRD)).isEqualTo(1);
//    }

}
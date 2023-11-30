package lotto;

import lotto.domain.Lotto;
import lotto.domain.Winning;
import lotto.domain.WinningDto;
import lotto.repository.LottoRepository;
import lotto.repository.WinningRepository;
import lotto.service.LottoService;
import lotto.service.Validation;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    private Validation validation;
    private LottoRepository lottoRepository;
    private WinningRepository winningRepository;
    private LottoService lottoService;

    @BeforeEach
    void beforeEach() {
        validation = new Validation();
        lottoRepository = new LottoRepository();
        winningRepository = new WinningRepository();
        lottoService = new LottoService(lottoRepository, winningRepository, validation);
    }

    @AfterEach
    void afterEach() {
        lottoRepository.clear();
        winningRepository.clear();
    }


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

    @DisplayName("로또 번호에 1에서 45사이 숫자가 아닌 숫자가 들어있으면 예외가 발생한다.")
    @Test
    void createLottoByOutRangeNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호의 개수가 6개를 넘어가면 예외가 발생한다.")
    @Test
    void createWinningByOverSize() {
        assertThatThrownBy(() -> new Winning(List.of(1, 2, 3, 4, 5, 6, 7), 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 1에서 45사이의 숫자가 아닌 숫자가 들어있으면 예외가 발생한다.")
    @Test
    void createWinningByOutRangeNumber() {
        assertThatThrownBy(() -> new Winning(List.of(1, 2, 3, 4, 5, 46), 7))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Winning(List.of(0, 2, 3, 4, 5, 6), 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복되는 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinningByDuplicatedNumber() {
        assertThatThrownBy(() -> new Winning(List.of(1, 2, 3, 4, 5, 5), 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호에 1에서 45사이의 숫자가 아닌 숫자가 들어있으면 예외가 발생한다.")
    @Test
    void createWinningByOutRangeBonusNumber() {
        assertThatThrownBy(() -> new Winning(List.of(1, 2, 3, 4, 5, 6), 0))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Winning(List.of(1, 2, 3, 4, 5, 6), 46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호에 당첨번호와 중복되는 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinningByDuplicatedBonusNumber() {
        assertThatThrownBy(() -> new Winning(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 구입금액으로 1000단위의 숫자를 입력하지 않으면 예외가 발생한다.")
    @Test
    void enterPriceByNon1000Digit() {
        assertThatThrownBy(() -> validation.validatePriceAndReturnNumber("a"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> validation.validatePriceAndReturnNumber("8500"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 당첨 번호 개수를 6개 넘게 입력하면 예외가 발생한다.")
    @Test
    void enterWinningByOverLength() {
        assertThatThrownBy(() -> validation.validateWinning("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 당첨 번호를 1에서 45 사이의 숫자가 아닌 숫자를 입력하면 예외가 발생한다.")
    @Test
    void enterWinningByOutRangeNumber() {
        assertThatThrownBy(() -> validation.validateWinning("1,2,3,4,5,46"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> validation.validateWinning("0,2,3,4,5,45"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 당첨 번호로 중복된 숫자를 입력하면 예외가 발생한다.")
    @Test
    void enterWinningByDuplicatedNumber() {
        assertThatThrownBy(() -> validation.validateWinning("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 보너스 번호로 1에서 45 사이의 숫자가 아닌 숫자를 입력하면 예외가 발생한다.")
    @Test
    void enterBonusByOutRangeNumber() {
        assertThatThrownBy(() -> validation.validateBonus("46", List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> validation.validateBonus("0", List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 보너스 번호로 당첨번호와 중복된 숫자를 입력하면 예외가 발생한다.")
    @Test
    void enterBonusByDuplicatedNumber() {
        assertThatThrownBy(() -> validation.validateBonus("6", List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또를 발행하면 LottoRepository에 저장된다.")
    @Test
    void issueLotto() {
        lottoService.issueLotto("8000");
        assertThat(lottoRepository.findAll().size()).isEqualTo(8);
    }

    @DisplayName("당첨를 발행하면 WinningRepository 저장된다.")
    @Test
    void issueWinning() {
        lottoService.issueWinning("1,2,3,4,5,6", "7");
        assertThat(winningRepository.find()).isNotEqualTo(null);
    }

    @DisplayName("당첨 통계에서 몇 개가 일치하는지 올바르게 개수를 센다")
    @Test
    void calculateCoincidenceCount() {

        lottoRepository.save(new Lotto(List.of(40, 41, 42, 43, 44, 45)));
        lottoRepository.save(new Lotto(List.of(1, 41, 42, 43, 44, 45)));
        lottoRepository.save(new Lotto(List.of(1, 2, 42, 43, 44, 45)));
        lottoRepository.save(new Lotto(List.of(1, 2, 3, 43, 44, 45)));
        lottoRepository.save(new Lotto(List.of(1, 2, 3, 4, 44, 45)));
        lottoRepository.save(new Lotto(List.of(1, 2, 3, 4, 5, 44)));
        lottoRepository.save(new Lotto(List.of(1, 2, 3, 4, 5, 45)));
        lottoRepository.save(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        winningRepository.save(new Winning(List.of(1, 2, 3, 4, 5, 6), 45));
        WinningDto winningDto = lottoService.setWinningStatistics();

        assertThat(winningDto.getCountThree()).isEqualTo(1);
        assertThat(winningDto.getCountFour()).isEqualTo(1);
        assertThat(winningDto.getCountFive()).isEqualTo(1);
        assertThat(winningDto.getCountFivePlusBonus()).isEqualTo(1);
        assertThat(winningDto.getCountSix()).isEqualTo(1);
    }

    @DisplayName("당첨 통계에서 수익률을 올바르게 계산한다")
    @Test
    void calculateEarningRate() {

        /**
         * 구매금액 10000원
         * 10개 중에 1개만 3개 일치 -> 당첨금액 5000원
         * 수익률 = 50%
         */
        lottoRepository.save(new Lotto(List.of(37, 38, 39, 40, 41, 42)));
        lottoRepository.save(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottoRepository.save(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottoRepository.save(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottoRepository.save(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottoRepository.save(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottoRepository.save(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottoRepository.save(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottoRepository.save(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottoRepository.save(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        winningRepository.save(new Winning(List.of(40, 41, 42, 43, 44, 45), 1));
        WinningDto winningDto = lottoService.setWinningStatistics();

        assertThat(winningDto.getEarningRate()).isEqualTo(50);
    }
}
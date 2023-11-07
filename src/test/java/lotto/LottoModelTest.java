package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import Model.LottoModel;
import Utils.LottoRank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import java.util.*;

public class LottoModelTest {

    private LottoModel lottoModel;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        lottoModel = new LottoModel();
    }

    @Test
    @DisplayName("당첨 번호를 업데이트 한다")
    void updateWinningLottoNumbers() {
        //given
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        //when
        lottoModel.updateWinningLottoNumbers(winningNumbers);

        //then
        assertEquals(winningNumbers, lottoModel.getWinningLottoNumber());
    }

    @Test
    @DisplayName("보너스 번호를 추가 한다")
    void addBonusNumber() {
        //given
        List<Integer> winningNumbers= new ArrayList<>();

        //when
        lottoModel.updateWinningLottoNumbers(winningNumbers);
        lottoModel.addBonusNumber(7);

        //then
        assertTrue(lottoModel.getWinningLottoNumber().contains(7));
    }

    @Test
    @DisplayName("당첨 통계를 검사 한다")
    void checkWinningStatistics() {
        // given
        LottoModel lottoModel = new LottoModel();
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        lottoModel.setBonusNumber(7);
        lottoModel.updateWinningLottoNumbers(winningNumbers);

        // 수동으로 당첨 Lotto 객체 생성 및 추가
        Lotto winningLotto = new Lotto(winningNumbers);
        lottoModel.addLottoTicket(winningLotto);

        // when
        Map<LottoRank, Integer> statistics = lottoModel.checkWinningStatistics();

        // then
        assertEquals(1, statistics.getOrDefault(LottoRank.FIRST, 0).intValue());
    }

    @Test
    @DisplayName("보너스_번호가_유효한지_검사한다")
    void validateRange() {
        assertThatThrownBy(() -> new LottoModel(49))
                .isInstanceOf(IllegalArgumentException.class);
    }

}

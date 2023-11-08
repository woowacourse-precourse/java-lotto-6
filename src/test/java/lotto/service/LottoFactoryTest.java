package lotto.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.UserLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoFactoryTest {
    private LottoFactory lottoFactory;
    private static final String ERROR = "[ERROR]";
    @BeforeEach
    void setUp() {
        lottoFactory = new LottoFactory();
    }

    @Test
    void 설정한_개수만큼_로또_발행() {
        //given
        int lottoCount = 5;
        //when
        UserLotto userLotto = lottoFactory.createLottos(lottoCount);
        //then
        assertEquals(lottoCount, userLotto.size());
    }

    @Test
    void 입력_받은_번호가_숫자가_아닌_경우_예외_발생() {
        //given
        String inputWinningLottoNumber = "1,2,3,가,5,6";
        //then
        assertThatThrownBy(() -> lottoFactory.makeWinningLotto(inputWinningLottoNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR);
    }

    @Test
    void 입력_받은_번호가_1_이하인_경우_예외_발생() {
        //given
        String inputWinningLottoNumber = "1,2,3,0,5,6";
        //then
        assertThatThrownBy(() -> lottoFactory.makeWinningLotto(inputWinningLottoNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR);
    }

    @Test
    void 입력_받은_번호가_45_이상인_경우_예외_발생() {
        //given
        String inputWinningLottoNumber = "1,2,3,46,5,6";
        //then
        assertThatThrownBy(() -> lottoFactory.makeWinningLotto(inputWinningLottoNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR);
    }

    @Test
    void 입력_받은_번호가_중복되는_경우_예외_발생() {
        //given
        String inputWinningLottoNumber = "1,2,3,3,5,6";
        //then
        assertThatThrownBy(() -> lottoFactory.makeWinningLotto(inputWinningLottoNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR);
    }

    @Test
    void 입력_받은_보너스_번호가_숫자가_아닌_경우_예외_발생() {
        //given
        String inputBonusNumber = "가";
        //then
        assertThatThrownBy(() -> lottoFactory.makeBonusNumber(null, inputBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR);
    }

    @Test
    void 입력_받은_보너스_번호가_1_이하인_경우_예외_발생() {
        //given
        String inputBonusNumber = "0";
        //then
        assertThatThrownBy(() -> lottoFactory.makeBonusNumber(null, inputBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR);
    }

    @Test
    void 입력_받은_보너스_번호가_45_이상인_경우_예외_발생() {
        //given
        String inputBonusNumber = "46";
        //then
        assertThatThrownBy(() -> lottoFactory.makeBonusNumber(null, inputBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR);
    }

    @Test
    void 입력_받은_보너스_번호가_당첨_번호와_중복되는_경우_예외_발생() {
        //given
        String inputBonusNumber = "1";
        Lotto winningLottoNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        //then
        assertThatThrownBy(() -> lottoFactory.makeBonusNumber(winningLottoNumber, inputBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR);
    }
}
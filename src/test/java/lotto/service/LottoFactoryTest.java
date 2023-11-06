package lotto.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

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
        String inputString = "1,2,3,가,5,6";
        //then
        assertThatThrownBy(() -> lottoFactory.makeWinningLotto(inputString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR);
    }

    @Test
    void 입력_받은_번호가_1_이하인_경우_예외_발생() {
        //given
        String inputString = "1,2,3,0,5,6";
        //then
        assertThatThrownBy(() -> lottoFactory.makeWinningLotto(inputString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR);
    }

    @Test
    void 입력_받은_번호가_45_이상인_경우_예외_발생() {
        //given
        String inputString = "1,2,3,46,5,6";
        //then
        assertThatThrownBy(() -> lottoFactory.makeWinningLotto(inputString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR);
    }

    @Test
    void 입력_받은_번호가_중복되는_경우_예외_발생() {
        //given
        String inputString = "1,2,3,3,5,6";
        //then
        assertThatThrownBy(() -> lottoFactory.makeWinningLotto(inputString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR);
    }
}
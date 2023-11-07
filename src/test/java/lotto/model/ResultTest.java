package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.dto.LottoDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultTest {

    private WinningNumber winningNumber;
    private BonusNumber bonusNumber;

    @BeforeEach
    public void setUp() {
        winningNumber = WinningNumber.create("8,29,26,1,45,34");
        bonusNumber = BonusNumber.create("3", winningNumber);
    }

    @DisplayName("6개의 숫자가 다 일치하는 경우 1등이다.")
    @Test
    public void 여섯개가_다_일치하는_경우() {
        //given
        Lotto lotto = new Lotto(List.of(new Integer[]{34, 45, 1, 26, 8, 29}));
        LottoDto lottoDto = LottoDto.create(lotto);

        //when
        Result lottoResult = Result.calculate(lottoDto, winningNumber, bonusNumber);

        //then
        assertThat(lottoResult.getPrize()).isEqualTo(1);
    }
}

package lotto.domain.lotto.lottery;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("로또 번호 랜덤 추첨 도메인")
public class RandomLotteryMachineTest {
    @Test
    @DisplayName("랜덤으로 6개의 숫자를 뽑는다.")
    void Should_Pick_Six_Random_Numbers_When_Generating() {
        //given
        final RandomLotteryMachine machine = new RandomLotteryMachine();
        final int expected = Lotto.LOTTO_SIZE;

        //when
        final List<LottoNumber> lottoNumbers = machine.generate();
        final int actual = lottoNumbers.size();

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("중복되지 않는 숫자를 뽑는다.")
    void Should_Pick_Unique_Numbers_When_Generating() {
        //given
        final RandomLotteryMachine machine = new RandomLotteryMachine();
        final List<LottoNumber> lottoNumbers = machine.generate();
        final int expected = lottoNumbers.size();

        //when
        final Set<LottoNumber> setLottoNumbers = new HashSet<>(lottoNumbers);
        final int actual = setLottoNumbers.size();

        //then
        assertThat(actual).isEqualTo(expected);
    }
}

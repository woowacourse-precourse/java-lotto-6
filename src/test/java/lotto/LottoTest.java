package lotto;

import static lotto.LottoConfig.COUNT;
import static lotto.LottoConfig.END_NUM;
import static lotto.LottoConfig.START_NUM;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @DisplayName("로또 번호가 올바르게 출력되는지 확인한다.")
    @Test
    void lottoSayRightNumber() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        //when
        String said = lotto.sayNumbers();

        //then
        assertThat(said).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @DisplayName("로또 번호 매칭 확인")
    @Test
    void lottoGetsFirstPrize() {
        // given
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(START_NUM, END_NUM, COUNT);
        Lotto lotto = new Lotto(lottoNumbers);

        // when
        LottoPrize prize = lotto.match(lottoNumbers, Randoms.pickNumberInRange(START_NUM, END_NUM));

        // then
        assertThat(prize).isEqualTo(LottoPrize.FIRST);
    }

    @DisplayName("로또 번호 NONE 매칭 확인")
    @Test
    void lottoGetsNoPrize() {
        // given
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_NUM, END_NUM, COUNT * 2);
        List<Integer> lottoNumbers = numbers.subList(0, COUNT);
        List<Integer> winningNumbers = numbers.subList(COUNT, COUNT * 2);
        Lotto lotto = new Lotto(lottoNumbers);

        // when
        LottoPrize prize = lotto.match(winningNumbers, Randoms.pickNumberInRange(START_NUM, END_NUM));

        // then
        assertThat(prize).isEqualTo(LottoPrize.NONE);
    }
}
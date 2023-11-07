package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 toString 값 확인")
    @Test
    public void lotto_toString() throws Exception {
        //given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 7);

        //when
        Lotto lotto = new Lotto(numbers);

        //then
        assertThat(lotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 7]");
    }

    // todo : toString에 의존하는 테스트. getter를 굳이 만들어야 하는지에 대해 고민하고 수정하기
    @DisplayName("로또 넘버 생성 확인")
    @Test
    public void createLotto_from_lottoNumbers() throws Exception {
        //given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 7);
        List<LottoNumber> lottoNumbers = numbers.stream()
                .map(LottoNumber::new)
                .toList();

        //when
        Lotto lotto = Lotto.from(lottoNumbers);

        //then
        assertThat(lotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 7]");
    }
}
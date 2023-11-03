package lotto;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;
import lotto.lotto.Lotto;
import lotto.lotto.LottoNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;

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
    @Test
    @DisplayName("생성기는 1부터 45까지의 랜덤한 숫자를 반환한다")
    void 로또숫자생성기_테스트() {
        //given
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        Set<Integer> createdNumbers = new HashSet<Integer>();
        int count = 0;

        //when
        while (createdNumbers.size() < 45 && count < 1000) {
            List<Integer> lottoNumbers = lottoNumberGenerator.generate();
            lottoNumbers.forEach(num->createdNumbers.add(num));
            count++;
        }

        //then
        Assertions.assertThat(createdNumbers).contains(1,45);
        Assertions.assertThat(createdNumbers.size()).isEqualTo(45);
    }

    @DisplayName("생성기는 중복 숫자를 생성하지 않는다")
    @RepeatedTest(1000)
    void 로또숫자생성기_테스트2(){
        //given
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        List<Integer> lottoNumbers = lottoNumberGenerator.generate();

        //when
        long count = lottoNumbers.stream().distinct().count();

        //then
        Assertions.assertThat(count).isEqualTo(lottoNumbers.size());
    }
}
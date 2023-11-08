package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;

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
    @DisplayName("enum 출력테스트")
    @Test
    void enumTest() {
        List<LottoGrade> lottoCalculatorList =
                Arrays.stream(LottoGrade.values())
                        .filter(lotto -> lotto.getCorrect()==3).toList();
        LottoGrade lottoGrade=lottoCalculatorList.get(0);
        System.out.println(lottoGrade.getName());
        /*Arrays.stream(LottoGrade.values())
                .filter(lotto -> 5 == lotto.getCorrect())
                .forEach(lotto -> System.out.println(lotto.getName()));*/
/*        LottoCalculator test = LottoCalculator.fifth;
        assertThat(test.getPrice()).isEqualTo(5000);
        assertThat(test.getName()).isEqualTo("5등");*/
    }
}
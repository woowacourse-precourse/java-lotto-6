package lotto.model;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import lotto.Application;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest extends NsTest {
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

    @DisplayName("로또 번호의 숫자 범위가 1~45가 아니다.")
    @Test
    void createLottoNumberOneToFortyFive() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 56)))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("로또 번호는 오름차순 정렬된다.")
    @Test
    void sortLottoNumbers() {
        final List<Integer> numbers = new ArrayList<>();
        numbers.add(7);
        numbers.add(5);
        numbers.add(1);
        numbers.add(2);
        numbers.add(4);
        numbers.add(3);
        final Lotto newLotto = new Lotto(numbers);
        System.out.println(newLotto);

        assertThat(output()).contains("[1, 2, 3, 4, 5, 7]");
    }

    @DisplayName("실패 - 로또 번호가 6개의 숫자가 아니다.")
    @Test
    void isNotSizeSix() {
        final List<Integer> numbers = new ArrayList<>();
        numbers.add(7);
        numbers.add(5);
        numbers.add(1);
        numbers.add(2);
        numbers.add(4);

        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호의 개수는 6개이어야 합니다.");
    }
    
    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
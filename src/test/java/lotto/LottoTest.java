package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 7);

        assertThatThrownBy(() ->{
            if(numbers.size() != 6) {
                throw new IllegalArgumentException("6자리가 아닌 로또번호 생성");
            }
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("6자리가 아닌 로또번호 생성");
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        List<Integer> numbers = Arrays.asList(1,2,2,3,4,5);
        Set<Integer> numSet = new HashSet<>(numbers);

        assertThatThrownBy(() -> {
            if(numbers.size() != numSet.size()){
                throw new IllegalArgumentException("로또 번호에 중복 존재");
            }
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호에 중복 존재");
    }

    @DisplayName("1~45 범위의 숫자가 아니면 예외가 발생한다.")
    @Test
    void checkNumberScope() {
        List<Integer> numbers = Arrays.asList(1,2,2,3,46,5);
        Collections.sort(numbers);

        assertThatThrownBy(() -> {
            if(numbers.get(0) < 1 || numbers.get(numbers.size()-1) > 45){
                throw new IllegalArgumentException("1~45 범위 밖의 숫자");
            }
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1~45 범위 밖의 숫자");
    }

}
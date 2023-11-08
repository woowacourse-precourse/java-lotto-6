package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayName("WinningLotto 클래스 로직 테스트")
public class WinningLottoTest {

    @DisplayName("당첨 번호 6자리는 1~45 사이의 번호여야 한다.")
    @Test
    void NumbersInRangeTest(){
        List<Integer> numbers = List.of(1,2,3,4,5,0);
        int bonusNumber = 10;

        Assertions.assertThatThrownBy(() -> new WinningLotto(numbers, new BonusNumber(bonusNumber)));
    }

    @DisplayName("당첨 번호 6자리와 보너스 번호 중 중복되는 번호가 있으면 안된다.")
    @Test
    void duplicateNumberTest(){
        List<Integer> numbers = List.of(3,4,5,6,7);
        int bonusNumber = 7;

        Assertions.assertThatThrownBy(() -> new WinningLotto(numbers, new BonusNumber(bonusNumber)));
    }

    @DisplayName("정상 WinningLotto 객체 생성 테스트")
    @Test
    void normalTest(){
        List<Integer> number = List.of(35,43,7,1,23,39);
        int bonusNumber = 10;

        new WinningLotto(number, new BonusNumber(bonusNumber));
    }

}

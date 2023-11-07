package lotto.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MatchNumberTest {

    @DisplayName("validate 테스트")
    @Test
    void validateTest(){
        assertSimpleTest(()-> {
            MatchNumber matchNumber = new MatchNumber("1,2,3,4,5,6");
            assertThat(matchNumber.getMatchNumbers()).isEqualTo(List.of(1,2,3,4,5,6));
        });
    }

    @DisplayName("입력 값이 숫자 형태가 아닐 시 예외 처리")
    @Test
    void isNumericDataType(){
        assertThatThrownBy(() -> new MatchNumber("1a,23,1,6,43,21"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자 형식에 맞지 않습니다.");
    }

    @DisplayName(" ','를 기준으로 리스트 원소가 6개가 아닐 경우 예외 처리")
    @Test
    void inputOverSize(){
        assertThatThrownBy(() -> new MatchNumber("1,23,12,34,14,45,16"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] ','를 구분자로 6개의 숫자를 입력해 주세요");
    }

    @DisplayName("1에서 45사이의 숫자가 나오지 않으면 예외 발생")
    @Test
    void outBoundRangeLottoNumber(){
        List<Integer> numbers = List.of(1,5,45,6,50,20);
        assertRandomUniqueNumbersInRangeTest(
                ()->{
                    assertThatThrownBy(()->new Lottos(1))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                },
                numbers
        );
    }

}

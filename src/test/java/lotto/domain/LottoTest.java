package lotto.domain;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    private Lotto lotto;
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

    @BeforeEach
    void setUp(){
        lotto = new Lotto(List.of(1,2,3,4,5,6));
    }
    @DisplayName("로또 번호를 출력하는 지 확인한다.")
    @Test
    void printLottoNumbers(){
        //return타입이 void이며, console에 출력되는 내용을 확인하기 위한 설정
        PrintStream standardOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        lotto.printLottoNumbers();
        String result = outputStream.toString();
        String expected = "[1, 2, 3, 4, 5, 6]" + System.lineSeparator();
        assertThat(result).isEqualTo(expected);

        System.setOut(standardOut);
    }

    @DisplayName("당첨번호와 비교하여 일치하는 숫자의 개수를 반환한다.")
    @Test
    void compareWithTheCorrectAnswerTest(){
        List<Integer> answer = List.of(1,2,3,4,5,6);
        //3개일치
        assertThat(new Lotto(List.of(4,5,6,7,8,9)).compareWithTheCorrectAnswer(answer)).isEqualTo(3);
        //4개일치
        assertThat(new Lotto(List.of(3,4,5,6,7,8)).compareWithTheCorrectAnswer(answer)).isEqualTo(4);
    }

    @DisplayName("보너스 번호가 일치하는지 확인한다.")
    @Test
    void compareWithBonusNumber(){
        //일치
        assertThat(lotto.compareWithBonusNumber(1)).isTrue();
        //불일치
        assertThat(lotto.compareWithBonusNumber(7)).isFalse();
    }
}
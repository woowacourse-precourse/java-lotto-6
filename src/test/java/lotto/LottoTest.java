package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능

    @DisplayName("로또 번호를 출력한다.")
    @Test
    void printLottoNumbers() {
        List<Integer> numbers = createLottoNumbers();
        Lotto lotto = new Lotto(numbers);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        lotto.printLottoNumbers();

        String captured = outputStream.toString().trim();
        assertThat(captured).isEqualTo("[1, 2, 3, 4, 5, 6]");
     }

    @DisplayName("맞춘 로또 번호의 갯수를 반환한다.")
    @Test
    void countMatchingLottoNumbers() {
        List<Integer> numbers = createLottoNumbers();
        int bonusNumber = 8;

        Lotto lotto = new Lotto(numbers);
        LottoResult result = new LottoResult(numbers, bonusNumber);

        int count = lotto.countMatchingLottoNumbers(result);

        assertThat(count).isEqualTo(6);
    }

    @DisplayName("보너스 번호가 있는지 판별한다.")
    @Test
    void hasBonusNumber() {
        List<Integer> numbers = createLottoNumbers();
        int bonusNumber = 6;

        Lotto lotto = new Lotto(numbers);
        LottoResult result = new LottoResult(numbers, bonusNumber);

        boolean hasBonusNumber = lotto.hasBonusNumber(result);

        assertThat(hasBonusNumber).isEqualTo(true);
    }

    List<Integer> createLottoNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            numbers.add(i);
        }
        return numbers;
    }
}
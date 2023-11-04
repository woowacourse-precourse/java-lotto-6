package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import lottogenerate.LottoGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
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
    class TestUser {
        public int inputLottoCount(int number) {
            return number / 1000;
        }

        public int[] inputWinningLottoNumber() {
            return new int[]{1, 2, 3, 4, 5, 6};
        }

        public int inputBonusNumber() {
            return 7;
        }
    }

    @Test
    void inputLottoCountTest() {
        // given
        TestUser testUser = new TestUser();
        // when
        int result = testUser.inputLottoCount(5000);

        // then
        assertThat(result).isEqualTo(5);
    }

    @Test
    void inputWinningLottoNumberTest() {
        // given
        TestUser testUser = new TestUser();
        // when
        int[] result = testUser.inputWinningLottoNumber();

        // then
        assertThat(result).isEqualTo(new int[]{1, 2, 3, 4, 5, 6});
    }

    @Test
    void inputBonusNumberTest() {
        // given
        TestUser testUser = new TestUser();
        // when
        int result = testUser.inputBonusNumber();

        // then
        assertThat(result).isEqualTo(7);
    }

    Lotto createLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange
                (1, 45, 6);
        return new Lotto(numbers);
    }

    @Test
    void generateLotto() {
        // given
        TestUser testUser = new TestUser();
        // when
        int result = testUser.inputLottoCount(5000);
        List<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < result; i++) {
            lottoList.add(createLotto());
        }

        // then
        assertThat(lottoList.size()).isEqualTo(5);

        lottoList.forEach(lotto -> {
            List<Integer> lottoNumbers = lotto.getNumbers();
            System.out.println(lottoNumbers.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        });

    }
}


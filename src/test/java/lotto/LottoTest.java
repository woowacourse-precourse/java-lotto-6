package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Judge;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    private User user;
    private List<Lotto> lottos;
    private Lotto answerLotto;
    private List<Integer> lottoNumbers;

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
    void beforeEach(){
        user = new User(1);
        lottos = user.getLottos();
        answerLotto = lottos.get(0);
        lottoNumbers = answerLotto.getNumbers();
    }
    // 아래에 추가 테스트 작성 가능
    @DisplayName("1등 당첨")
    @Test
    void winFirst(){
        int bonusNumber;
        do {
            bonusNumber = Randoms.pickNumberInRange(1, 45);
        } while (lottoNumbers.contains(bonusNumber));
        Judge judge = new Judge(answerLotto, bonusNumber, user, 1000);

        // when
        judge.checkWinning();
        judge.finalResult();
        Assertions.assertThat(Rank.FIRST.getCount()).isGreaterThan(0);
    }
}
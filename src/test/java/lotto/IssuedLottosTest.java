package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import java.util.List;
import lotto.domain.IssuedLotto;
import lotto.domain.IssuedLottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class IssuedLottosTest {
    @DisplayName("무작위 번호 6개의 로또 2개를 group에 저장한다.")
    @Test
    void createAutoLottoNumbers() {
        IssuedLotto lotto1 = new IssuedLotto(List.of(1, 2, 3, 4, 5, 6));
        IssuedLotto lotto2 = new IssuedLotto(List.of(7, 8, 9, 10, 11, 12));

        assertThatCode(() -> new IssuedLottos(List.of(lotto1, lotto2),2))
                .doesNotThrowAnyException();
    }

    @DisplayName("예상한 로또 번호가 맞는지 확인한다.")
    @Test
    void findAllLottoNumbers(){
        IssuedLotto lotto1 = new IssuedLotto(List.of(1, 2, 3, 4, 5, 6));
        IssuedLotto lotto2 = new IssuedLotto(List.of(7, 8, 9, 10, 11, 12));
        IssuedLottos issuedLottos = new IssuedLottos(List.of(lotto1, lotto2), 2);

        List<Integer> User_Lotto_Group_1 = issuedLottos.find_issued_lotto_by_index(0);

        assertThat(User_Lotto_Group_1).isEqualTo(lotto1.findAll());
    }
}

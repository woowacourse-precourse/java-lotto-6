package lotto;

import lotto.model.LottoResult;
import lotto.model.User;
import lotto.model.WinningNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {
    Lotto lotto1;
    Lotto lotto2;
    Lotto lotto3;
    List<Lotto> lottoList;

    @BeforeEach
    void setUp() {
        lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        lotto3 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        lottoList = List.of(lotto1, lotto2, lotto3);
    }

    @DisplayName("유저는 로또를 살 때 생성된다.")
    @Test
    void givenLottoList_whenCreate_thenSuccess() {

        //When
        User user = User.of(lottoList);
        //Then
        assertThat(user).isNotNull();
    }


    @DisplayName("가지고 있는 로또들의 당첨여부를 확인한다.")
    @Test
    void givenLottoswhentoLottoTypesThenSuccess() {
        //Given
        User user = User.of(lottoList);
        WinningNumbers winningNumbers = WinningNumbers.of(List.of(1, 2, 3, 4, 5, 6), 7);
        //When
        List<LottoResult> lottoTypes = user.checkLottosResult(winningNumbers);
        //Then
        assertThat(lottoTypes).isNotNull();
    }
}

package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import lotto.constant.LottoPrize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {
    @DisplayName("보너스 번호에 당첨 번호와 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void WinningLotto_생성_테스트_당첨_번호에_보너스_번호와_중복되는_숫자가_있는_경우() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 5;

        assertThatThrownBy(() -> new WinningLotto(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입한 복권 번호와 당첨 번호를 비교하여 등수에 맞는 LottoPrize 객체를 반환해야 한다. 각 등수 별로 잘 반환되지 않으면 예외가 발생한다.")
    @Test
    void compare_테스트() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);

        List<Lotto> purchased = new ArrayList<>() {{
            add(new Lotto(List.of(2, 3, 4, 5, 6, 1))); // 1등 복권
            add(new Lotto(List.of(2, 3, 4, 5, 6, 7))); // 2등 복권
            add(new Lotto(List.of(2, 3, 4, 5, 6, 10))); // 3등 복권
            add(new Lotto(List.of(2, 3, 4, 5, 10, 11))); // 4등 복권
            add(new Lotto(List.of(2, 3, 4, 10, 11, 12))); // 5등 복권
            add(new Lotto(List.of(12, 13, 14, 15, 16, 17)));    // 꽝
        }};

        List<LottoPrize> expected = new ArrayList<>() {{
            add(LottoPrize.FIRST);
            add(LottoPrize.SECOND);
            add(LottoPrize.THIRD);
            add(LottoPrize.FOURTH);
            add(LottoPrize.FIFTH);
            add(LottoPrize.NOTHING);
        }};

        for (int i = 0; i < purchased.size(); i++) {
            assertThat(winningLotto.compare(purchased.get(i)))
                    .isEqualTo(expected.get(i));
        }
    }
}

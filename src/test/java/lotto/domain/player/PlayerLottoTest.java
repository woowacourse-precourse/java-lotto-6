package lotto.domain.player;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoPrize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerLottoTest {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        PlayerLotto playerLotto = PlayerLotto.from(createLottos());
    }

    @DisplayName("알 수 없는 로또 목록으로 사용자 로또를 생성할 수 없다.")
    @Test
    void checkLottosNonNull() {
        assertThatThrownBy(() -> PlayerLotto.from(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("알 수 없는 로또 목록으로 사용자 로또를 생성할 수 없습니다.");
    }

    @DisplayName("알 수 없는 로또가 포함된 로또 목록으로 사용자 로또를 생성할 수 없다.")
    @Test
    void checkLottosNullIncluded() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(Lotto.from(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(null);

        assertThatThrownBy(() -> PlayerLotto.from(lottos))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("알 수 없는 로또가 포함된 로또 목록으로 사용자 로또를 생성할 수 없습니다.");
    }

    @DisplayName("사용자의 당첨 통계를 생성할 수 있다.")
    @Test
    void generateStatistics() {
        PlayerLotto playerLotto = PlayerLotto.from(createLottos());
        EnumMap<LottoPrize, Integer> expected = new EnumMap<>(LottoPrize.class);
        for (LottoPrize prize : LottoPrize.values()) {
            expected.put(prize, 0);
        }
        expected.put(LottoPrize.FIRST, 1);
        expected.put(LottoPrize.SECOND, 1);
        expected.put(LottoPrize.THIRD, 1);

        EnumMap<LottoPrize, Integer> result =
                playerLotto.generateStatistics(createAnswerLotto(), LottoNumber.from(7));

        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("정답 로또에 보너스 번호가 이미 포함되어 있을 수 없다.")
    @Test
    void checkAnswerBonusIncluded() {
        PlayerLotto playerLotto = PlayerLotto.from(createLottos());

        assertThatThrownBy(() -> playerLotto.generateStatistics(createAnswerLotto(), LottoNumber.from(4)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("정답 로또에 이미 포함된 번호는 보너스 번호로 사용할 수 없습니다.");
    }

    @DisplayName("정답 로또에 보너스 번호가 이미 포함되어 있을 수 없다.")
    @Test
    void checkAnswerNonNull() {
        PlayerLotto playerLotto = PlayerLotto.from(createLottos());

        assertThatThrownBy(() -> playerLotto.generateStatistics(null, LottoNumber.from(4)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효한 정답 로또를 입력해주세요.");
    }

    private static Lotto createAnswerLotto() {
        return Lotto.from(List.of(1, 2, 3, 4, 5, 6));
    }

    private static List<Lotto> createLottos() {
        return List.of(
                Lotto.from(List.of(1, 2, 3, 4, 5, 6)),
                Lotto.from(List.of(1, 2, 3, 4, 5, 7)),
                Lotto.from(List.of(1, 2, 3, 4, 5, 8))
        );
    }
}

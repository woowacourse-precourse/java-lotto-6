package lotto.model;

import lotto.domain.Lotto;
import lotto.domain.LottoMatch;
import lotto.dto.LottoMatchCountDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static lotto.domain.LottoMatch.FIFTH_PLACE;
import static lotto.domain.LottoMatch.FIRST_PLACE;
import static lotto.domain.LottoMatch.NON_PLACE;
import static lotto.domain.LottoMatch.THIRD_PLACE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoModelTest {
    private LottoModel lottoModel;

    @BeforeEach
    void setUp() {
        lottoModel = new LottoModel();
    }

    @DisplayName("로또 번호들의 결과를 리스트로 담아서 반환한다.")
    @Test
    void getLottoMatchesTest() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 10, 11, 12));
        Lotto lotto3 = new Lotto(List.of(1, 2, 9, 10, 11, 12));
        Lotto lotto4 = new Lotto(List.of(1, 13, 9, 10, 11, 12));
        Lotto lotto5 = new Lotto(List.of(1, 8, 9, 10, 11, 12));
        Lotto lotto6 = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        List<Lotto> lottos = List.of(lotto, lotto2, lotto3, lotto4, lotto5, lotto6);

        List<Integer> winningNumbers = List.of(7, 13, 9, 10, 11, 12);
        int bonusNumber = 8;

        List<LottoMatch> response = List.of(NON_PLACE, LottoMatch.FIFTH_PLACE, LottoMatch.FOURTH_PLACE, THIRD_PLACE, LottoMatch.SECOND_PLACE, FIRST_PLACE);

        // when
        List<LottoMatch> result = lottoModel.getLottoMatches(lottos, winningNumbers, bonusNumber);

        // then
        assertThat(result).isEqualTo(response);
    }

    @DisplayName("구매한 로또 번호의 결과로 나온 개수를 반환할 수 있다.")
    @Test
    void getLottoMatchCountTest() {
        // given
        List<LottoMatch> lottoMatches = List.of(NON_PLACE, NON_PLACE, NON_PLACE, THIRD_PLACE, THIRD_PLACE, FIRST_PLACE);
        LottoMatchCountDto response = new LottoMatchCountDto(3, 0, 0, 2, 0, 1);

        // when
        LottoMatchCountDto result = lottoModel.getLottoMatchCount(lottoMatches);

        // then
        assertThat(result).isEqualTo(response);
    }

}

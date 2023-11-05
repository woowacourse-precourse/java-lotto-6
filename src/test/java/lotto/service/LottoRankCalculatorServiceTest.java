package lotto.service;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoRank;
import lotto.domain.WinningNumbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("로또 등수 리스트 테스트")
class LottoRankCalculatorServiceTest {


    @DisplayName("로또 리스트를 전달해서 등수리스트를 반환받는 메서드 테스트")
    @Test
    void testLottoRankList() {
        Lotto winningLotto = createLotto(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = LottoNumber.from(15);
        WinningNumbers winningNumbers = WinningNumbers.of(winningLotto, bonusNumber);

        Lotto issuedLotto2 = createLotto(List.of(1, 2, 3, 4, 5, 6)); //1등
        Lotto issuedLotto1 = createLotto(List.of(1, 2, 3, 4, 5, 15)); //2등
        Lotto issuedLotto3 = createLotto(List.of(1, 2, 3, 4, 5, 11)); //3등
        Lotto issuedLotto4 = createLotto(List.of(1, 2, 3, 5, 9, 10)); //4등
        Lotto issuedLotto5 = createLotto(List.of(1, 2, 3, 17, 18, 19)); //5등
        Lotto issuedLotto6 = createLotto(List.of(7, 8, 9, 10, 11, 12)); //NONE
        Lotto issuedLotto7 = createLotto(List.of(7, 8, 9, 10, 11, 12)); //NONE
        List<Lotto> lottos = List.of(issuedLotto1, issuedLotto2, issuedLotto3, issuedLotto4, issuedLotto5,
                issuedLotto6, issuedLotto7);

        LottoRankCalculatorService lottoRankCalculatorService = new LottoRankCalculatorService();
        List<LottoRank> ranks = lottoRankCalculatorService.calculateRanks(lottos, winningNumbers);
        Assertions.assertThat(ranks)
                .containsExactlyInAnyOrder(LottoRank.FIRST, LottoRank.SECOND, LottoRank.THIRD, LottoRank.FOURTH,
                        LottoRank.FIFTH,
                        LottoRank.NONE, LottoRank.NONE);
    }

    private Lotto createLotto(List<Integer> numbers) {
        List<LottoNumber> lottoNumbers = numbers.stream()
                .map(LottoNumber::from)
                .collect(Collectors.toList());
        return Lotto.from(lottoNumbers);
    }
}
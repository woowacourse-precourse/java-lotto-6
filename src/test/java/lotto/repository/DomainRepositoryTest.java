package lotto.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningCombination;
import lotto.domain.WinningNumbers;
import lotto.domain.WinningResult;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

@DisplayName("도메인 저장소 클래스에")
class DomainRepositoryTest {

    private final DomainRepository domainRepository = new DomainRepository();

    @DisplayName("로또를 저장한 후 조회하면 정상 조회가 된다.")
    @Test
    void saveAndGetLottos() {
        // given
        final Lottos expected = new Lottos(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))));

        // when
        domainRepository.saveLottos(expected);
        final Lottos result = domainRepository.getLottos();

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("구입 금액을 저장한 후 조회하면 정상 조회가 된다.")
    @Test
    void saveAndGetPurchaseAmount() {
        // given
        final PurchaseAmount expected = new PurchaseAmount(1000);

        // when
        domainRepository.savePurchaseAmount(expected);
        final PurchaseAmount result = domainRepository.getPurchaseAmount();

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("당첨번호 조합을 저장한 후 조회하면 정상 조회가 된다.")
    @Test
    void saveAndGetWinningCombination() {
        // given
        final WinningCombination expected =
                new WinningCombination(
                        new WinningNumbers(List.of(1, 2, 3, 4, 5, 6)), new BonusNumber(7));

        // when
        domainRepository.saveWinningCombination(expected);
        final WinningCombination result = domainRepository.getWinningCombination();

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("당첨 결과를 저장한 후 조회하면 정상 조회가 된다.")
    @Test
    void saveAndGetWinningResult() {
        // given
        final WinningResult expected = new WinningResult(Map.of());

        // when
        domainRepository.saveWinningResult(expected);
        final WinningResult result = domainRepository.getWinningResult();

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("저장없이 조회하면 예외를 던진다.")
    @Test
    void getWithoutSave() {
        // given
        // when
        // then
        assertThatThrownBy(domainRepository::getLottos).isInstanceOf(IllegalStateException.class);
    }
}

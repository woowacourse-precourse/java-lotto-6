package lotto.domain.lottery;

import lotto.domain.prize.MatchingResult;
import lotto.domain.prize.Prize;
import lotto.fixture.BuyerFixture;
import lotto.fixture.NumberFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.fixture.BuyerFixture.VALID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("[Domain Layer] Lottos")
class LottosTest {

    @Nested
    @DisplayName("[from] 정적 팩토리 메소드 / 생성자 테스트")
    class from {

        @Test
        @DisplayName("[Success] 정상적인 Buyer 인자로 객체 생성 성공")
        void Should_Success_When_Valid() {
            // given
            BuyerFixture valid = VALID;
            // when && then
            Buyer buyer = assertDoesNotThrow(valid::toEntity);
        }
    }

    @Nested
    @DisplayName("[generateMatchingResultList] 로또 리스트 일급 컬렉션과 결과 로또를 순회하며 비교해 결과 리스트 생성에 성공합니다")
    class generateMatchingResultList {

        @Test
        @DisplayName("[Success] 정상적인 인자로 결과 리스트 생성 성공")
        void Should_Success_When_Valid() {
            // given
            Buyer buyer = VALID.toEntity();
            Prize prize = NumberFixture.VALID.toPrizeEntity();
            Lottos generatedLottos = Lottos.from(buyer);
            // when && then
            List<MatchingResult> matchingResults = generatedLottos.generateMatchingResultList(prize);

            assertThat(matchingResults)
                    .hasSameSizeAs(generatedLottos.getLottoTickets());
        }
    }
}

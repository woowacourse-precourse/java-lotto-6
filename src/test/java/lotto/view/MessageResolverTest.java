package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("메시지 리졸버 테스트")
class MessageResolverTest {

    @DisplayName("구매 정보 문자열을 올바르게 만든다")
    @Test
    void testPurchaseMessageResolve() {

        Lotto issuedLotto1 = createLotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto issuedLotto2 = createLotto(List.of(2, 3, 4, 5, 6, 7));
        List<Lotto> lottos = List.of(issuedLotto1, issuedLotto2);

        MessageResolver messageResolver = new MessageResolver();
        String message = messageResolver.resolvePurchasedInformationMessage(lottos);
        String expected = "2개를 구매했습니다.\n[1, 2, 3, 4, 5, 6]\n[2, 3, 4, 5, 6, 7]";
        assertThat(message.trim()).isEqualTo(expected.trim());
    }

    @DisplayName("당첨 통계 문자열을 올바르게 만든다")
    @Test
    void testResultMessageResolve() {
        EnumMap<LottoRank, Integer> countByRanks = new EnumMap<>(LottoRank.class);
        countByRanks.put(LottoRank.FIRST, 2);
        LottoResult result = LottoResult.from(countByRanks);
        MessageResolver messageResolver = new MessageResolver();
        String message = messageResolver.resolveResultMessage(result);
        String expected = "3개 일치 (5,000원) - 0개\n4개 일치 (50,000원) - 0개\n5개 일치 (1,500,000원) - 0개\n5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n6개 일치 (2,000,000,000원) - 2개";
        assertThat(message.trim()).isEqualTo(expected.trim());
    }

    @DisplayName("수익율 문자열을 올바르게 만든다")
    @Test
    void testProfitRateMessageResolve() {
        MessageResolver messageResolver = new MessageResolver();
        String message = messageResolver.resolveProfitRateMessage(95.5);
        assertThat(message).isEqualTo("총 수익률은 95.5%입니다");
    }

    private Lotto createLotto(List<Integer> numbers) {

        List<LottoNumber> lottoNumbers = numbers.stream()
                .map(LottoNumber::from)
                .collect(Collectors.toList());
        return Lotto.from(lottoNumbers);
    }
}
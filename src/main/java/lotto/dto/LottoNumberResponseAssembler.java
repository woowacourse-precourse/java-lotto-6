package lotto.dto;

import lotto.domain.lottery.Buyer;
import lotto.domain.lottery.Lotto;
import lotto.domain.lottery.Lottos;

import java.util.List;

import static java.util.stream.Collectors.joining;
import static lotto.view.constants.PrintSymbol.DELIMITER_WITH_SPACE;

public class LottoNumberResponseAssembler {
    public static LottoNumberResponses createLottoResponses(
            final Buyer buyer,
            final Lottos lottos
    ) {
        int ticketCount = buyer.getTicketCount();

        List<Lotto> lottoList = lottos.getLottos();
        List<LottoNumberResponse> lottoResponses =
                lottoList.stream()
                        .map(LottoNumberResponseAssembler::createLottoResponse)
                        .toList();

        return new LottoNumberResponses(ticketCount, lottoResponses);
    }

    private static LottoNumberResponse createLottoResponse(final Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();

        String parsedNumbers = numbers.stream()
                .map(Object::toString)
                .collect(joining(DELIMITER_WITH_SPACE.getValue()));

        return new LottoNumberResponse(parsedNumbers);
    }
}

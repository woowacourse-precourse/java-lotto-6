package lotto.dto;

import lotto.domain.lottery.Buyer;
import lotto.domain.lottery.Lotto;
import lotto.domain.lottery.Lottos;
import lotto.view.constants.PrintSymbol;

import java.util.List;

import static java.util.stream.Collectors.joining;
import static lotto.view.constants.PrintSymbol.DELIMITER_WITH_SPACE;

public class DtoAssembler {
    public static LottoResponses createLottoResponses(
            final Buyer buyer,
            final Lottos lottos
    ) {
        int ticketCount = buyer.getTicketCount();

        List<Lotto> lottoList = lottos.getLottos();
        List<LottoResponse> lottoResponses =
                lottoList.stream()
                        .map(DtoAssembler::createLottoResponse)
                        .toList();

        return new LottoResponses(ticketCount, lottoResponses);
    }

    private static LottoResponse createLottoResponse(final Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();

        String parsedNumbers = numbers.stream()
                .map(Object::toString)
                .collect(joining(DELIMITER_WITH_SPACE.getValue()));

        return new LottoResponse(parsedNumbers);
    }
}

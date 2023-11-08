package lotto.view;

import java.util.Set;
import java.util.stream.Collectors;
import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.model.LottoTicket;

public class LottoTicketStringBuilder {

    public static String build(LottoTicket lottoTicket) {
        return lottoTicket.getLottoTicket()
            .stream()
            .map(Lotto::getLottoNumbers)
            .map(LottoTicketStringBuilder::getNumbers)
            .collect(Collectors.joining("\n"));
    }

    private static String getNumbers(Set<LottoNumber> lottoNumbers) {
        return lottoNumbers.stream()
            .map(LottoNumber::number)
            .toList()
            .toString();
    }
}

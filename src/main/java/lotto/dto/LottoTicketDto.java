package lotto.dto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTicketDto {
    private List<Integer> lottoNumbers;

    public LottoTicketDto(LottoTicket lottoTicket) {
        List<Integer> numbers = lottoTicket.getLottoNumbers().stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toList());
        this.lottoNumbers = numbers;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

}

package lotto.dto;

import java.util.List;

public record IssuedLottoTicketsDto(
        int numberOfLottoIssued, List<LottoDto> tickets
) {
}

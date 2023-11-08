package lotto.view;

import lotto.dto.IssuedLottoTicketsDto;
import lotto.dto.ResultDto;

public interface View {
    void displayException(String message);

    String getPurchaseAmount();

    String getWinningNumbers();

    String getBonusNumber();

    void displayIssuedLottoTickets(IssuedLottoTicketsDto issuedLottoTickets);

    void displayResult(ResultDto resultDto);
}

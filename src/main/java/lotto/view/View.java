package lotto.view;

import lotto.dto.IssuedLottoTicketsDto;

public interface View {
    String getPurchaseAmount();

    String getWinningNumbers();

    String getBonusNumber();

    void displayIssuedLottoTickets(IssuedLottoTicketsDto issuedLottoTickets);


    void displayException(String message);
}

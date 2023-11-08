package mytest;

import lotto.model.LottoTicketEntity;
import lotto.service.MatchingNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MatchingNumberTest {
    private MatchingNumber matchingNumber;
    @BeforeEach
    void setUp() {
        List<LottoTicketEntity> lottoTickets = new ArrayList<>();
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        LottoTicketEntity lottoTicketEntity1 = new LottoTicketEntity();
        lottoTicketEntity1.setLottoNumbers(List.of(1, 2, 3, 4, 5, 6));
        LottoTicketEntity lottoTicketEntity2 = new LottoTicketEntity();
        lottoTicketEntity2.setLottoNumbers(List.of(1, 2, 3, 4, 5, 7));
        LottoTicketEntity lottoTicketEntity3 = new LottoTicketEntity();
        lottoTicketEntity3.setLottoNumbers(List.of(1, 2, 3, 4, 5, 8));

        lottoTickets.add(lottoTicketEntity1);
        lottoTickets.add(lottoTicketEntity2);
        lottoTickets.add(lottoTicketEntity3);

        matchingNumber = new MatchingNumber(lottoTickets, winningNumbers, bonusNumber);
    }
    @Test
    void getMatchingNumberTest() {
        Map<String, Integer> lottoRank = matchingNumber.getLottoRankList();

        assertEquals(1, lottoRank.get("1등"));
        assertEquals(1, lottoRank.get("2등"));
        assertEquals(1, lottoRank.get("3등"));
        assertEquals(0, lottoRank.get("4등"));
        assertEquals(0, lottoRank.get("5등"));
    }
}

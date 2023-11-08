package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Buyer;
import lotto.model.Lotto;
import lotto.model.WinningCondition;
import lotto.validation.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

import static lotto.constant.SystemData.*;
import static lotto.model.WinningCondition.RANK_3;
import static lotto.model.WinningCondition.RANK_5;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BuyerTest {
    @DisplayName("구매 금액과 우승 상금을 통해 수익률을 계산한다.")
    @Test
    void check_calculate_total_profit_rate() {
        int purchaseAmount = 8000;

        ArrayList<Lotto> lottoTickets = new ArrayList<>();
        lottoTickets.add(new Lotto(List.of(8, 21, 23, 41, 42, 43)));
        lottoTickets.add(new Lotto(List.of(3, 5, 11, 16, 32, 38)));
        lottoTickets.add(new Lotto(List.of(7, 11, 16, 35, 36, 44)));
        lottoTickets.add(new Lotto(List.of(1, 8, 11, 31, 41, 42)));
        lottoTickets.add(new Lotto(List.of(13, 14, 16, 38, 42, 45)));
        lottoTickets.add(new Lotto(List.of(7, 11, 30, 40, 42, 43)));
        lottoTickets.add(new Lotto(List.of(2, 13, 22, 32, 38, 45)));
        lottoTickets.add(new Lotto(List.of(1, 3, 5, 14, 22, 45)));

        int[] winningNumbers = new int[]{1,2,3,4,5,6};
        int bonusNumber = 7;

        Buyer buyer = new Buyer(purchaseAmount, lottoTickets);
        buyer.computeLottoResults(winningNumbers, bonusNumber);
        float expectedRate = RANK_5.winningAmount() / (float) purchaseAmount * 100;

        assertEquals(expectedRate, buyer.getTotalProfitRate());
    }

    @DisplayName("입력한 로또 티켓의 개수를 올바르게 반환한다.")
    @Test
    void check_lotto_ticket_count() {
        int purchaseAmount = Randoms.pickNumberInRange(1, 9) * 1000;

        ArrayList<Lotto> lottoTickets = new ArrayList<>();
        List<List<Integer>> expectedLottoTicketNumbers = new ArrayList<>();

        for(int i=0; i<purchaseAmount / 1000; i++){
            List<Integer> lottoNumbers = new ArrayList<>(
                    Randoms.pickUniqueNumbersInRange(MIN_IN_LOTTO_NUMBER, MAX_IN_LOTTO_NUMBER, NUMBER_OF_WINNING_NUMBER)
            );
            lottoTickets.add(new Lotto(lottoNumbers));
        }

        Buyer buyer = new Buyer(purchaseAmount, lottoTickets);

        assertEquals(purchaseAmount / 1000, buyer.getLottoTicketCount());
    }
}

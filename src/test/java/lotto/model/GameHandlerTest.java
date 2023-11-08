package lotto.model;

import static lotto.model.domain.Rank.FIFTH_RANK;
import static lotto.model.domain.Rank.FIRST_RANK;
import static lotto.model.domain.Rank.FOURTH_RANK;
import static lotto.model.domain.Rank.SECOND_RANK;
import static lotto.model.domain.Rank.THIRD_RANK;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.EnumMap;
import lotto.model.domain.Lotto;
import lotto.model.domain.Rank;
import lotto.model.domain.WinningTicket;
import lotto.model.handler.GameHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;


public class GameHandlerTest {

    @DisplayName("당첨로또 생성 테스트")
    @Test
    void createWinningTicket() {
        GameHandler gameHandler = new GameHandler();

        WinningTicket winningTicket = gameHandler.createWinningTicket(List.of(1, 2, 3, 4, 5, 6), 8);

        assertThat(winningTicket.getWinningNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
        assertThat(winningTicket.getBonusNumber()).isEqualTo(8);
    }

    @DisplayName("당첨계산 기능 테스트")
    @Test
    void calculateRank() {
        GameHandler gameHandler = new GameHandler();
        WinningTicket winningTicket = gameHandler.createWinningTicket(List.of(1, 2, 3, 4, 5, 6), 8);

        EnumMap<Rank, Integer> rank = gameHandler.calculateRank(List.of(1, 2, 3, 4, 5, 6), winningTicket);
        rank = gameHandler.calculateRank(List.of(1, 2, 3, 4, 5, 6), winningTicket);


        assertThat(rank.get(FIFTH_RANK).equals(1));
        assertThat(rank.get(Rank.THIRD_RANK).equals(1));
    }

    @DisplayName("당첨통계 기능 테스트")
    @Test
    void checkWinningResult() {
        GameHandler gameHandler = new GameHandler();
        WinningTicket winningTicket = gameHandler.createWinningTicket(List.of(1, 2, 3, 4, 5, 6), 8);
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            lottos.add(lotto);
        }

        EnumMap<Rank, Integer> rank = gameHandler.checkWinningResult(lottos, winningTicket);

        assertThat(rank.get(FIFTH_RANK).equals(5));
    }

    @DisplayName("당첨금 수익률 계산 기능 테스트")
    @Test
    void calculatePrizes() {
        GameHandler gameHandler = new GameHandler();
        int purchaseAmount = 8000;

        EnumMap<Rank, Integer> rank = new EnumMap<>(Rank.class);
        rank.put(FIFTH_RANK, 1);
        rank.put(FOURTH_RANK, 0);
        rank.put(THIRD_RANK, 0);
        rank.put(SECOND_RANK, 0);
        rank.put(FIRST_RANK, 0);

        float rateOfReturn = gameHandler.calculatePrizes(purchaseAmount, rank);

        assertThat(rateOfReturn).isEqualTo(62.5f);
    }


}

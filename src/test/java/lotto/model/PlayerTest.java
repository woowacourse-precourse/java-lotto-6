package lotto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void savePaymentAccount() {
        //when
        Player player = new Player();
        int paymentAccount = 10000;
        //given
        player.savePaymentAccount(paymentAccount);
        //then
        assertThat(player.getPaymentAccount()).isEqualTo(paymentAccount);
    }

    @Test
    void receiveWinningAccount() {
        //when
        Player player = new Player();
        int winningAccount = 10000;
        //given
        player.receiveWinningAccount(winningAccount);
        //then
        assertThat(player.getTotalWinningAccount()).isEqualTo(winningAccount);
    }

    @Test
    void calculateRateOfRevenue() {
        //when
        Player player = new Player();
        int paymentAccount = 2000;
        int winningAccount = 10000;

        //given
        player.savePaymentAccount(paymentAccount);
        player.receiveWinningAccount(winningAccount);
        double revenue = player.calculateRateOfRevenue();
        //then
        assertThat(revenue).isEqualTo(500);
    }

    @Test
    void getTotalWinningAccount() {
        //when
        Player player = new Player();
        int winningAccount1 = 10000;
        int winningAccount2 = 2000;
        //given
        player.receiveWinningAccount(winningAccount1);
        player.receiveWinningAccount(winningAccount2);
        int totalWinningAccount = player.getTotalWinningAccount();
        //then
        assertThat(totalWinningAccount).isEqualTo(winningAccount1 + winningAccount2);
    }
}
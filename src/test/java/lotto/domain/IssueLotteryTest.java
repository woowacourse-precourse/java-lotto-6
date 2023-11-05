package lotto.domain;

import org.junit.jupiter.api.Test;

public class IssueLotteryTest {

    @Test
    void 로또를_발행하는_기능_테스트() {
        IssueLottery issueLottery = new IssueLottery();
        System.out.println(issueLottery.issueTickets(7));
    }
}

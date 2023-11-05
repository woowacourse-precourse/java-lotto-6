package lotto.view;

import static lotto.view.constants.ConstantMessage.RESPONSE_PROFIT_RATE;
import static lotto.view.constants.ConstantMessage.RESPONSE_SECOND;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.view.constants.ConstantMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ViewTest {
    @DisplayName("로또 번호 목록을 출력한다.")
    @Test
    void printLotto() {
        int amount = 8;
        List<Lotto> automaticTickets = new ArrayList<>();
        Lotto ticket1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto ticket2 = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        automaticTickets.add(ticket1);
        automaticTickets.add(ticket2);

        OutputView.responsePurchaseAmount(amount, automaticTickets);
    }

    @DisplayName("상수 메시지를 출력한다.")
    @Test
    void printMessage() {
        ConstantMessage.printConstantMessage(RESPONSE_SECOND, 4);
        ConstantMessage.printConstantMessage(RESPONSE_PROFIT_RATE, new BigDecimal("3.15"));
    }
}

package lotto.collaboration;

import java.util.List;
import java.util.stream.IntStream;
import lotto.io.Input;
import lotto.io.Output;

public class Lottos {

    private int purchaseAmount;
    private List<Lotto> purchaseLottos;

    public void purchase() {
        Output.consoleLine("구입금액을 입력해 주세요.");
        // TODO : 천원단위 아닌 경우 예외처리 필요함
        // TODO : 천원 미만인 경우 예외처리 필요함
        purchaseAmount = Input.consoleNumber();
    }

    public void make() {
        int ticketAmount = getTicketAmount();

        purchaseLottos = IntStream.range(0, ticketAmount)
                .mapToObj(i -> Lotto.make())
                .toList();
    }

    private int getTicketAmount() {
        return purchaseAmount / 1000;
    }

}

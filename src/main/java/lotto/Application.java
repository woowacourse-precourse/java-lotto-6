package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Manager lottoManager = new Manager();
        List<Lotto> myLottoTickets = lottoManager.purchaseLottoTickets();
    }
}

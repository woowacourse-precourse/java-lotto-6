package lotto;

import static lotto.LottoGame.issuanceLotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int lottoCnt = 0;

        Output.startMessage();
        lottoCnt = issuanceLotto(Input.money());
        Output.howManyLottoMessage(lottoCnt);

    }
}

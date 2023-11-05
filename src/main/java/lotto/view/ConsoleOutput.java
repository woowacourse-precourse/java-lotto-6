package lotto.view;

import lotto.domain.wrapper.Lotto;
import lotto.handler.OutputHandler;

import java.util.List;

public class ConsoleOutput implements OutputHandler {

    @Override
    public void printInputMoneyMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    @Override
    public void printBuyLottoList(List<Lotto> buyLottos) {
        System.out.println();
        System.out.println(buyLottos.size() + "개를 구매했습니다.");

        for (Lotto buyLotto : buyLottos) {
            System.out.println(buyLotto.sortLottoNumbers());
        }
    }

    @Override
    public void printInputWinningLottoMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    @Override
    public void printInputBonusLottoMessage() {

    }

    @Override
    public void printLottoResult() {

    }

    @Override
    public void printProfit() {

    }
}

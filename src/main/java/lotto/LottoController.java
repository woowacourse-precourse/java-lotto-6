package lotto;

import java.util.List;

public class LottoController {
    Validator validator = new Validator();
    LottoService lottoService = new LottoService();

    static final String INPUT_CASH_MESSAGE = "구입금액을 입력해 주세요.";
    static final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    int inputCash() {
        System.out.println(INPUT_CASH_MESSAGE);
        int cash = lottoService.getInput();

        return cash;
    }

    void showLottoBundle(int cash) {
        int ticket = lottoService.getTicket(cash);

        System.out.printf("%d개를 구매했습니다.\n", ticket);
        List<Lotto> lottos = lottoService.getLottoBundle(ticket);

        for (int i = 0; i < lottos.size(); i++) {
            List<Integer> lotto = lottos.get(i).getNumbers();
            System.out.println(lotto.toString());
        }
    }

    List<Integer> inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
        List<Integer> winningNumbers = lottoService.getInputForNumbers();

        return winningNumbers;
    }


}

package lotto;

import java.util.List;

public class LottoController {
    Validator validator = new Validator();
    LottoService lottoService = new LottoService();

    static final String INPUT_CASH_MESSAGE = "구입금액을 입력해 주세요.";
    static final String INPUT_WINNING_NUMBER_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    static final String INPUT_BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";
    static final String SHOW_LOTTO_BUNDLE_MESSAGE = "개를 구매했습니다.";
    static final String SHOW_RESULT_MESSAGE = "\n당첨통계\n---";

    int inputCash() {
        System.out.println(INPUT_CASH_MESSAGE);
        int cash = lottoService.getInput();

        return cash;
    }

    void showLottoBundle(int ticket, List<Lotto> lottoBundle) {

        System.out.printf(ticket + SHOW_LOTTO_BUNDLE_MESSAGE + "\n");

        for (int i = 0; i < lottoBundle.size(); i++) {
            Lotto lotto = lottoBundle.get(i);
            List<Integer> lottoNumbers = lotto.getNumbers();
            System.out.println(lottoNumbers.toString());
        }
    }

    List<Integer> inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
        List<Integer> winningNumbers = lottoService.getInputForNumbers();

        return winningNumbers;
    }

    int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        int bonusNumber = lottoService.getInput();

        return bonusNumber;
    }

    void showResult() {
        System.out.println(SHOW_RESULT_MESSAGE);
    }
}

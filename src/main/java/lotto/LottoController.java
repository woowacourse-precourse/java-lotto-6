package lotto;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LottoController {
    Validator validator = new Validator();
    LottoService lottoService = new LottoService();

    static final String INPUT_CASH_MESSAGE = "구입금액을 입력해 주세요.";
    static final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    static final String SHOW_LOTTO_BUNDLE_MESSAGE = "개를 구매했습니다.";
    static final String SHOW_RESULT_MESSAGE = "당첨통계";
    static final String SHOW_FIFTH_MESSAGE = "3개 일치 (5,000원)";
    static final String SHOW_FOURTH_MESSAGE = "4개 일치 (50,000원)";
    static final String SHOW_THIRD_MESSAGE = "5개 일치 (1,500,000원)";
    static final String SHOW_SECOND_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원)";
    static final String SHOW_FIRST_MESSAGE = "6개 일치 (2,000,000,000원)";

    int inputCash() {
        System.out.println(INPUT_CASH_MESSAGE);
        int cash = lottoService.getInput();

        return cash;
    }

    void showLottoBundle(int ticket, List<Lotto> lottoBundle) {

        System.out.printf("\n%d%s\n", ticket, SHOW_LOTTO_BUNDLE_MESSAGE);

        for (int i = 0; i < lottoBundle.size(); i++) {
            Lotto lotto = lottoBundle.get(i);
            List<Integer> lottoNumbers = lotto.getNumbers();
            Collections.sort(lottoNumbers);
            System.out.println(lottoNumbers);
        }
    }

    List<Integer> inputWinningNumbers() {
        System.out.printf("\n%s\n", INPUT_WINNING_NUMBER_MESSAGE);
        List<Integer> winningNumbers = lottoService.getInputForNumbers();

        return winningNumbers;
    }

    int inputBonusNumber() {
        System.out.printf("\n%s\n", INPUT_BONUS_NUMBER_MESSAGE);
        int bonusNumber = lottoService.getInput();

        return bonusNumber;
    }

    void showWinningStatistics(int cash, List<Integer> winningNumbers, List<Lotto> lottoBundle) {
        List<Prize> winningStatistics = lottoService.getWinningStatistics(winningNumbers, lottoBundle);
        int fifth = 0;
        int fourth = 0;
        int third = 0;
        int second = 0;
        int first = 0;

        for (int i = 0; i < winningStatistics.size(); i++) {
            Prize prize = winningStatistics.get(i);
            if (prize.name().equals("FIFTH")) {
                fifth++;
            }
            if (prize.name().equals("FOURTH")) {
                fourth++;
            }
            if (prize.name().equals("THIRD")) {
                third++;
            }
            if (prize.name().equals("SECOND")) {
                second++;
            }
            if (prize.name().equals("FIRST")) {
                first++;
            }
        }

        float rateOfReturn = lottoService.getRateOfReturn(cash, winningStatistics);

        System.out.printf("\n%s\n---\n", SHOW_RESULT_MESSAGE);

        System.out.printf("%s - %d개\n", SHOW_FIFTH_MESSAGE, fifth);
        System.out.printf("%s - %d개\n", SHOW_FOURTH_MESSAGE, fourth);
        System.out.printf("%s - %d개\n", SHOW_THIRD_MESSAGE, third);
        System.out.printf("%s - %d개\n", SHOW_SECOND_MESSAGE, second);
        System.out.printf("%s - %d개\n", SHOW_FIRST_MESSAGE, first);

        System.out.printf("총 수익률은 %.1f%%입니다.", rateOfReturn);
    }
}

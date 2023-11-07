package lotto.Service;

import lotto.Domain.LottoSalesman;
import lotto.Domain.Referee;
import lotto.View.InputLottoUI;
import lotto.View.OutputLottoUI;
import lotto.Domain.Lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.View.OutputLottoUI.lottoCountView;

public class GameService {
    int money;
    int lottoCount;
    List<List<Integer>> lottos;
    Referee referee;

    public void setGame() {
        while (true) {
            OutputLottoUI.inputMoneyView();
            money = InputLottoUI.inputMoneyPrint();
            try {
                lottoCount = LottoSalesman.lottoCount(money);
                lottoCountView(lottoCount);
                lottos = LottoSalesman.buyLotto(lottoCount);
                OutputLottoUI.lottoSalse(lottos);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        //TODO 담청 번호 입력과 보너스 번호 입력 while 작성하기.
        // while()은 2개임 잘못된 입력을 받으면 그 부분부터 입력을 다시 받아야 하므로
        // 당첨 번호 입력 while 1개, 보너스 번호 입력 while 1개
        while (true) {
            OutputLottoUI.answerLottoView();

            try {
                List<Integer> answerNumbers = InputLottoUI.inputAnswerLottoPrint();

                if (answerNumbers.size() != 6) {
                    System.out.println("Please enter exactly 6 numbers.");
                    continue; // Continue the loop if the input doesn't contain exactly 6 numbers
                }

                OutputLottoUI.answerBonusNumberView();
                referee = new Referee(answerNumbers, InputLottoUI.inputBonusNumber());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }
    }

}

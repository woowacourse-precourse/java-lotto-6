package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.enums.Messages;
import lotto.generator.LottoGenerator;
import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private static List<Lotto> lottos;
    private static List<Integer> winNumbers;
    private static int bonusNumber;
    private static List<Rank> winLottoRanks;

    public LottoController() {
        lottos = new ArrayList<>();
        winNumbers = new ArrayList<>();
        bonusNumber = 0;
        winLottoRanks = new ArrayList<>();
    }

    public void buyLottos() {
        System.out.println(Messages.INPUT_AMOUNT_MESSAGE.getMessage());
        lottos = LottoGenerator.buyLottos(InputView.intputAmount(Console.readLine()));
        OutputView.printLottos(lottos);
        OutputView.printAskWinNumbers();
        winNumbers = InputView.inputWinNumbers(Console.readLine());
        OutputView.printAstBonusNumbers();
        bonusNumber = InputView.inputBonusNumber(Console.readLine(), winNumbers);
        checkLottos();
        OutputView.printStatistics(winLottoRanks);
        OutputView.printReturnRate(calcReturnRate());
    }

    private int compare(Lotto lotto) {
        int answer = 0;
        for (int winNumber : winNumbers) {
            if (lotto.getNumbers().contains(winNumber)) {
                answer++;
            }
        }
        return answer;
    }

    private void checkLottos() {
        for (Lotto lotto : lottos) {
            int correctNumbersCount = compare(lotto);
            if (correctNumbersCount == 6) {
                winLottoRanks.add(new Rank(1));
                continue;
            }
            if (correctNumbersCount == 5 && lotto.getNumbers().contains(bonusNumber)) {
                winLottoRanks.add(new Rank(2));
                continue;
            }
            if (correctNumbersCount == 5) {
                winLottoRanks.add(new Rank(3));
                continue;
            }
            if (correctNumbersCount == 4) {
                winLottoRanks.add(new Rank(4));
                continue;
            }
            if (correctNumbersCount == 3) {
                winLottoRanks.add(new Rank(5));
            }
        }
    }

    private float calcReturnRate() {
        float answer = 0f;
        for (Rank rank : winLottoRanks) {
            answer += (float) rank.getPrize();
        }
        answer /= (float) lottos.size();
        answer *= (float) 100;
        return answer;
    }
}

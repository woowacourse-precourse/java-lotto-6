package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoStatistic;
import lotto.domain.WinningLotto;
import lotto.service.CalculateWinning;
import lotto.service.InputValidator;
import lotto.service.LottoGenerator;
import lotto.view.LottoView;
import lotto.view.OrderView;
import lotto.view.ResultView;

public class LottoController {
    public static void run() {
        int lottoCount = queryLottoCount();

        List<Lotto> randomLottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            randomLottos.add(LottoGenerator.generateRandomLotto());
        }
        OrderView.printOrderLottos(randomLottos);

        String numbers = queryLottoNumbers();

        WinningLotto winningLotto = tryGenerateWinningLotto(numbers);

        LottoStatistic lottoStatistic = CalculateWinning.generateStatistic(winningLotto, randomLottos);
        ResultView.printLottoStatistic(lottoStatistic);
    }

    private static WinningLotto tryGenerateWinningLotto(String numbers) {
        while (true) {
            try {
                int bonusNumber = queryLottoBonusNumber();
                return LottoGenerator.generateWinningLotto(numbers, bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }
    }

    private static int queryLottoCount() {
        while (true) {
            try {
                String orderPrice = OrderView.askOrderPrice();
                InputValidator.validateOrderPrice(orderPrice);
                return Integer.parseInt(orderPrice) / 1000;
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }
    }

    private static String queryLottoNumbers() {
        while (true) {
            try {
                String numbers = LottoView.askLottoNumbers();
                InputValidator.validateLottoNumbers(numbers);
                return numbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }
    }

    private static int queryLottoBonusNumber() {
        while (true) {
            try {
                String bonus = LottoView.askBonusNumber();
                InputValidator.validateBonusNumber(bonus);
                return Integer.parseInt(bonus);
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }
    }
}

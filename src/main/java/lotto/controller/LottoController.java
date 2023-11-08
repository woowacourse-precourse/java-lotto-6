package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.UserLotto;
import lotto.validate.Validator;
import lotto.view.LottoView;

import java.util.List;
import java.util.stream.Collectors;

public class LottoController {
    private final LottoGenerator lottoGenerator;
    private final LottoView lottoView;

    public LottoController() {
        this.lottoGenerator = new LottoGenerator();
        this.lottoView = new LottoView();
    }

    public void run() {
        int purchaseMoney = inputPurchaseMoney();
        lottoView.printPurchaseCount(purchaseMoney / 1000);
        List<Lotto> lottos = lottoGenerator.generateLottoBundle(purchaseMoney);
        lottoView.printLottoNumbers(lottos);
        List<Integer> winningNumbers = inputWinningNumbers();
        int bonusNumber = inputBonusNumber(winningNumbers);
        UserLotto userLotto = new UserLotto(winningNumbers, bonusNumber, purchaseMoney);
        for (Lotto lotto : lottos) {
            userLotto.getLottoResult().addMatchingCount(lotto.calculateMatchNumber(userLotto), lotto.calculateBonusNumber(userLotto));
        }
        lottoView.printWinningResult(userLotto.getLottoResult());
        lottoView.printProfitRate(userLotto.getLottoResult().calculateProfitRate(purchaseMoney));
    }

    private int inputPurchaseMoney() {
        lottoView.printPurchasePrompt();
        String purchaseMoney = "";
        while (true) {
            try {
                purchaseMoney = Console.readLine();
                Validator.validatePurchaseMoney(purchaseMoney);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println();
        return Integer.parseInt(purchaseMoney);
    }

    private List<Integer> inputWinningNumbers() {
        lottoView.printWinningPrompt();
        String winningNumbers = "";
        while (true) {
            try {
                winningNumbers = Console.readLine();
                Validator.validateWinningNumber(winningNumbers);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println();
        return List.of(winningNumbers.split(",")).stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private int inputBonusNumber(List<Integer> winningNumbers) {
        lottoView.printBonusPrompt();
        String bonusNumber = "";
        while (true) {
            try {
                bonusNumber = Console.readLine();
                Validator.validateBonusNumber(bonusNumber, winningNumbers);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println();
        return Integer.parseInt(bonusNumber);
    }
}

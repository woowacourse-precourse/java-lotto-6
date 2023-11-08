package lotto;

import lotto.OutputManagaer;
import lotto.InputManager;

import lotto.LottoEnum.Prize;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputManagaer outputManager = new OutputManagaer();
        InputManager inputManager = new InputManager();
        NumberGenerator numberGenerator = new NumberGenerator();
        NumberComparing numberComparing;
        RewardCalculator rewardCalculator = new RewardCalculator();

        outputManager.outputMessageInputBudget();
        int budget = inputManager.inputBudget();

        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < budget/1000; i++) {
            List<Integer> numbers = numberGenerator.generateRandomNumbers();

            lottos.add(new Lotto(numbers));
        }

        System.out.println();
        outputManager.outputOwnNumbers(lottos);

        System.out.println();
        outputManager.outputMessageInputWinningNumbers();
        Lotto winningNumber = inputManager.inputWinningNumbers();

        System.out.println();
        outputManager.outputMessageInputBonusWinningNumber();
        int bonusWinningNumber = inputManager.inputBonusWinningNumber(winningNumber);

        numberComparing = new NumberComparing(winningNumber.getNumbers(),bonusWinningNumber);

        List<Prize> prizes = numberComparing.getPrizeResults(lottos);
        int totalReward = rewardCalculator.getTotalReward(prizes);

        System.out.println();
        outputManager.outputResult(prizes, totalReward);
    }
}

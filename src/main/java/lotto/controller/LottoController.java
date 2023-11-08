package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lottos;
import lotto.domain.Player;
import lotto.util.Util;
import lotto.validation.LottoValidation;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private Player player;
    private Lottos lottos;

    public void play() {
        prepareLotto();
        progressLotto();
        calculateLotto();
    }

    private void prepareLotto() {
        player = new Player(getAmount());
        OutputView.printAmount(player.convertToUnit());
        OutputView.printLotteries(player);
    }

    private void progressLotto() {
        List<Integer> winningNumber = getWinningNumber();
        int bonusNumber = getBonusNumber();
        while (true) {
            try {
                LottoValidation.validateIsDuplicatedWiningAndBonusNumber(winningNumber, bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e);
                bonusNumber = getBonusNumber();
            }
        }
        lottos = new Lottos(winningNumber, bonusNumber, player);
    }

    private void calculateLotto() {
        lottos.classifyLottoGrade();
        double totalRate = lottos.calculateTotalRate();
        OutputView.printResult();
        OutputView.printResultList(lottos.getLottoResultWithCount());
        OutputView.printTotalRate(totalRate);
    }

    private int getAmount() {
        try {
            InputView.inputAmount();
            int amount = Util.convertStringToInt(Util.getInputAndCheckIsNumber());
            Util.validateAmount(amount);
            return amount;
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return getAmount();
        }
    }

    private List<Integer> getWinningNumber() {
        try {
            InputView.inputWinningNumber();
            String input = Console.readLine();
            List<Integer> number = Util.convertStringToIntList(input);
            Util.validateWinningNumber(number);
            return number;
        }
        catch (IllegalArgumentException e) {
            System.out.println(e);
            return getWinningNumber();
        }
    }

    private int getBonusNumber() {
        try {
            InputView.inputBonusNumber();
            int number = Util.convertStringToInt(Util.getInputAndCheckIsNumber());
            Util.validateBonusNumber(number);
            return number;
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return getBonusNumber();
        }
    }
}

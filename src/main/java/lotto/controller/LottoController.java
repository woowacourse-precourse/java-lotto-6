package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lottos;
import lotto.domain.Player;
import lotto.validation.LottoValidation;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
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
            int amount = convertStringToInt(getInputAndCheckIsNumber());
            validateAmount(amount);
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
            List<Integer> number = convertStringToIntList(input);
            validateWinningNumber(number);
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
            int number = convertStringToInt(getInputAndCheckIsNumber());
            validateBonusNumber(number);
            return number;
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return getBonusNumber();
        }
    }

    private String getInputAndCheckIsNumber() {
        String input = Console.readLine();
        validateIsNumber(input);
        return input;
    }

    private void validateWinningNumber(List<Integer> winningNumber) {
        LottoValidation.validateIsSize(winningNumber.size());
        LottoValidation.validateIsDuplicated(winningNumber);
        for (Integer num : winningNumber) {
            LottoValidation.validateInRange(num);
        }
    }

    private void validateAmount(int amount) {
        LottoValidation.validateOverStandardUnit(amount);
        LottoValidation.validateIsStandardUnit(amount);
    }

    private void validateIsNumber(String input) {
        LottoValidation.validateIsNumber(input);
    }

    private void validateBonusNumber(int number) {
        LottoValidation.validateInRange(number);
    }

    private int convertStringToInt(String input) {
        return Integer.parseInt(input);
    }

    private List<Integer> convertStringToIntList(String input) {
        List<Integer> result = new ArrayList<>();
        for (String num : input.split(",")) {
            result.add(Integer.parseInt(num));
        }
        return result;
    }
}

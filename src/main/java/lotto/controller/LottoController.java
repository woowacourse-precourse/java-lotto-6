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
        try {
            player = new Player(getAmount());
            OutputView.printAmount(player.convertToUnit());
            OutputView.printLotteries(player);
        }
        catch (IllegalArgumentException e) {
            System.out.println(e);
            prepareLotto();
        }
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
            String input = Console.readLine();
            LottoValidation.validateIsNumber(input);
            return convertStringToInt(input);
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
            String input = Console.readLine();
            LottoValidation.validateIsNumberBonus(input);
            int number = convertStringToInt(input);
            LottoValidation.validateInRange(number);
            return number;
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return getBonusNumber();
        }
    }

    private void validateWinningNumber(List<Integer> winningNumber) {
        LottoValidation.validateIsSize(winningNumber.size());
        LottoValidation.validateIsDuplicated(winningNumber);
        for (Integer num : winningNumber) {
            LottoValidation.validateInRange(num);
        }
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

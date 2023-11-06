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
        try {
            List<Integer> winningNumber = getWinningNumber();
            int bonusNumber = getBonusNumber();
            lottos = new Lottos(winningNumber, bonusNumber, player);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            progressLotto();
        }
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
        InputView.inputWinningNumber();
        String input = Console.readLine();
        return convertStringToIntList(input);
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

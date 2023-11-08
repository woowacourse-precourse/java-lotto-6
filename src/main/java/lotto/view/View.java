package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Buyer;
import lotto.domain.WinningLotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.view.constant.Exception.COST_FORMAT;
import static lotto.view.constant.Exception.LOTTO_FORMAT;
import static lotto.view.constant.Exception.BONUS_FORMAT;

public class View {
    private static final String SPLIT_SYMBOL = ",";
    public void output(String message) {
        System.out.println(message);
    }

    public Buyer inputAndValidateCost() {
        try {
            int cost = formatCost(Console.readLine());
            return new Buyer(cost);
        } catch (IllegalArgumentException e) {
            output(e.getMessage());
            return inputAndValidateCost();
        }
    }

    private int formatCost(String cost) {
        try {
            String costWithoutSpace = cost.replaceAll("\\s+", "");
            return Integer.parseInt(costWithoutSpace);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(COST_FORMAT);
        }
    }

    public WinningLotto inputAndValidateWinningLotto() {
        try {
            List<Integer> input = formatWinningLotto(Console.readLine());
            return new WinningLotto(input);
        } catch (IllegalArgumentException e) {
            output(e.getMessage());
            return inputAndValidateWinningLotto();
        }
    }

    private List<Integer> formatWinningLotto(String match) {
        String inputWithoutSpace = match.replaceAll("\\s+", "");
        String[] matches = inputWithoutSpace.split(SPLIT_SYMBOL);
        try {
            return Arrays.stream(matches)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LOTTO_FORMAT);
        }
    }

    public int inputAndValidateBonus(WinningLotto winningLotto) {
        try {
            int bonus = formatBonus(Console.readLine());
            winningLotto.validateBonus(bonus);
            return bonus;
        } catch (IllegalArgumentException e) {
            output(e.getMessage());
            return inputAndValidateBonus(winningLotto);
        }
    }

    private int formatBonus(String bonus) {
        try {
            return Integer.parseInt(bonus);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(BONUS_FORMAT);
        }
    }
}

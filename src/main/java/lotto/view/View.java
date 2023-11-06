package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.view.constant.Exception.COST_FORMAT;
import static lotto.view.constant.Exception.LOTTO_FORMAT;

public class View {
    private final static String SPLIT_SYMBOL = ",";
    public void output(String message) {
        System.out.println(message);
    }

    public int inputCost() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(COST_FORMAT);
        }
    }

    public List<Integer> inputMatch() {
        try {
            String match = Console.readLine();
            return formatInput(match);
        } catch (IllegalArgumentException e) {
            output(e.getMessage());
            return inputMatch();
        }
    }

    private List<Integer> formatInput(String match) {
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
}

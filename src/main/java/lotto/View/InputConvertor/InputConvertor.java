package lotto.View.InputConvertor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputConvertor {

    public List<Integer> convertWinningNum(String winningNumInput){
        return Arrays.stream(winningNumInput.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public Integer convertLotteryBudget(String lotteryBudgetInput){
        return Integer.parseInt(lotteryBudgetInput);
    }

}

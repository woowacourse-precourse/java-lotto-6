package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        List<Integer> result = Arrays.asList(0, 0, 0, 0, 0, 0);
        PlayerInput input = new PlayerInput();
        Judgement judgement = new Judgement();
        LottoGenerator lottoGenerator = new LottoGenerator();
        ArrayList<List<Integer>> randoms = lottoGenerator.lottoGenerator();
        List<Integer> playerNumber = input.inputLottoNumber();
        int bonus = input.inputBonusNumber();
        for (List<Integer> numbers : randoms) {
            Set<Integer> number = judgement.getCommonNumber(playerNumber, numbers);
            boolean hasBonus = numbers.contains(bonus);
            int index = judgement.getResultIndex(number.size(), hasBonus);
            int value = result.get(index) + 1;
            result.set(index, value);
        }
        judgement.showStatics(result);
        judgement.showEaringRate(result, lottoGenerator.getTime());
    }

}

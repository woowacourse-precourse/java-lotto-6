package lotto.model;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Playing {

    public static List<Lotto> lottos = new ArrayList<>();

    public static void updateLottos(int lottoCnt){
        for (int i = 0; i < lottoCnt; i++) {
            List<Integer> lottoNumbers = getLottoNumbers();
            lottos.add(new Lotto(lottoNumbers));
        }
    }

    private static List<Integer> getLottoNumbers(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public static List<Integer> inputWinningNumbers(){
        String input = Console.readLine();
        List<Integer> winningNumbers = Arrays.asList(input.split(","))
                .stream().map(Integer::parseInt).collect(Collectors.toList());

        return winningNumbers;
    }

    public static Integer inputBonusNumber(){
        Integer bonus = Integer.parseInt(Console.readLine());
        return bonus;
    }

    public static void compareLottosAndWinningNumbers(List<Integer> winningNumbers, Integer bonus){
        for ( Lotto lotto : lottos) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            for (Integer number : lottoNumbers){
                if (winningNumbers.contains(number)){
                    lotto.updateCorrectLottoCnt();
                }
                if (bonus == number){
                    lotto.updateBonus();
                }
            }
        }
    }


}

package lotto.model;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Playing {

    public static List<Lotto> lottos = new ArrayList<>();
    public static List<Integer> winningStatistics = new ArrayList<>(Arrays.asList(0,0,0,0,0));

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

    public static void getWinningStatistics(List<Lotto> lottos){
        for (Lotto lotto : lottos) {
            if (lotto.getCorrectLottoCnt() == 3){
                winningStatistics.add(0, winningStatistics.get(0)+1);
            } else if(lotto.getCorrectLottoCnt() == 4){
                winningStatistics.add(1, winningStatistics.get(1)+1);
            } else if(lotto.getCorrectLottoCnt() == 5 && lotto.isBonus() == false){
                winningStatistics.add(2, winningStatistics.get(2)+1);
            } else if(lotto.getCorrectLottoCnt() == 5 && lotto.isBonus() == true){
                winningStatistics.add(3, winningStatistics.get(3)+1);
            } else if(lotto.getCorrectLottoCnt() == 6){
                winningStatistics.add(4, winningStatistics.get(4)+1);
            }
        }
    }

    public static String getRateOfReturn(Integer inputAmount){
        List<Integer> amount = new ArrayList<>(Arrays.asList(5000,50000,1500000,30000000,2000000000));
        int totalAmount = 0;
        for (int i = 0; i < 5; i++) {
            totalAmount += (amount.get(i) * winningStatistics.get(i));
        }
        double res = (totalAmount / inputAmount) * 100;
        String rateOfReturn = String.format("%.1f", res);

        return rateOfReturn;
    }



}

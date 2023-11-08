package lotto.model;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
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
        List<Integer> lottos = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> sortedLottos = new ArrayList<>(lottos);
        Collections.sort(sortedLottos);
        return sortedLottos;
    }

    public static void compareLottosAndWinningNumbers(List<Integer> winningNumbers, Integer bonus){
        for (Lotto lotto : lottos) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            updateLottoBasedOnWinningNumbers(lotto, lottoNumbers, winningNumbers);
            updateLottoBasedOnBonusNumber(lotto, lottoNumbers, bonus);
        }
    }

    private static void updateLottoBasedOnWinningNumbers(Lotto lotto, List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        for (Integer number : lottoNumbers) {
            if (winningNumbers.contains(number)) {
                lotto.updateCorrectLottoCnt();
            }
        }
    }

    private static void updateLottoBasedOnBonusNumber(Lotto lotto, List<Integer> lottoNumbers, Integer bonus) {
        if (bonus != null && lottoNumbers.contains(bonus)) {
            lotto.updateBonus();
        }
    }

    public static void getWinningStatistics(List<Lotto> lottos){
        for (Lotto lotto : lottos) {
            if (lotto.getCorrectLottoCnt() == 3){
                winningStatistics.set(0, winningStatistics.get(0)+1);
            } else if(lotto.getCorrectLottoCnt() == 4){
                winningStatistics.set(1, winningStatistics.get(1)+1);
            } else if(lotto.getCorrectLottoCnt() == 5 && lotto.isBonus() == false){
                winningStatistics.set(2, winningStatistics.get(2)+1);
            } else if(lotto.getCorrectLottoCnt() == 5 && lotto.isBonus() == true){
                winningStatistics.set(3, winningStatistics.get(3)+1);
            } else if(lotto.getCorrectLottoCnt() == 6){
                winningStatistics.set(4, winningStatistics.get(4)+1);
            }
        }
    }

    public static String getRateOfReturn(Integer inputAmount) {
        List<Integer> amount = Arrays.asList(5000, 50000, 1500000, 30000000, 2000000000);
        int totalAmount = 0;
        for (int i = 0; i < 5; i++) {
            totalAmount += amount.get(i) * winningStatistics.get(i);
        }
        double rate = 0;
        if (inputAmount != 0) {
            rate = (double) totalAmount / inputAmount * 100;
        }
        String rateOfReturn = String.format("%.1f", rate);

        return rateOfReturn;
    }





}

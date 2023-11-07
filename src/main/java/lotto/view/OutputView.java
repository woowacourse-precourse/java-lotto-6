package lotto.view;

import lotto.model.Lotto;
import lotto.model.User;
import lotto.utils.Calculator;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class OutputView {

    private static final int LOTTO_PRICE = 1000;

    public static void displayLottoList(User user){
        int amount = user.getUserAmount();
        List<Lotto> lottos = user.getUserLottos();
        displayPurchase(amount);
        for(Lotto lotto : lottos){
            displayLotto(lotto);
        }
        System.out.println();
    }

    public static void displayResult(User user){
        displayWinningDetails(user);
        displayEarningRate(user);
    }

    private static void displayWinningDetails(User user){
        List<Integer> ranks = user.getRanks();
        System.out.println();
        System.out.println("당첨통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - "+Calculator.rankCount(5,ranks)+"개");
        System.out.println("4개 일치 (50,000원) - "+Calculator.rankCount(4,ranks)+"개");
        System.out.println("5개 일치 (1,500,000원) - "+Calculator.rankCount(3,ranks)+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+Calculator.rankCount(2,ranks)+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+Calculator.rankCount(1,ranks)+"개");
    }

    private static void displayEarningRate(User user){
        DecimalFormat df = new DecimalFormat("#.##");
        List<Integer> ranks = user.getRanks();
        int amount = user.getUserAmount();
        double earningRate = Calculator.calculateEarningRate(amount,ranks);
        String roundedNumber = df.format(earningRate);
        System.out.println("총 수익률은 "+roundedNumber+"%입니다.");
    }

    private static void displayPurchase(int amount){
        int purchaseNumber = amount/LOTTO_PRICE;
        System.out.println();
        System.out.println(purchaseNumber+"개를 구매했습니다.");
    }

    private static void displayLotto(Lotto lotto){
        List<Integer> lottoNumbers = lotto.getNumbers();
        List<Integer> sortedList = sortListAscending(lottoNumbers);
        System.out.println(sortedList);
    }

    private static List<Integer> sortListAscending(List<Integer> numbers){
        List<Integer> sortedList = new ArrayList<>(numbers);
        Collections.sort(sortedList);
        return sortedList;
    }
}

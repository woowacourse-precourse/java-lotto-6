package lotto.view;

import lotto.enums.WinningMessage;
import lotto.model.Lotto;
import lotto.model.User;
import lotto.utils.Calculator;
import java.text.DecimalFormat;
import java.util.ArrayList;
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
        System.out.println("당첨통계\n---");
        for(WinningMessage winningMessage : WinningMessage.values()){
            int rankCount=Calculator.rankCount(winningMessage.getRank(),ranks);
            System.out.println(winningMessage.getMessage()+rankCount+"개");
        }
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

package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Game {
    private final int money;
    private final List<Lotto> lottos = new ArrayList<>();
    List<Integer> results = new ArrayList<>(Collections.nCopies(6,0));
    float earn=0;

    public Game(int money){
        moneyValidCheck(money);
        this.money = money;
        for (int i = 0; i < money/1000; i++) {
            makeLotto();
        }
        printLotto();
    }

    private void moneyValidCheck(int money){
        if(money%1000>0){
            throw new IllegalArgumentException();
        }
    }

    private void makeLotto(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        numbers.sort(Comparator.naturalOrder());
        lottos.add(new Lotto(numbers));
    }

    private void printLotto(){
        System.out.printf("%d개를 구매했습니다.\n",this.money/1000);
        for (Lotto lotto:lottos) {
            System.out.println(lotto.toString());
        }
        System.out.println();
    }

    private void Result(List<Integer> winNumbers, int bonusNumber){
        for (Lotto lotto:lottos) {
            PRIZE win = lotto.Score(winNumbers,bonusNumber);
            results.set(win.getScore(),results.get(win.getScore())+1);
            earn+=win.getValue();
        }
    }

    public void printResult(List<Integer> winNumbers, int bonusNumber){
        Result(winNumbers,bonusNumber);
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (%s) - %d개\n",PRIZE.FIFTH,results.get(4));
        System.out.printf("4개 일치 (%s) - %d개\n",PRIZE.FORTH,results.get(3));
        System.out.printf("5개 일치 (%s) - %d개\n",PRIZE.THIRD,results.get(2));
        System.out.printf("5개 일치, 보너스 볼 일치 (%s) - %d개\n",PRIZE.SECOND,results.get(1));
        System.out.printf("6개 일치 (%s) - %d개\n",PRIZE.FIRST,results.get(0));

        System.out.printf("총 수익률은 %.1f%s입니다.",earn/money,"%");
    }
}

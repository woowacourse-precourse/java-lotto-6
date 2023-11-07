package lotto;

import java.text.DecimalFormat;
import java.util.*;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.UserInput.*;

public class Game {

    Money money;
    List<Lotto> listLotto;

    private float getRate(HashMap<Integer,Integer> map){
        int money = this.money.val;
        float rate = 0;

        for (int key : map.keySet()){
            int value = map.get(key);
            rate += (key * value);
        }
        return (rate / money * 100);
    }

    private void printRate(HashMap<Integer,Integer> map){
        float rate = getRate(map);

        if (rate == 0){
            System.out.printf("총 수익률은 %.0f%%입니다.", rate);
            return;
        }
        System.out.printf("총 수익률은 %.1f%%입니다.\n", rate);
    }

    private void printItem(Winning winning, int key){
        DecimalFormat formatter = new DecimalFormat("#,###");
        int count = winning.listPrize.indexOf(key) + 3;

        if (key == 30000000){
            System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n",
                    count - 1,
                    formatter.format(key),
                    winning.map.get(key));
            return;
        }
        if (key > 30000000) count -= 1;
        System.out.printf("%d개 일치 (%s원) - %d개\n",
                count,
                formatter.format(key),
                winning.map.get(key));
    }

    private void viewResult(Winning winning){
        System.out.print("\n당첨 통계\n---\n");
        for (int key : winning.listPrize) printItem(winning, key);
        printRate(winning.map);
    }

    private void writeBonus(Winning winning){
        while (true){
            try {
                winning.setBonus(inputBonus());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void writeNumbers(Winning winning){
        while (true){
            try {
                winning.setListNumber(inputNumbers());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void printListLotto(List<Lotto> listLotto){
        System.out.printf("\n%d개를 구매했습니다.\n", listLotto.size());
        for (Lotto lotto : listLotto){
            lotto.printNumbers();
        }
    }

    private List<Lotto> getListLotto(int money){
        List<Lotto> list = new ArrayList<>();
        int cntLotto = money / 1000;

        for (int i = 0; i < cntLotto; i++) {
            List<Integer> numbers = pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            list.add(lotto);
        }
        return list;
    }

    private void writeMoney(){
        while (true){
            try {
                this.money = new Money(inputMoney());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void run(){
        writeMoney();
        this.listLotto = getListLotto(money.val);
        printListLotto(this.listLotto);
        Winning winning = new Winning();
        writeNumbers(winning);
        writeBonus(winning);
        winning.calc(this.listLotto);
        viewResult(winning);
    }
}

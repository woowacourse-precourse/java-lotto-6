package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class Calculator {
    private Map<Prize, Integer> count;
    private List<Integer> winner;
    private int bonusNum;

    public Calculator() {
        count = new HashMap<>();
        init();
    }

    private void init() {
        for (Prize p : Prize.values()) {
            count.put(p, 0);
        }
    }

    public void setWinner(List<Integer> winner) {
        this.winner = winner;
    }

    public void setBonus(int bonus) throws IllegalArgumentException {
        if (winner.contains(bonus)) {
            throw new IllegalArgumentException();
        }
        bonusNum = bonus;
    }


    public void checkLotto(Lotto lotto) {
        int containCount = 0;
        for (int num : winner) {
            if (lotto.hasNum(num)) {
                containCount += 2;
            }
        }
        if (lotto.hasNum(bonusNum)) {
            containCount++;
        }
        update(containCount);
    }

    private void update(int containCount) {
        int temp;
        Prize p2 = Prize.PRIZE_2ND;
        if(p2.getSame()==containCount){
            temp=count.get(p2)+1;
            count.put(p2,temp);
            return;
        }
        containCount-=containCount%2;
        for (Prize p : Prize.values()) {
            if (p.getSame() == containCount) {
                temp = count.get(p) + 1;
                count.put(p, temp);
                return;
            }
        }
    }

    public long prizeSum() {
        long sum = 0;
        for (Prize p : Prize.values()) {
            sum += p.getMoney() * count.get(p);
        }
        return sum;
    }

    public String statistics() {
        StringJoiner sj = new StringJoiner("\n");
        for (Prize p : Prize.values()) {
            sj.add(String.format("%s%d개", p.getUI(), count.get(p)));
        }
        return sj.toString();
    }
}

package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.util.Quicksort;


public class Lottos {
    private final List<Lotto> lottos;
    private final List<Integer> winningCounts;

    public Lottos(int tryNumber) {
        this.lottos = createLottos(tryNumber);
        this.winningCounts = new ArrayList<>();
    }

    public List<Lotto> getLottos(){
        return this.lottos;
    }

    public List<Integer> getWinningCounts(){
        return this.winningCounts;
    }
    private List<Lotto> createLottos(int tryNumber) {
        List<Lotto> Lottos = new ArrayList<>();
        for (int i = 0; i < tryNumber; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lottos.add(new Lotto(sortNumber(numbers)));
        }
        return Lottos;
    }

    private List<Integer> sortNumber(List<Integer> numbers) {
        Quicksort quicksort = new Quicksort();
        quicksort.sort(numbers);
        return numbers;
    }

    public void checkRank(List<Integer> winning_numbers, Lotto lotto) {
        int state = 0;
        int count = 0;
        for (int number : winning_numbers) {
            if (lotto.getNumbers().contains(number)) {
                count++;
            }
            if(state <6 && count == 6){
                count = 7;
                break;
            }
            state++;
        }
        addLottoRank(count);
    }

    public void addLottoRank(int count) {
        if (count == 7) {
            this.winningCounts.add(1);
        } else if (count == 6) {
            this.winningCounts.add(2);
        } else if (count == 5) {
            this.winningCounts.add(3);
        } else if (count == 4) {
            this.winningCounts.add(4);
        } else if (count == 3) {
            this.winningCounts.add(5);
        }
    }

}

package lotto.domain;

import lotto.domain.Lotto;
import lotto.util.RandomNumbers;

import java.util.*;

public class Lottos {
    private List<Lotto> lottos = new ArrayList<>();

    public Lottos(List<Lotto> lottos){
        this.lottos = lottos;
        hasDuplicates();
    }

    public Lottos(int number) {
        createLotto(number);
        hasDuplicates();
    }

    public Lottos(){

    }
    public void createLotto(int count) {
        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto(RandomNumbers.generateRandomNumbers());
            lottos.add(lotto);
        }
    }
    public Map<Long, Long> checkWinningNumbers(List<Integer> numbers, int bonusNumber){
        WinningNumbers winningNumbers = new WinningNumbers(numbers, bonusNumber);
        return winningNumbers.isMatching(lottos);
    }

    public List<Lotto> getLottos(){
        return this.lottos;
    }

    private void hasDuplicates() {
        Set<List<Integer>> uniqueLists = new HashSet<>();
        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            if (!uniqueLists.add(numbers)) {
                throw new IllegalArgumentException("로또 번호가 중복되었습니다.");
            }
        }
    }

}
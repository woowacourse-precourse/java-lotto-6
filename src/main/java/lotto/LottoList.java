package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoList {
    private final List<Lotto> lottoList;
    private final Integer lottoCount;

    public LottoList(List<Lotto> lotto_list) {
        this.lottoList = lotto_list;
        this.lottoCount = lotto_list.size();
    }

    public void printLottoCount() {
        System.out.println("\n" + lottoCount + "개를 구매했습니다.");
    }

    public void printLottoList() {
        for (Lotto currentLotto : lottoList) {
            List<String> lottoNumbers = currentLotto.getNumbers()
                    .stream().map(x -> String.valueOf(x)).collect(Collectors.toList());
            System.out.println("[" + String.join(", ", lottoNumbers) + "]");
        }
    }

    public List<Integer> compareLotto(Lotto lotto) {
        List<Integer> compare_count = new ArrayList<>();
        List<Integer> lotto_number = lotto.getNumbers();
        for (Lotto currentLotto : lottoList) {
            int count = countMatchNumbers(lotto_number, currentLotto);
            compare_count.add(count);
        }
        return compare_count;
    }

    private int countMatchNumbers(List<Integer> lotto, Lotto currentLotto) {
        int count = 0;
        for (Integer number : lotto) {
            if (currentLotto.getNumbers().contains(number)) {
                count++;
            }
        }
        return count;
    }

    public List<Boolean> compareBonusLotto(BonusLotto bonusLotto) {
        List<Boolean> compare_count = new ArrayList<>();
        int bonus = bonusLotto.getBonus();
        for (Lotto currentLotto : lottoList) {
            Boolean isMatch = countMatchBonus(currentLotto, bonus);
            compare_count.add(isMatch);
        }
        return compare_count;
    }

    private Boolean countMatchBonus(Lotto currentLotto, int bonus) {
        if (currentLotto.getNumbers().contains(bonus)) {
            return true;
        }
        return false;
    }
}

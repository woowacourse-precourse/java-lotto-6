package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoList {
    private final List<Lotto> lottoList;

    public LottoList(List<Lotto> lotto_list) {
        this.lottoList = lotto_list;
    }

    public void printLottoList() {
        for (int i = 0; i < lottoList.size(); i++) {
            List<Integer> lotto = lottoList.get(i).getNumbers();
            List<String> lottoNumbers = lotto.stream().map(x -> String.valueOf(x))
                    .collect(Collectors.toList());
            System.out.println("[" + String.join(", ", lottoNumbers) + "]");
        }
    }

    public List<Integer> compareLotto(Lotto lotto) {
        List<Integer> compare_count = new ArrayList<>();
        List<Integer> lotto_number = lotto.getNumbers();
        for (int i = 0; i < lottoList.size(); i++) {
            List<Integer> lotto_list = lottoList.get(i).getNumbers();
            int count = 0;
            for (int j = 0; j < lotto_number.size(); j++) {
                if (lotto_list.contains(lotto_number.get(j))) {
                    count += 1;
                }
            }
            compare_count.add(count);
        }
        return compare_count;
    }

    public List<Boolean> compareBonusLotto(BonusLotto bonusLotto) {
        List<Boolean> compare_count = new ArrayList<>();
        int bonus = bonusLotto.getBonus();
        for (int i = 0; i < lottoList.size(); i++) {
            List<Integer> lotto_list = lottoList.get(i).getNumbers();
            if (lotto_list.contains(bonus)) {
                compare_count.add(true);
                continue;
            }
            compare_count.add(false);
        }
        return compare_count;
    }
}

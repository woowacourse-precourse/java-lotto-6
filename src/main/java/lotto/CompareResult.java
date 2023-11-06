package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompareResult {
    public List<Integer> compare(List<List<Integer>> purchase_lottos, ArrayList<Integer> win_lottos, int bonus_lotto) {
        // 6. 구매 번호와 당첨 번호 비교
        List<Integer> matches = new ArrayList<>();
        for (List<Integer> lotto : purchase_lottos) {
            int match_count = 0;
            match_count += (int) lotto.stream()
                    .filter(win_lottos::contains)
                    .count();
            matches.add(match_count);
        }

        List<Integer> win_counts = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));

        for (int i = 0; i < matches.size(); i++) {
            int match_count = matches.get(i);

            if (match_count == 3) {
                win_counts.set(0, win_counts.get(0) + 1);
            }
            if (match_count == 4) {
                win_counts.set(1, win_counts.get(1) + 1);
            }
            if (match_count == 5 && purchase_lottos.get(i).contains(bonus_lotto)) {
                win_counts.set(2, win_counts.get(2) + 1);
            }
            if (match_count == 5 && !purchase_lottos.get(i).contains(bonus_lotto)) {
                win_counts.set(3, win_counts.get(3) + 1);
            }
            if (match_count == 6) {
                win_counts.set(4, win_counts.get(5) + 1);
            }
        }
        return win_counts;
    }
}

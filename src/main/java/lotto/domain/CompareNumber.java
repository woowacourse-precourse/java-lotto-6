package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class CompareNumber {
    static public List<Integer> compare(List<Integer> user, List<Integer> win, int bonus) {
        List<Integer> comparelist = new ArrayList<>();
        int wincount = 0, bonuscount = 0;
        for (int i = 0; i < win.size(); i++) if (user.contains(win.get(i))) wincount++;
        if (user.contains(bonus)) bonuscount++;
        comparelist.add(wincount);
        comparelist.add(bonuscount);
        return comparelist;
    }
}
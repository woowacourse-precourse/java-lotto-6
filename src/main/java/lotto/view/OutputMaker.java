package lotto.view;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OutputMaker {
    public String printLotto(Lotto lotto) {
        StringBuilder sb = new StringBuilder();
        List<Integer> thisLotto = new ArrayList<>(lotto.getNumbers());
        sb.append("[");
        Collections.sort(thisLotto);
        for (int i = 0; i < 5; i++) {
            sb.append(thisLotto.get(i));
            sb.append(", ");
        }
        sb.append(thisLotto.get(5));
        sb.append("]");
        return String.valueOf(sb);
    }
}

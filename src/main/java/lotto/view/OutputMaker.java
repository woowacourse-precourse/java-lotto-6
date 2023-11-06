package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputMaker {
    public String printLotto(Lotto lotto) {
        StringBuilder sb = new StringBuilder();
        List<Integer> thisLotto = lotto.getNumbers();
        sb.append("[");
        for (int i = 0; i<5;i++) {
            sb.append(thisLotto.get(i));
            sb.append(", ");
        }
        sb.append(thisLotto.get(5));
        sb.append("]");
        return String.valueOf(sb);
    }
}

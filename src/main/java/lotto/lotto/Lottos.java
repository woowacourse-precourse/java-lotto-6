package lotto.lotto;

import java.util.List;

public record Lottos(List<Lotto> lottoList) {

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottoList) {
            sb.append(lotto.getNumbers().toString())
                    .append("\n");
        }

        return sb.toString();
    }
}

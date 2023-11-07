package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotteries {
    private static final String DELIMITER = "\n";
    private List<Lotto> lotteries;

    public Lotteries() {
        lotteries = new ArrayList<>();
    }

    public void addLotto(Lotto lotto) {
        lotteries.add(lotto);
    }

    public String concatLotteries() {
        StringBuilder stringBuilder = new StringBuilder();
        lotteries.forEach(lotto -> {
            String lottoNumbers = lotto.concatNumbers();
            stringBuilder.append(lottoNumbers);
            stringBuilder.append(DELIMITER);
        });
        return stringBuilder.toString();
    }
}

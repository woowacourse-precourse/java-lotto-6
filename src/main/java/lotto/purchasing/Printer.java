package lotto.purchasing;

import static lotto.Messages.PURCHASE_COUNT;
import static lotto.Settings.MAXIMUM;
import static lotto.Settings.MINIMUM;
import static lotto.Settings.SIZE;

import java.util.List;
import lotto.Lotto;

public class Printer {
    private final Generator generator;

    public Printer(Generator generator) {
        this.generator = generator;
    }

    public List<Lotto> print() {
        System.out.println();

        int issueAmount = generator.calculateIssueAmount();
        List<Lotto> lottos =
                generator.issue(MINIMUM.getNumber(), MAXIMUM.getNumber(), SIZE.getNumber());

        StringBuilder lottoList = new StringBuilder();
        lottos.forEach(lotto -> lottoList.append(lotto.getNumbers()).append("\n"));

        System.out.println(issueAmount + PURCHASE_COUNT.getMessage());
        System.out.println(lottoList);

        System.out.println();

        return lottos;
    }
}

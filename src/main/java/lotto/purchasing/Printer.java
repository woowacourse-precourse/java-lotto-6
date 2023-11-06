package lotto.purchasing;

import static lotto.Settings.MAXIMUM;
import static lotto.Settings.MINIMUM;
import static lotto.Settings.SIZE;

import java.util.List;
import lotto.Lotto;

public class Printer {
    private static final String purchaseCountMessage = "개를 구매했습니다.";
    Generator generator;

    public Printer(Generator generator) {
        this.generator = generator;
    }

    public List<Lotto> print() {
        System.out.println();

        int issueAmount = generator.calculateIssueAmount();
        List<Lotto> lottos =
                generator.issue(issueAmount, MINIMUM.getNumber(), MAXIMUM.getNumber(), SIZE.getNumber());

        System.out.println(issueAmount + purchaseCountMessage);
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));

        System.out.println();

        return lottos;
    }
}

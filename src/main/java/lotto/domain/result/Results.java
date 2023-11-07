package lotto.domain.result;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.WinLotto;
import lotto.domain.lotto.etc.BounsNumber;

public class Results {
    private static List<Lotto> lottos;
    private static WinLotto winLotto;
    private static BounsNumber bounsNumber;

    public Results(List<Lotto> lottos, WinLotto winLotto) {
        this.lottos = lottos;
        this.winLotto = winLotto;
        this.bounsNumber = winLotto.getBonusNumber();
    }

    public void calculate() {
        lottos.stream().forEach(e -> {
            int count = e.containsCount(winLotto);
            boolean bonusByContains = e.contains(bounsNumber.getBounsNumber());
            plusCount(count, bonusByContains);
        });
    }

    private void plusCount(int number, boolean bonusByContains) {
        if (number == 3) {
            Result.FIFTH.plusCount();
        } else if (number == 4) {
            Result.FOURTH.plusCount();
        } else if (number == 5 && !bonusByContains) {
            Result.THIRD.plusCount();
        } else if (number == 5 && bonusByContains) {
            Result.SECOND.plusCount();
        } else if (number == 6) {
            Result.FIRST.plusCount();
        }
    }

    public void showResult() {
        System.out.println(String.format("3개 일치 (5,000원) - %d개", Result.FIFTH.getCount()));
        System.out.println(String.format("4개 일치 (50,000원) - %d개", Result.FOURTH.getCount()));
        System.out.println(String.format("5개 일치 (1,500,000원) - %d개", Result.THIRD.getCount()));
        System.out.println(String.format("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개", Result.SECOND.getCount()));
        System.out.println(String.format("6개 일치 (2,000,000,000원) - %d개", Result.FIRST.getCount()));
    }
}

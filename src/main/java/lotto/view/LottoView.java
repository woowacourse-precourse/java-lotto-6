package lotto.view;

import java.text.DecimalFormat;
import java.util.List;
import lotto.domain.Match;

public class LottoView {

    public void guidePrice() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void showBoughtLotto(int count, List<String> boughtLotto) {
        System.out.println(count + "개를 구매했습니다.");

        for (int i = 0; i < boughtLotto.size(); i++) {
            System.out.println(boughtLotto.get(i));
        }
    }

    public void guideWinLotto() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void guideBonusNum() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void showWinStats(Match match, int count) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###");

        System.out.print(match.getNumOfMatches() + "개 일치");

        if (match == Match.SECOND) {
            System.out.print(", 보너스 볼 일치");
        }

        System.out.print(" (" + decimalFormat.format(match.getPrice()) + "원)");
        System.out.println(" - " + count + "개");
    }

    public void showYield(double yield) {
        String formattingYield = String.format("%.1f", yield);

        System.out.println("총 수익률은 " + formattingYield + "%입니다.");
    }
}

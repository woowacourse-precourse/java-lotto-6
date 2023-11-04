package lotto.view;

import java.util.List;
import lotto.code.Rank;

public class Output {
    public void enterPurchaseAmoutMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void checkPurchaseAmoutMessage(int purchaseAmount) {
        System.out.println(purchaseAmount + "개를 구매했습니다.");
    }

    public void showPurchaseLottoNumber(List<Number> lottoNumbers) {
        System.out.println(lottoNumbers);
    }

    public void enterWinnigNumbersMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void enterBonusNumberMessage() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void lottoResultTitleMessage() {
        System.out.println("당첨 통계\n" + "---");
    }

    public void rateOfReturnMessage(int rateOfReturn) {
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
    }

    public void lottoResultMessage(List<Number> matchCount) {
        for(Rank rank : Rank.values()) {
            matchCount.stream()
                            .forEach(count ->
                                    System.out.println(rank.getMessage() + " - " + count + "개" )
                            );
        }
    }
}

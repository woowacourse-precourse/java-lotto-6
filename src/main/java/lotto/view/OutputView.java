package lotto.view;

import lotto.model.Lotto;
import lotto.model.enums.Rank;

import java.util.List;

public class OutputView {

    public OutputView() {
    }

    public void printInputPurchaseMoney() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printInputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printInputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printTicketNumber(int ticketNumber) {
        String output = ticketNumber + "개를 구매했습니다.";
        System.out.println(output);
    }

    public void printLottos(List<Lotto> lottos) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Lotto lotto : lottos) {
            stringBuilder.append("[");
            stringBuilder.append(makeLottoString(lotto));
            stringBuilder.append("]");
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
    }

    private String makeLottoString(Lotto lotto) {
        List<String> numbers = lotto
                .getNumbers()
                .stream()
                .map(Object::toString)
                .toList();
        return String.join(", ", numbers);
    }

    public void printLottoResult(List<Integer> rankResult, double rateOfReturn) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("당첨 통계\n");
        stringBuilder.append("---\n");
        stringBuilder.append("3개 일치 (5,000원) - " + rankResult.get(Rank.RANK5.getRank() - 1) + "개\n");
        stringBuilder.append("4개 일치 (50,000원) - " + rankResult.get(Rank.RANK4.getRank() - 1) + "개\n");
        stringBuilder.append("5개 일치 (1,500,000원) - " + rankResult.get(Rank.RANK3.getRank() - 1) + "개\n");
        stringBuilder.append("5개 일치, 보너스 볼 일치 (30,000,000원) - " + rankResult.get(Rank.RANK2.getRank() - 1) + "개\n");
        stringBuilder.append("6개 일치 (2,000,000,000원) - " + rankResult.get(Rank.RANK1.getRank() - 1) + "개\n");
        stringBuilder.append("총 수익률은 " + String.format("%.1f",rateOfReturn) + "%입니다.");
        System.out.println(stringBuilder);
    }

    public void printBlankLine() {
        System.out.println();
    }

}

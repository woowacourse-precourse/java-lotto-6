package lotto.view;

import lotto.model.Lotto;

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
        System.out.println(stringBuilder.toString());
    }

    private String makeLottoString(Lotto lotto) {
        List<String> numbers = lotto
                .getNumbers()
                .stream()
                .map(Object::toString)
                .toList();
        return String.join(", ", numbers);
    }

    public void printBlankLine() {
        System.out.println();
    }

}

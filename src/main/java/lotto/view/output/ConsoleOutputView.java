package lotto.view.output;

public class ConsoleOutputView implements OutputView {

    @Override
    public void askInvestMoney() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    @Override
    public void printBoughtLottoSize(final int size) {
        System.out.println();
        System.out.println(size + "개를 구매했습니다.");
    }
}

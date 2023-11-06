package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputViewImpl implements OutputView {

    private static final String HEADER = "[ERROR] ";

    @Override
    public void writeLottoPurchaseMoney() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    @Override
    public void writeGeneratedLotto(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.\n", lottos.size());
        lottos.forEach(System.out::println);
    }

    @Override
    public void writeLottoWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    @Override
    public void writeLottoBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    @Override
    public void writeResult() {
        System.out.println("당첨 통계");
        System.out.println("---");
        // TODO : 결과 출력
    }

    @Override
    public void writeBlank() {
        System.out.println();
    }

    @Override
    public void writeWithErrorMessage(String message) {
        System.out.println(HEADER + message);
    }
}

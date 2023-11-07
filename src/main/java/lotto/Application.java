package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoService lottoService = new LottoService();

        System.out.println("구입 금액을 입력해 주세요.");
        int times = lottoService.purchaseLotto();
        List<Lotto> lottoList = lottoService.issueLotto(times);

        System.out.println("당첨 번호를 입력해주세요.");
        Lotto winningLotto = lottoService.drawLotto();
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = lottoService.drawBonus();

        System.out.println("당첨 통계");
        System.out.println("---");
        lottoService.award(winningLotto, bonusNumber, lottoList, times);
    }
}

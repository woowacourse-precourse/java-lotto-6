package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmount = Console.readLine();

        LottoProvider lottoProvider = new LottoProvider();
        List<Lotto> lottos = lottoProvider.buyLottos(purchaseAmount);
        int lottoCnt = lottos.size();

        System.out.println(lottoCnt + "개를 구매했습니다.");
        lottos.forEach(Lotto::print);
        System.out.println();

        System.out.println("당첨 번호를 입력해 주세요.");
        String winInput = Console.readLine();
        // TODO: winInput validation
//        validate(winInput); // 1 ~ 45 사이의 중복되지 않는 숫자 6개여야함

        System.out.println("보너스 번호를 입력해 주세요.");
        String bonus = Console.readLine();
        // TODO: bonus number validation
//        validate(bonus); // 1 ~ 45 사이의 숫자여야함

        System.out.println("당첨 통계");
        System.out.println("---");
        // TODO: 당첨 통계 내기
    }
}

package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoGame {
    private LottoGameService lottoGameService;

    public LottoGame() {
        this.lottoGameService = new LottoGameService();
    }

    public void start() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(Console.readLine());
        LottoGameResponse lottoGameResponse = lottoGameService.buy(money);

        System.out.printf("%s개를 구매했습니다.\n", lottoGameResponse.getCount());
        for (int i = 0; i < lottoGameResponse.getCount(); i++) {
            System.out.println(lottoGameResponse.getBuyLottoNumbers().get(i));
        }

//        System.out.println("당첨 번호를 입력해 주세요.");
//        String winningNumbers = Console.readLine();
//        System.out.println("보너스 번호를 입력해 주세요.");
//        int bonusNumber = Integer.parseInt(Console.readLine());
//
//        lottoGameService.calculateResult(winningNumbers, bonusNumber);
    }
}

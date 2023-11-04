package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();
        LottoWin lottoWin = new LottoWin();

        System.out.println("구입금액을 입력해 주세요.");
        int price = Integer.parseInt(Console.readLine());
        lottoGame.validatePurchaseAmount(price);
        lottoGame.generateLottoNumbers();


        System.out.println("당첨 번호를 입력해 주세요.");
        lottoWin.setLottoWinNumbers();

        System.out.println("보너스 번호를 입력해 주세요.");
        lottoWin.setWinBonusnumber();

    }
}

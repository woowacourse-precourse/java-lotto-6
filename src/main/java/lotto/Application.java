package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputManager inputManager = new InputManager();
        int purchaseAmount = inputManager.getPurchaseAmount();
        List<Integer> winningNumbers = inputManager.getWinnigNumbers();
        int bonusNumber = inputManager.getBonusNumber();
        System.out.println("구입한 로또 금액 : " + purchaseAmount);
        System.out.println("당첨된 복권 : " + winningNumbers);
        System.out.println("보너스 넘버 : " + bonusNumber);

        LottoGenerator lottoGenerator = new LottoGenerator();
        Lotto lotto = lottoGenerator.generateLotto();
        System.out.println("생성된 로또 번호 : " + lotto.getLottoNumbers());
    }
}

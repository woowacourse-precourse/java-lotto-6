package lotto;

public class Application {
    public static void main(String[] args) {
        // 로또 구입 금액 입력 받기
        BuyingLotto.gettingInput();

        // 로또 구입 금액만큼 로또 발행 받기
        BuyingLotto.givingLotto();
        BuyingLotto.printingLotto();

        // 당첨 번호와 보너스 번호 입력 받기
        WinningNumber.gettingWinningNumber();
        WinningNumber.gettingBonusNumber();
    }
}

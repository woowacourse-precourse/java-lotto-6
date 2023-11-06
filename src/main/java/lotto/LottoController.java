package lotto;

public class LottoController {

    private static final Wallet wallet = new Wallet();

    private static final LottoView view = new LottoView();


    void inputAmountOfLotto() {

        try {
            int amount = view.inputNumber("구입금액을 입력해 주세요.");
            wallet.addBalance(amount);

        } catch (Exception e) {
            view.printMessage(e.getMessage());
            inputAmountOfLotto();

            return;
        }

        System.out.println(wallet.getBalance());

    }
}

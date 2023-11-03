package lotto;

public class LottoGameStarter {
    public void gameStart() {

        String wallet = Input.customerWalletInput();
        Customer customer = new Customer(wallet);
        String winNum = Input.winNumberInput();
        int bonusNum = Input.bonusNumberInput();
        WinLotto winLotto = new WinLotto(winNum, bonusNum);
        LottoShop lottoShop = new LottoShop(customer, winLotto);
        lottoshop.compareWinNum();
    }
}

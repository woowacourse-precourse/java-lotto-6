package lotto;

public class LottoGameStarter {
    public void gameStart() {

        String wallet = Input.customerWalletInput();
        Customer customer = new Customer(wallet);
        String winNums = Input.winNumberInput();
        String bonusNum = Input.bonusNumberInput();
        WinLotto winLotto = new WinLotto(winNums, bonusNum);
        LottoShop lottoShop = new LottoShop(customer, winLotto);
        lottoshop.compareWinNum();
    }
}

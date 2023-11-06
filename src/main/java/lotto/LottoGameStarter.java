package lotto;

public class LottoGameStarter {

    private String wallet;
    private String winNums;
    private String bonusNum;
    private Customer customer;
    private WinLotto winLotto;
    private LottoShop lottoShop;

    public void gameStart() {

        while (true) {

            try {

                wallet = Input.customerWalletInput();
                customer = new Customer(wallet);
                break;
            } catch (IllegalArgumentException e) {

                System.out.println(e.getMessage());
            }
        }

        while (true) {

            try {

                winNums = Input.winNumberInput();
                bonusNum = Input.bonusNumberInput();
                winLotto = new WinLotto(winNums, bonusNum);
                break;
            } catch (IllegalArgumentException e) {

                System.out.println(e.getMessage());
            }
        }

        lottoShop = new LottoShop(customer, winLotto);
        lottoShop.compareWinLotto();
    }
}

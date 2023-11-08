package lotto;

public class Application {
    public static void main(String[] args) {
        LottoMoney lottoMoney = new LottoMoney();
        System.out.println(lottoMoney.money);

        WinLotto winLotto = new WinLotto();
        System.out.println(winLotto.lotto.numbers);
        System.out.println(winLotto.bonus.bonus);
    }
}

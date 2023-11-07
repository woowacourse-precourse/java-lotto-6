package lotto;

public class Application {
    public static void main(String[] args) {
        LottoCompany lottoCompany = LottoCompany.newInstance();
        LottoShop lottoShop = LottoShop.newInstance();
        User user = User.newInstance();
        lottoShop.sellLotto(user);
        lottoCompany.drawLotto();
        lottoCompany.respondLottoResult(user);
    }
}

package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoManagement lottoManagement = new LottoManagement();
        lottoManagement.initMoney();
        int money= lottoManagement.getMoney();
        System.out.print(money);
        lottoManagement.initWinningLottoNumbers();
        int bonusNumber=lottoManagement.getBonusNumber();
        System.out.print(bonusNumber);
    }
}

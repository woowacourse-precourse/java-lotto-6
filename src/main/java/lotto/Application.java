package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoManagement lottoManagement = new LottoManagement();
        lottoManagement.initMoney();
        lottoManagement.buyLottos();
        lottoManagement.initWinningLottoNumbers();
        lottoManagement.setScore();


        lottoManagement.printDetails();
        lottoManagement.printRate();
        lottoManagement.printRate();lottoManagement.printRate();
    }
}

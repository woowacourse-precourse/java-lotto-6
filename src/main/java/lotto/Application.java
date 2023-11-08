package lotto;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoService lottoService = new LottoService();

        int paid = lottoService.readPaid();
        int bought = lottoService.setBought(paid);

        Lotto[] lottoNum = lottoService.createLottoNums(bought);
        lottoService.printLottoNums(lottoNum);

        Lotto userNum = lottoService.readUserNum();
        int bonusNum = lottoService.readBonusNum(userNum);

        lottoService.setResult(lottoNum, userNum, bonusNum);
        long earned = lottoService.getEarned();

        lottoService.printResult();
        lottoService.printProfit(paid, earned);
    }

}


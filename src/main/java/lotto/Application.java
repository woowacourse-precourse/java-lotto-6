package lotto;

public class Application {

    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.buyingLotto();
        controller.lottoDraw();
        controller.drawLottoWinningNumber();
        controller.drawLottoBonusNumber();
        controller.lotteryForWinners();
        controller.findRateOfReturn();
    }
}

package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Program program = new Program();
        program.purchaseLottos();
        program.insertWinningNumbers();
        program.insertBonusNumber();
        //LottoDrawResult drawResult = BroadCastingStation.drawLotto(lotto, bonusNumber);   // UI를 직접사용하는 코드, Program으로 변경 요망
        //UI.printWinningStats(lottos, drawResult); // UI를 직접사용하는 코드, Program으로 변경 요망
    }
}

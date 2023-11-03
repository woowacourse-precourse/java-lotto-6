package lotto;


import java.util.List;

public class LottoManager {
    private List<Lotto> lottos;
    private Calculator calculator;

    public LottoManager() {
        calculator = new Calculator();
    }

    public void run() {
        ConsoleView.print("구입금액을 입력해 주세요.");
        getMoney();
        setCalculator();
    }

    public void setCalculator() {
        ConsoleView.print("당첨 번호를 입력해 주세요.");
        setCalculatorWinner();
        ConsoleView.print("보너스 번호를 입력해 주세요.");
        setCalculatorBonus();
        checkWinner();
        showStatistics();
    }
    public void checkWinner(){
        for(Lotto l:lottos){
            calculator.checkLotto(l);
        }
    }

    public void showStatistics() {
        ConsoleView.print("당첨 통계\n---");
        ConsoleView.print(calculator.statistics());
        float margin = (float) calculator.prizeSum() / lottos.size();
        ConsoleView.print(String.format("총 수익률은 %.1f%%입니다.", margin));
    }

    private void setCalculatorWinner() {
        calculator.setWinner(ConsoleView.getListInput());
    }

    private void setCalculatorBonus() {
        try {
            calculator.setBonus(ConsoleView.getIntInput());
        } catch (IllegalArgumentException e) {
            ConsoleView.print("[ERROR] 보너스 숫자는 당첨번호와 중복되어서는 안됩니다.");
            setCalculatorBonus();
        }
    }

    public void getMoney() {
        long money = ConsoleView.getLongInput();
        ConsoleView.print("");
        try {
            lottos = LottoPublisher.getInstance().sell(money);
            ConsoleView.print(String.format("%d개를 구매했습니다.", lottos.size()));
            showLottos();
        } catch (IllegalArgumentException e) {
            ConsoleView.print("[ERROR] 1000원 단위 양수로 입력해야 합니다.");
            getMoney();
        }
    }

    public void showLottos() {
        for (Lotto l : lottos) {
            ConsoleView.print(l.toString());
        }
        ConsoleView.print("");
    }
}

package lotto;

public class Application {
    public static void main(String[] args) {
        WinningStatistics winningStatistics = new WinningStatistics();
        UserInputHandler userInputHandler = new UserInputHandler();
        LottoResultPrinter lottoResultPrinter = new LottoResultPrinter();
        Simulation simulation = new Simulation(winningStatistics, userInputHandler, lottoResultPrinter);
        simulation.start();
    }
}

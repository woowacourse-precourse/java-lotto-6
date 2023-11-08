package lotto;

import lotto.machine.game.LottoGameMachine;
import lotto.machine.game.LottoGameMachineInterface;
import lotto.machine.ui.ConsoleUI;
import lotto.machine.util.random.RandomsAdapter;
import lotto.machine.util.random.RandomsProvider;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ConsoleUI ui = new ConsoleUI();
        RandomsProvider randomsProvider = new RandomsAdapter();

        LottoGameMachineInterface lottoGame = new LottoGameMachine(
                ui, randomsProvider
        );

        lottoGame.run();
    }
}

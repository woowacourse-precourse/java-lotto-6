package lotto.controller;

import lotto.domain.Jackpot;
import lotto.domain.Lotto;
import java.util.List;

public class GameService {

    private Setting setting;
    private Judgement judgement;
    private Calculator calculator;
    private List<Lotto> lottos;
    private Jackpot jackpot;

    public GameService() {
        setting = new Setting();
        calculator = new Calculator(judgement);
    }

    public void play() {
        int repetitions = setting.purchaseLotto();

        lottos = setting.pickLottos(repetitions);
        jackpot = setting.pickJackpot();

        judgement = new Judgement(lottos, jackpot, calculator);
        int revenue = judgement.confirmJackpot();
        calculator.printRate();
        calculator.printRevenue(repetitions * 1000, revenue);
    }
}

package lotto;

import lotto.Controller.*;
import lotto.LottoFactory.LottoContainer;
import lotto.LottoFactory.LottoController;

public class Application {
    public static void main(String[] args) {
        LottoContainer lottoContainer = new LottoContainer();
        LottoController lottoController = new LottoController();

        LottoConfiguration lottoConfiguration = new LottoConfiguration(lottoContainer,lottoController);

        Setting setting = new SettingLotto(lottoConfiguration);
        setting.SettingLotto();

        Running running = new RunningLotto(lottoConfiguration, setting.returnCount(), setting.returnBonus());
        running.RunLotto();

        Printing printing = new PrintResult(running.ReturnRate());
        printing.PrintResult();
    }
}

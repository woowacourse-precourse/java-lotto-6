    package lotto;

    import lotto.Controller.Controller;
    import lotto.LottoFactory.LottoContainer;
    import lotto.LottoFactory.LottoController;

    public class Application {
        public static void main(String[] args) {

            LottoContainer lottoContainer = new LottoContainer();
            LottoController lottoController = new LottoController();
            Controller controller = new Controller(lottoContainer, lottoController);

            controller.SettingLotto();
            controller.RunLotto();

        }
    }

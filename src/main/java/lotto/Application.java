    package lotto;

    import lotto.Controller.Controller;
    import lotto.Factory.LottoContainer;

    public class Application {
        public static void main(String[] args) {

            LottoContainer lottoContainer = new LottoContainer();
            Controller controller = new Controller(lottoContainer);

            controller.SettingLotto();
            controller.RunLotto();
            controller.PrintResult();
        }
    }

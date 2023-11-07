package lotto;


import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        AppConfig config = new AppConfig();
        LottoController controller = config.setLottoController();

        try {
            controller.run();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}

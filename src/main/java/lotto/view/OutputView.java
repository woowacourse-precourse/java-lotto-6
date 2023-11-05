package lotto.view;

public class OutputView {
    private static OutputView instance;

    private OutputView() {}

    public static OutputView getInstance() {
        if(instance == null) {
            instance = new OutputView();
        }
        return instance;
    }

    public void printLottos(String lottos) {
        System.out.println(lottos);
    }
}

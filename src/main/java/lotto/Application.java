package lotto;

public class Application {

    public static void main(String[] args) {

        while (true) {
            System.out.println(OutputView.INPUT_COST.getMessage());
            if (LottoGame.getRightCost()) {
                break;
            }
        }
    }
}

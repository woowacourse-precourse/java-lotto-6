package controller;

import model.LottoModel;
import view.LottoView;

public class LottoController {
    private LottoModel model;
    private LottoView view;

    public LottoController() {
        model = new LottoModel();
        view = new LottoView();
    }

    public void run() {
        int purchaseAmount = view.getPurchaseAmount();
        int numberOfTickets = purchaseAmount / 1000;

        for (int i = 0; i < numberOfTickets; i++) {
            model.generateRandomNumbers();
            view.printNumbers(model.getNumbers());
        }
    }

    public static void main(String[] args) {
        LottoController controller = new LottoController();
        controller.run();
    }
}

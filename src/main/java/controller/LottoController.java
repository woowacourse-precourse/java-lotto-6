package controller;

import model.LottoModel;
import model.LottoResult;
import view.LottoView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private LottoModel model;
    private LottoView view;

    public LottoController(LottoModel model, LottoView view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        int purchaseAmount = view.getInput("구입금액을 입력해 주세요.");
        int numberOfTickets = purchaseAmount / 1000;

        view.printPurchaseMessage(numberOfTickets);
        List<List<Integer> > lottoTickets = model.generateLottoTickets(numberOfTickets);
        view.printLottoTickets(lottoTickets);

        List<Integer> winningNumbers = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            int number = view.getInput("당첨 번호를 입력해 주세요.");
            winningNumbers.add(number);
        }

        int bonusNumber = view.getInput("보너스 번호를 입력해 주세요.");

        List<LottoResult> results = model.calculateResults(lottoTickets, winningNumbers, bonusNumber);
        view.printResults(results);
    }
}


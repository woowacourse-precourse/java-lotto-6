package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Model;

import java.util.List;

public class OutputController {
    private final Model model;
    private final Lotto lotto;
    public OutputController(Model model, Lotto lotto) {
        this.model = model;
        this.lotto = lotto;
    }

    public List<Lotto> getListOfBuyLotto() {
        return model.getListOfBuyLotto();
    }
}

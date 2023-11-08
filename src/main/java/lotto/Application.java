package lotto;

import lotto.domain.Calculator;
import lotto.domain.Controller;
import lotto.domain.GeneratorLotto;
import lotto.model.MatchingCounts;
import lotto.validator.Validator;
import lotto.view.View;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller(new View(), new Validator(), new GeneratorLotto(), new MatchingCounts(),
                new Calculator());
        controller.lottoLogic();
    }
}
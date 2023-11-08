package lotto.model;

import lotto.view.InputView;

import java.util.List;

public class CorrectLotto {
    public static List<Integer> correctLotto() {
        List<Integer> result =  List.of(0, 0, 0, 0, 0, 0);
        String[] inputCorrectLotto = InputView.askCorrectLotto().split(",");
        for(String a : inputCorrectLotto) {
            result.add(Integer.parseInt(a));
        }
        return result;
    }
}

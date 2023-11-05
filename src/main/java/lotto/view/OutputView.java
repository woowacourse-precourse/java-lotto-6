package lotto.view;

import lotto.model.Lotto;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public void printLottos(List<Lotto> lottos) {
        String lottoList = lottos.stream()
                .map(lotto -> String.join(",", lotto.getNumbers().stream()
                        .map(Object::toString)
                        .toList()))
                .collect(Collectors.joining("\n"));

        System.out.println(lottoList);
    }

}

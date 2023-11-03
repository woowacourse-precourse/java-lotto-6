package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputLotto {
    public List<Integer> InputLottos() {
        String userInput = Console.readLine();
        String[] lotto = userInput.split(",");
        List<Integer> lottos = Arrays.stream(lotto)
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
        System.out.println(lottos);
        return lottos;
    }
}

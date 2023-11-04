package lotto.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WinningLotto {
    private Lotto winningLotto;

    public WinningLotto(String input) {
        validate(input);
        this.winningLotto = new Lotto(Stream.of(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
    }

    private void validate(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != ',' && ('0' <= input.charAt(i) && input.charAt(i) <= '9')) {
                throw new IllegalArgumentException("[ERROR] 숫자와 쉼표로만 당첨 번호를 입력해 주세요.");
            }
        }
    }
}

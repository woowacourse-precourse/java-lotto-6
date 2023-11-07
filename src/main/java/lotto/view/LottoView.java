package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoView {

    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]+$");

    public String input(String message) {
        System.out.println(message);
        return Console.readLine();
    }

    public int inputPurchaseAmount() {
        String input = input("구입금액을 입력해 주세요.");
        validateIsNumber(input);
        return Integer.parseInt(input);
    }

    public void printLottos(List<Lotto> lottos) {
        System.out.println();
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(lotto -> System.out.println(lotto));
    }

    public List<Integer> inputWinningNumber() {
        String input = input("당첨 번호를 입력해 주세요.");
        return Stream.of(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int inputBonusNumber() {
        String input = input("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(input);
    }

    private void validateIsNumber(String input) {
        if (!NUMBER_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
        }
    }
}

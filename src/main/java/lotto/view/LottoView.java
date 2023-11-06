package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoView {
    public LottoView() {

    }
    // TODO : 검증 단계는 model이나 controller에서 처리하도록 수정
    public int inputMoney() {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            int money = Integer.parseInt(Console.readLine());
            if (money < 1000 || money % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위의 정수여야 합니다.");
            }
            return money;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액으로 숫자를 입력해야 합니다.");
        }
    }

    // TODO: 예외처리 부분 구현 / model이나 controller에서 처리하도록 수정
    public List<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요. (쉼표로 구분)");
        String input = Console.readLine();
        List<Integer> winningNumbers = Stream.of(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return winningNumbers;
    }


    public int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
        // TODO: 예외처리
    }

}

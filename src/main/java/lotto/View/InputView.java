package lotto.View;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    public String inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public List<Integer> inputWinningNum() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winningNumber = new ArrayList<>();;

        String inputLotto = Console.readLine();
        String playerLottoList[] = inputLotto.split(",");
        for(String playerLotto : playerLottoList) {
            winningNumber.add(Integer.parseInt(playerLotto));
        }
        return winningNumber;
    }

    public Integer inputBonusNum() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }
}

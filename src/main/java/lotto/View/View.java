package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.LottoRanking;
import lotto.domain.Lotto;

import java.util.Arrays;
import java.util.List;

public class View {

    public Integer getPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String userInput = Console.readLine();
        return Integer.parseInt(userInput);
    }

    public void printIssuanceLotto(List<Lotto> userLottos) {
        System.out.println(userLottos.size() + "개를 구매했습니다.");
        for(Lotto lotto : userLottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public String getWinnerNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String userInput = Console.readLine();
        return userInput;
    }

    public Integer getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String userInput = Console.readLine();
        return Integer.parseInt(userInput);
    }
}

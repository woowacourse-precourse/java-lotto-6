package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import static lotto.model.Constant.*;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import lotto.model.Lottos;
import lotto.util.ExceptionUtils;
import lotto.model.Lotto;
import lotto.model.BonusNumber;
import lotto.model.LottoPrice;
import lotto.model.Ranking;
public class Views {

    public static void valString(String inputValue) {
        for (char c : inputValue.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException(ExceptionUtils.NOT_INTEGER_ERROR.getErrorMessage());
            }
        }
    }
    public static LottoPrice inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String price = Console.readLine();
        try {
            valString(price);
            return new LottoPrice(Integer.parseInt(price));
        }
        catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputPrice();
        }
    }

    public static Lotto inputWinningNumber() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        String[] inputs = input.split(",");
        List<Integer> winningNum = new ArrayList<>();
        try {
            for(String s : inputs) {
                valString(s);
                winningNum.add(Integer.parseInt(s));
            }
            return new Lotto(winningNum);
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinningNumber();
        }
    }

    public static BonusNumber inputBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String bonusNum = Console.readLine();
        try {
            valString(bonusNum);
            return new BonusNumber(Integer.parseInt(bonusNum));
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBonusNumber();
        }
    }

    public static void printLotto(Lotto lotto) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i < LOTTO_SIZE; i++) {
            sb.append(lotto.getNumbers().get(i));
            if(i < LOTTO_SIZE - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        System.out.println(sb);
    }

    public static void printLottos(Lottos lottos) {
        for(Lotto lotto : lottos.getLottos()) {
            printLotto(lotto);
        }
    }

    public static void printLottoCount(int lottoCount) {
        System.out.println("\n" + lottoCount + "개를 구매했습니다.");
    }
    public static void printIncome(double income) {
        System.out.printf("총 수익률은 %.1f%%입니다.", income);
    }

    public static void printResult(EnumMap<Ranking, Integer> result) {
        System.out.println("\n당첨 통계\n---");
        result.forEach((ranking, count) -> {
            if (ranking == Ranking.SECOND) { //보너스 숫자 체크
                System.out.printf("%d개 일치, 보너스 볼 일치 (%,d원) - %d개%n", ranking.getMatchCount(), ranking.getWinningMoney(), count);
                return;
            }
            if (ranking == Ranking.NONE) {
                return;
            }
            System.out.printf("%d개 일치 (%,d원) - %d개%n", ranking.getMatchCount(), ranking.getWinningMoney(), count);
        });
    }
}

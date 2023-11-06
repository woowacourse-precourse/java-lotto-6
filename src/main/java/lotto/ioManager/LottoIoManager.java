package lotto.ioManager;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Rank;
import lotto.exception.ExceptionManager;

public class LottoIoManager implements IoManager {

    public int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return stringToInt(read());
    }

    public void displayLottosCnt(int cnt) {
        printEmptyLine();
        System.out.println(cnt + "개를 구매했습니다.");
    }

    public void displayLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
    }

    public List<Integer> inputLotto() {
        printEmptyLine();
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] input = read().split(",");
        List<Integer> lottoNumbers = new ArrayList<>();
        for (String str : input) {
            lottoNumbers.add(stringToInt(str));
        }
        return lottoNumbers;
    }

    public int inputBonus() {
        printEmptyLine();
        System.out.println("보너스 번호를 입력해 주세요.");
        return stringToInt(read());
    }

    public void displayWinningResult(Map<Rank, Integer> result) {
        printEmptyLine();
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Entry<Rank, Integer> entry : result.entrySet()) {
            if (entry.getKey().equals(Rank.NOPE)) {
                continue;
            }
            System.out.println(Rank.getMsg(entry.getKey()) + " - " + entry.getValue() + "개");
        }
    }

    private void printEmptyLine() {
        System.out.println();
    }

    public void displayProfitRate(String profitRate) {
        System.out.println("총 수익률은 " + profitRate + "입니다.");
    }

    private int stringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException) {
            ExceptionManager.throwIllegalArgumentExceptionWithMsg("숫자를 입력해야 합니다.");
            return -1;
        }
    }

    @Override
    public String read() {
        return Console.readLine();
    }
}

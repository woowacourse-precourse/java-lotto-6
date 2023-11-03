package lotto.ioManager;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.Lottos;

public class LottoIoManager implements IoManager{

    public int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return stringToInt(read());
    }

    public void displayLottosCnt(int cnt) {
        System.out.println(cnt+"개를 구매했습니다.");
    }

    public void displayLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
    }

    public List<Integer> inputLotto() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] input = read().split(",");
        List<Integer> lottoNumbers = new ArrayList<>();
        for (String str : input) {
            lottoNumbers.add(stringToInt(str));
        }
        return lottoNumbers;
    }

    public int inputBonus() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return stringToInt(read());
    }

    public void displayWinningResult() {
        System.out.println("결과");
    }

    private int stringToInt(String input) {
        try {
            return stringToInt(input);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }
    }

    @Override
    public String read() {
        return Console.readLine();
    }
}

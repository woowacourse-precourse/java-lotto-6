package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LottoService {

    public Integer moneyInput() {
        System.out.print("구입금액을 입력해 주세요 : ");
        return Integer.parseInt(Console.readLine());
    }

    public int lottoCount(int moneyInput) {
        int lottoCount = moneyInput / 1000;
        System.out.printf("%d개를 구입했습니다.\n", lottoCount);
        return lottoCount;
    }

    public List<Integer> randomNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        numbers.sort(Comparator.naturalOrder());
        return numbers;
    }

    public List<Lotto> lottoIssuance(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i <lottoCount; i++) {
            Lotto lotto = new Lotto(randomNumber());
            lottos.add(lotto);
        }
        return lottos;
    }

    public void lottosPrint(List<Lotto> lottos) {
        for (int i = 0; i <lottos.size(); i++) {
            System.out.println(lottos.get(i).toString());
        }
    }

    public String[] winningNumberInput() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] winningNumber = Console.readLine().split(",");
        return winningNumber;
    }

    public int bonusNumberInput() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());

    }




}

package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private List<Integer> WinningNum;
    private int bonus;
    private int maxLotto;
    private List<Lotto> lottos;


    public void run() {

    }

    public void decideMaxLotto(User user) {
        int userAmount = user.getAmount();
        this.maxLotto = userAmount / 1000;
        LottoInfo();
    }

    public void LottoInfo() {
        System.out.printf("%d개를 구매했습니다.\n", this.maxLotto);
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public void lottery() {
        lottos = new ArrayList<>(maxLotto);
        for (int i = 0; i < lottos.size(); i++) {
            lottos.add(new Lotto(generateLottoNum()));
        }
    }

    public List<Integer> generateLottoNum() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }

    public void insertWinningNum() {
        WinningNum = new ArrayList<>(6);
        System.out.println("당첨 번호를 입력해 주세요.");
        String Winning = Console.readLine();
        String[] numbers = parseNumbers(Winning);
        saveWinningNum(numbers);
    }

    public String[] parseNumbers(String Numbers) {
        String[] numbers = Numbers.split(",");
        return numbers;
    }

    public void saveWinningNum(String[] numbers) {
        for (String num : numbers) {
            this.WinningNum.add(Integer.parseInt(num));
        }
    }
}

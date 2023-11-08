package lotto.game;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.result.Result;
import lotto.result.Winner;
import lotto.util.InputUtil;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class GameService {
    private static final GameService instance = new GameService();
    private final List<Lotto> lottoList;
    private Lotto prize;
    private final int[] result;
    private int bonus;
    private long total;
    private int money;

    private GameService() {
        lottoList = new ArrayList<>();
        result = new int[5];
        total = 0;
    }

    public static GameService getInstance() {
        return instance;
    }

    public void runLotto() {

        money = getMoney();

        int numLotto = money / 1000;

        System.out.println("\n" + numLotto + "개를 구매했습니다.");

        for (int i = 0; i < numLotto; i++) {
            lottoList.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }

        for (Lotto lotto : lottoList) {
            System.out.println(lotto);
        }
        System.out.println();

        prize = getPrize();

        System.out.println();

        bonus = getBonus();


        checkLotto();

        calcResult();
    }

    private void calcResult() {
        StringBuilder sb = new StringBuilder();
        sb.append("당첨 통계").append("\n").append("---").append("\n");
        for(Winner winner:Winner.values()){
            sb.append(winner.getText()).append(" - ").append(result[winner.getIdx()]).append("개").append("\n");
            total += result[winner.getIdx()]*winner.getMoney();
        }

        double per = (double) total / (double) money * 100.0;

        NumberFormat formatter = new DecimalFormat("#.##");

        String output = formatter.format(Math.round(per * 100.0) / 100.0);

        sb.append("총 수익률은 ").append(output).append("%입니다.");

        System.out.println(sb.toString());
    }

    private void checkLotto() {
        for (Lotto lotto : lottoList) {
            Result tempResult = lotto.checkPrize(prize, bonus);
            int tempChk = checkResult(tempResult);
            if (tempChk != -1) result[tempChk]++;
        }
    }

    private int checkResult(Result result) {
        if (result.getChecks() == 3) return 0;
        if (result.getChecks() == 4) return 1;
        if (result.getChecks() == 5 && !result.isBonus()) return 2;
        if (result.getChecks() == 5 && result.isBonus()) return 3;
        if (result.getChecks() == 6) return 4;
        return -1;
    }

    private Lotto getPrize() {
        try {
            System.out.println("당첨 번호를 입력해 주세요.");
            String input = Console.readLine();
            List<Integer> numbers = InputUtil.inputNumbers(input);

            Lotto lotto = new Lotto(numbers);

            lotto.checkNumber();

            return lotto;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPrize();
        }
    }

    private int getBonus() {
        try {
            System.out.println("보너스 번호를 입력해 주세요.");
            String input = Console.readLine();
            int num = Integer.parseInt(input);
            if (prize.isContains(num)) throw new IllegalArgumentException("[ERROR] 보너스 번호는 입력된 숫자 6개 중에 없어야 합니다.");
            if (num > 45 || num < 1) throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            return num;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBonus();
        }
    }

    private int getMoney() {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            String input = Console.readLine();
            int result = parseInt(input);
            if (result % 1000 != 0) throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원으로 나누어 떨어져야 합니다.");
            return result;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getMoney();
        }
    }

    private int parseInt(String input){
        try {
            return Integer.parseInt(input);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자로만 이루어져야 합니다.");
        }
    }
}

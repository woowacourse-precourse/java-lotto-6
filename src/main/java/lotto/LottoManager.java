package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class LottoManager {
    private int purchaseAmount;
    private List<Lotto> lotties;
    private List<Integer> winningNumbers;
    private int bonusNumber;
    private int[] winningCnt = new int[5];
    private int totalAmount = 0;

    enum winningType {
        THREE(5000),
        FOUR(50000),
        FIVE(1500000),
        FIVE_ONE(30000000),
        SIX(2000000000);

        private final int amount;

        private winningType(int amount) {
            this.amount = amount;
        }

        public int getAmount() {
            return this.amount;
        }
    }

    public void inputLottoPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        purchaseAmount = Integer.parseInt(Console.readLine());
    }

    public void createLotties() {
        lotties = new ArrayList<>();
        NumberGenerator numberGenerator = new NumberGenerator();
        int lottoPrice = 1000;
        for(int i = 0; i < this.purchaseAmount/lottoPrice; i++) {
            List<Integer> numbers = numberGenerator.createRandomNumbers();
            lotties.add(new Lotto(numbers));
        }
    }

    public void printLotties() {
        for(Lotto l:lotties) {
            l.printLotto();
        }
    }

    public void inputLottoWinningNumbers() {
        winningNumbers = new ArrayList<>();
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] numbers = Console.readLine().split(",");
        for (String number : numbers) {
            this.winningNumbers.add(Integer.parseInt(number));
        }
        System.out.println("보너스 번호를 입력해 주세요.");
        this.bonusNumber = Integer.parseInt(Console.readLine());
    }

    public void totalLotto() {
        for(Lotto l:lotties) {
            List<Integer> result = l.compare(winningNumbers, bonusNumber);
            winningAmount(result.get(0), result.get(1));
        }
    }

    public int winningAmount(int winCnt, int bonusCnt) {
        if(winCnt+bonusCnt == 3) {
            winningCnt[0]++;
            return winningType.THREE.amount;
        }
        if(winCnt+bonusCnt == 4) {
            winningCnt[1]++;
            return winningType.FOUR.amount;
        }
        if(winCnt+bonusCnt == 5) {
            winningCnt[2]++;
            return winningType.FIVE.amount;
        }
        if(winCnt == 5 && bonusCnt == 1) {
            winningCnt[3]++;
            return winningType.FIVE_ONE.amount;
        }
        if(winCnt == 6) {
            winningCnt[4]++;
            return winningType.SIX.amount;
        }
        return 0;
    }
}

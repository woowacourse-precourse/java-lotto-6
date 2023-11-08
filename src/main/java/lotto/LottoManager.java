package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class LottoManager {
    private int purchaseAmount;
    private List<Lotto> lotties;
    private List<Integer> winningNumbers;
    private int bonusNumber;
    private int[] winningCnt;
    private int totalAmount;

    enum winningType {
        THREE("3개 일치", 5000),
        FOUR("4개 일치", 50000),
        FIVE("5개 일치", 1500000),
        FIVE_ONE("5개 일치, 보너스 볼 일치", 30000000),
        SIX("6개 일치", 2000000000);

        private final String num;
        private final int amount;

        private winningType(String num, int amount) {
            this.num = num;
            this.amount = amount;
        }

        public String getNum() {
            return this.num;
        }

        public int getAmount() {
            return this.amount;
        }
    }

    public void inputLottoPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            purchaseAmount = Integer.parseInt(Console.readLine());
        }catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자를 입력해주세요.");
        }
    }

    public void createLotties() {
        lotties = new ArrayList<>();
        NumberGenerator numberGenerator = new NumberGenerator();
        int lottoPrice = 1000;
        if(this.purchaseAmount%lottoPrice != 0) {
            System.out.println("[ERROR] 1000단위로 구매금액을 입력해주세요.");
            throw new IllegalArgumentException();
        }
        int lottoNum = this.purchaseAmount/lottoPrice;
        System.out.println(lottoNum+"개를 구매했습니다.");
        for(int i = 0; i < lottoNum; i++) {
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
        winningCnt = new int[5];
        totalAmount = 0;
        for(Lotto l:lotties) {
            List<Integer> result = l.compare(winningNumbers, bonusNumber);
            totalAmount += winningAmount(result.get(0), result.get(1));
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

    public void printWinning() {
        System.out.println("당첨 통계");
        System.out.println("---");
        int idx = 0;
        for(winningType type : winningType.values()) {
            DecimalFormat decFormat = new DecimalFormat("###,###");
            System.out.println(type.num + " (" + decFormat.format(type.amount) + "원) - " + winningCnt[idx++] + "개");
        }
        double rate = (double)this.totalAmount/purchaseAmount*100;
        System.out.println("총 수익률은 "+ rate + "%입니다.");
    }
}

package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    public String inputPrice;
    public float totalProfit = 0;
    public int firstPrize = 0;
    public int secondPrize = 0;
    public int thirdPrize = 0;
    public int fourthPrize = 0;
    public int fifthPrize = 0;

    public void setInputPrice() {
        while (true) {
            try {
                String input = Console.readLine();
                Integer.parseInt(input);
                this.inputPrice = input;
                break;
            } catch (NumberFormatException e) {
                System.out.print("[ERROR]");
            }
        }
    }

    public void countPrize(int prize) {
        if (prize == 1) {
            firstPrize++;
        }
        if (prize == 2) {
            secondPrize++;
        }
        if (prize == 3) {
            thirdPrize++;
        }
        if (prize == 4) {
            fourthPrize++;
        }
        if (prize == 5) {
            fifthPrize++;
        }
    }

    public void run() {
        System.out.println("구입금액을 입력해 주세요.");
        setInputPrice();
        User user = new User(this.inputPrice);
        System.out.printf("\n%d개를 구매했습니다.\n", user.AMOUNT);
        for (int i = 0; i < user.AMOUNT; i++) {
            System.out.println(user.tickets.get(i));
        }
        SingleGame singleGame = new SingleGame();
        singleGame.setGame();
        for (int i = 0; i < user.AMOUNT; i++) {
            singleGame.run(user.tickets.get(i));
            countPrize(singleGame.result);
            totalProfit += singleGame.profit;
        }
        System.out.println("당첨 통계\n---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", this.fifthPrize);
        System.out.printf("4개 일치 (50,000원) - %d개\n", this.fourthPrize);
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", this.thirdPrize);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", this.secondPrize);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", this.firstPrize);
        float profitRate = totalProfit / Integer.parseInt(user.price) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }
}

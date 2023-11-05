package lotto.view;

import java.util.List;

public class OutputView {
    StringBuilder cache = new StringBuilder();
    private final String boughtMessage = "\n%d개를 구매했습니다.\n";
    private final String prizingMessage = "\n당첨 통계\n---\n";
    private final String prizingMessageTemplate = "%s (%s원) - %d개\n";
    private final String profitRatioMessage = "총 수익률은 %.1f%%입니다.";
    private final String buyErrorMessage = "[ERROR] 금액은 1000원 단위이며, 1장부터 구매할 수 있습니다.\n";
    private final String prizingNumberErrorMessage = "[ERROR] 1~45까지의 중복되지 않는 수 6개를 입력해 주세요.\n[ERROR] 각 숫자는 콤마(,)로 구분해 주세요. 공백은 허용하지 않습니다.";
    private final String bonusNumberErrorMessage = "[ERROR] 당첨 번호와 중복되지 않는 1~45까지의 숫자를 입력해 주세요.";


    public void displayBoughtTickets(List<String> tickets) {
        initializaCache();
        buildBoughtString(tickets);
        print();
    }

    public void displayBuyError() {
        initializaCache();
        addToCache(buyErrorMessage);
        print();
    }

    public void displayWinningError() {
        initializaCache();
        addToCache(prizingNumberErrorMessage);
        print();
    }

    public void displayBonusError() {
        initializaCache();
        addToCache(bonusNumberErrorMessage);
        print();
    }

    public void displayRankCounts(List<Integer> counts) {
        initializaCache();
        buildCountsString(counts);
        print();
    }


    public void displayProfitRatio(double profitRatio) {
        initializaCache();
        String string = String.format(profitRatioMessage, profitRatio);
        addToCache(string);
        print();
    }


    private void buildCountsString(List<Integer> counts) {
        addToCache(prizingMessage);
        String fifthRankMessage = String.format(prizingMessageTemplate, "3개 일치", "5,000", counts.get(4));
        String fourthRankMessage = String.format(prizingMessageTemplate, "4개 일치", "50,000", counts.get(3));
        String thirdRankMessage = String.format(prizingMessageTemplate, "5개 일치", "1,500,000", counts.get(2));
        String secondRankMessage = String.format(prizingMessageTemplate, "5개 일치, 보너스 볼 일치", "30,000,000",
                counts.get(1));
        String firstRankMessage = String.format(prizingMessageTemplate, "6개 일치", "2,000,000,000", counts.get(0));
        addToCache(fifthRankMessage);
        addToCache(fourthRankMessage);
        addToCache(thirdRankMessage);
        addToCache(secondRankMessage);
        addToCache(firstRankMessage);
    }

    private void buildBoughtString(List<String> tickets) {
        int amount = tickets.size();
        String message = String.format(boughtMessage, amount);
        addToCache(message);
        for (String ticket : tickets) {
            addToCache(ticket);
            addToCache("\n");
        }
    }

    private void initializaCache() {
        cache.setLength(0);
    }

    private void addToCache(String string) {
        cache.append(string);
    }

    private void print() {
        System.out.print(cache);
    }

}

package lotto.view;

import java.util.List;

public class OutputView {
    StringBuilder cache = new StringBuilder();
    private final String boughtMessage = "\n%d개를 구매했습니다.\n";


    public void displayBoughtTickets(List<String> tickets) {
        initializaCache();

        int amount = tickets.size();
        String message = String.format(boughtMessage, amount);
        addToCache(message);
        for (String ticket : tickets) {
            addToCache(ticket);
            addToCache("\n");
        }
        print();
    }


    private void initializaCache() {
        cache.setLength(0);
    }

    private void addToCache(String string) {
        cache.append(string);
    }

    private void print() {
        System.out.println(cache);
    }

}

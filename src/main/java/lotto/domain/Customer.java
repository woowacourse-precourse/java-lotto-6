package lotto.domain;


import constant.Rank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.ConsoleIO;
import lotto.Lotto;
import org.mockito.internal.util.StringUtil;
import util.FormatUtil;

public class Customer {

//    private final List<Lotto> myOrders;
    private final int myMoney;
    private int myLottoTicket;
    private List<Lotto> myOrders;

    private final Map<Rank, Integer> myRanks;

    private int myTotalPrice;


    public Customer(int myMoney) {
        this.myMoney = myMoney;
        this.myLottoTicket = 0;
        this.myTotalPrice = 0;
        this.myOrders = new ArrayList<>();
        this.myRanks = new HashMap<>();
        Arrays.stream(Rank.values())
                        .forEach(rank -> {
                            myRanks.put(rank, 0);
                        });
    }


    public void buyLotto(Seller seller) {
        myLottoTicket = seller.sellLottoTicket(myMoney);
        myOrders = seller.issueLotto(myLottoTicket);
    }

    public void showMyOrders() {
        System.out.println("\n" + myLottoTicket + "개를 구매했습니다.");
        myOrders.forEach(lotto ->  System.out.println(lotto.toString()));
        System.out.println("");
    }

    private LottoOffice findLottoOffice() {
        return new LottoOffice();
    }

    private void checkMyRank(LottoOffice lottoOffice) {
        for (Lotto lotto : myOrders) {
            Rank rank = lottoOffice.calRank(lotto);
            myRanks.put(rank, myRanks.get(rank) +1);
        }

        printMyRank();
    }


    public void checkMyWiningStatus() {
        LottoOffice lottoOffice = findLottoOffice();

        System.out.println("\n당첨 통계");
        System.out.println("---");

        checkMyRank(lottoOffice);

        System.out.println("총 수익률은 "+ calMyPriceRate() +"%입니다.");
    }

    private String calMyPriceRate() {
        myRanks.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> {
                    if (entry.getValue() > 0) {
                        myTotalPrice += (entry.getKey().getPrice()) * entry.getValue();
                    }
                });

        return String.format("%.1f", (myTotalPrice / (double) myMoney)* 100);
    }

    private void printMyRank(){
        myRanks.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .filter(entry -> !entry.getKey().equals(Rank.NONE))
                .forEach(entry -> {
                    System.out.println(entry.getKey().toString() + entry.getValue() +"개");
                });

    }




}

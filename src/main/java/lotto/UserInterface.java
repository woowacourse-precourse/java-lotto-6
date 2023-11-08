package lotto;

import java.util.*;
import java.util.stream.Collectors;

public class UserInterface {
    private Customer customer;
    private Raffle raffle;
    Map<Raffle.LottoRank, Integer> countByRank;
    List<Raffle.LottoRank> ranks;

    public UserInterface(){
        customer=new Customer();
        raffle = new Raffle();
        countByRank=new HashMap<Raffle.LottoRank, Integer>();
        ranks = new ArrayList<>();
    }
    public int[][] makeLotto(){
        int price = customer.inputpprice();
        customer.forraffle();
        int[][] lottos = raffle.showLottes(customer);
        System.out.println("당첨 통계");
        System.out.println("---");
        return lottos;
    }
    public void makingRank(int[][] lottos, Lotto userLotto, int bonus){
        for (int[] lottoNumbers : lottos) {
            List<Integer> lottoList = Arrays.stream(lottoNumbers)
                    .boxed()
                    .collect(Collectors.toList());
            Lotto lotto = new Lotto(lottoList);
            Raffle.LottoRank rank = raffle.rankLotto(lotto, userLotto, bonus);
            countByRank.put(rank, countByRank.getOrDefault(rank, 0) + 1);
            ranks.add(rank);
        }
    }
    public void printResults() {
        int price = customer.getPrice();
        System.out.println("3개 일치 (5,000원) - " + countByRank.getOrDefault(Raffle.LottoRank.FIFTH, 0) + "개");
        System.out.println("4개 일치 (50,000원) - " + countByRank.getOrDefault(Raffle.LottoRank.FOURTH, 0) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + countByRank.getOrDefault(Raffle.LottoRank.THIRD, 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + countByRank.getOrDefault(Raffle.LottoRank.SECOND, 0) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + countByRank.getOrDefault(Raffle.LottoRank.FIRST, 0) + "개");
        String returnRate = raffle.calculateReturnRate(ranks, price);
        System.out.println(returnRate);
    }
    public void doLotto(){
        int[][] lottos=makeLotto();
        makingRank(lottos,customer.getLotto(),customer.getbonus());
        printResults();
    }


}

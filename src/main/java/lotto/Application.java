package lotto;

import java.util.*;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        Customer customer = new Customer();
        Raffle raffle = new Raffle();
        //int[][] lottos = raffle.showLottes();
        int price = customer.inputpprice();
        customer.forraffle();
        int[][] lottos = raffle.showLottes(customer);
        Lotto userLotto = customer.getLotto();
        int bonus = customer.getbonus();


        // 로또들을 생성하고 출력한다.

        System.out.println("당첨 통계");
        System.out.println("---");
        // 각 생성된 로또에 대해 등수를 확인하고 출력한다.
        Map<Raffle.LottoRank, Integer> countByRank = new HashMap<>();
        List<Raffle.LottoRank> ranks = new ArrayList<>();

        for (int[] lottoNumbers : lottos) {
            List<Integer> lottoList = Arrays.stream(lottoNumbers)
                    .boxed()
                    .collect(Collectors.toList());
            Lotto lotto = new Lotto(lottoList);
            Raffle.LottoRank rank = raffle.rankLotto(lotto, userLotto, bonus);

            countByRank.put(rank, countByRank.getOrDefault(rank, 0) + 1);
            ranks.add(rank);
        }

        System.out.println("3개 일치 (5,000원) - " + countByRank.getOrDefault(Raffle.LottoRank.FIFTH, 0) + "개");
        System.out.println("4개 일치 (50,000원) - " + countByRank.getOrDefault(Raffle.LottoRank.FOURTH, 0) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + countByRank.getOrDefault(Raffle.LottoRank.THIRD, 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + countByRank.getOrDefault(Raffle.LottoRank.SECOND, 0) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + countByRank.getOrDefault(Raffle.LottoRank.FIRST, 0) + "개");
        String returnRate = raffle.calculateReturnRate(ranks, price);
        System.out.println(returnRate);
    }
}

package lotto.view;

import lotto.domain.Rank;


public class Result {
    public void winningStatistic() {

        Guest guest = new Guest();
        int money = Rank.FIFTH.getNumber() * Rank.FIFTH.getPrizeMoney() +
                Rank.FORTH.getNumber() * Rank.FORTH.getPrizeMoney() +
                Rank.THIRD.getNumber() * Rank.THIRD.getPrizeMoney() +
                Rank.SECOND.getNumber() * Rank.SECOND.getPrizeMoney() +
                Rank.FIRST.getNumber() * Rank.FIRST.getPrizeMoney();
        float profit = (float) guest.price / money;


        System.out.println(Rank.FIFTH.getAgreementNumber() + Rank.FIFTH.getNumber() + "개");
        System.out.println(Rank.FORTH.getAgreementNumber() + Rank.FORTH.getNumber() + "개");
        System.out.println(Rank.THIRD.getAgreementNumber() + Rank.THIRD.getNumber() + "개");
        System.out.println(Rank.SECOND.getAgreementNumber() + Rank.SECOND.getNumber() + "개");
        System.out.println(Rank.FIRST.getAgreementNumber() + Rank.FIRST.getNumber() + "개");
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.print("총 수익률은 ");
        System.out.printf("%.1f", profit);
        System.out.print("%입니다.");

    }
}

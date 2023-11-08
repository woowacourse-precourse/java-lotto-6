package lotto;

import java.util.*;

public class Counter {
    Map<ERating, Integer> counts = new HashMap<>();
    private int ticketCount;
    public Counter(List<Lotto> lottoWallet, WinningNumber winningNumber) {
        counts.put(ERating.eFIFTH, 0);
        counts.put(ERating.eFOURTH, 0);
        counts.put(ERating.eTHIRD, 0);
        counts.put(ERating.eSECOND, 0);
        counts.put(ERating.eFIRST, 0);
        ticketCount = lottoWallet.size();
        for(Lotto lottoTicket:lottoWallet) countRatings(winningNumber.count(lottoTicket));
    }

    public void calculate() {
        System.out.println(ERating.eFIFTH.getValue()+counts.get(ERating.eFIFTH)+"개");
        System.out.println(ERating.eFOURTH.getValue()+counts.get(ERating.eFOURTH)+"개");
        System.out.println(ERating.eTHIRD.getValue()+counts.get(ERating.eTHIRD)+"개");
        System.out.println(ERating.eSECOND.getValue()+counts.get(ERating.eSECOND)+"개");
        System.out.println(ERating.eFIRST.getValue()+counts.get(ERating.eFIRST)+"개");
        System.out.println("총 수익률은 "+(float)(counts.get(ERating.eFIFTH)*ERating.eFIFTH.getReward()
                +counts.get(ERating.eFOURTH)*ERating.eFOURTH.getReward()
                +counts.get(ERating.eTHIRD)*ERating.eTHIRD.getReward()
                +counts.get(ERating.eSECOND)*ERating.eSECOND.getReward()
                +counts.get(ERating.eFIRST)*ERating.eFIRST.getReward())/(ticketCount*10)+"%입니다.");
    }
    public void countRatings(ERating rating) {
        counts.put(rating, counts.getOrDefault(rating, 0) + 1);
    }
}

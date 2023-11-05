package lotto.service;

import lotto.console.Output;

import java.util.ArrayList;
import java.util.List;

public class LottoShop {

    public static void buyLotto(int price){
        int ticketNum = price / 1000;
        ArrayList<List<Integer>> lottoTickets = new ArrayList<>();

        for(int i = 0;i < ticketNum; i++){
            lottoTickets.add(LottoGenerate.generate());
        }

        Output.printTickets(lottoTickets, ticketNum);
    }



}

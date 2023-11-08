package lotto.service;

import lotto.util.RandomNumberGenerate;

import java.util.ArrayList;
import java.util.List;

public class LottoNumberGenerate {
    RandomNumberGenerate randomNumberGenerate = new RandomNumberGenerate();
    public List<int[]> getTickets(int ticketQuantity) {
        List<int[]> tickets = new ArrayList<>();
        for (int buy = 1; buy <= ticketQuantity; buy++) {
            int[] numbers = new int[6];
            numbers = randomNumberGenerate.getRandomNumber().stream()
                    .mapToInt(i -> i)
                    .toArray();
            tickets.add(numbers);
        }
        return tickets;
//        List<List<Integer>> lottoNumbers = new ArrayList<List<Integer>>();
//        for (int i = 0; i < lottoTicket; i++) {
//            int[] lottoNumber = new int[6];
//            lottoNumbers = randomNumberGenerate.getRandomNumber().stream()
//                                .mapToInt(i -> i)
//                                .toArray();
//
//                    Arrays. (randomNumberGenerate.getRandomNumber());
//            lottoNumbers.add();
//        }
//        return lottoNumbers;
    }
}

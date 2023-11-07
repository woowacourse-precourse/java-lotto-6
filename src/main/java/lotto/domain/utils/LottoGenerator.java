package lotto.domain.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.model.LottoTicket;
import lotto.domain.model.LottoTicketList;

public class LottoGenerator {

    public static LottoTicketList generateLottoTicketList(int sizeOfList){
        List<LottoTicket> lottoTickets = IntStream.rangeClosed(1, sizeOfList)
                .mapToObj(index -> generateRandomNumbers())
                .map(LottoGenerator::sortRandomNumbersByAscending)
                .map(LottoGenerator::generateLottoTicket)
                .toList();
        return new LottoTicketList(lottoTickets);
    }

    private static List<Integer> generateRandomNumbers(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    private static List<Integer> sortRandomNumbersByAscending(List<Integer> unsortedRandomNumbers){
        return unsortedRandomNumbers.stream()
                .sorted()
                .toList();
    }
    private static LottoTicket generateLottoTicket(List<Integer> inputNumbers){
        return new LottoTicket(inputNumbers);
    }
}

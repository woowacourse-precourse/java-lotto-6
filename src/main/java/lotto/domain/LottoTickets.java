package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTickets {
    private final List<List<Integer>> lottoTickets;

    public LottoTickets(int ticket){
        List<List<Integer>> lottoTickets = new ArrayList<>();
        for(int cnt=0;cnt<ticket;cnt++){
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(numbers);
            lottoTickets.add(numbers);
        }
        this.lottoTickets = lottoTickets;
    }

    public List<List<Integer>> getLottoTickets(){
        return lottoTickets;
    }

    public int[] createLottoRank(Lotto lotto, int bonus){
        // 인덱스번호 == 등수
        int[] lottoRank = new int[6];
        for(List<Integer> numbers : lottoTickets){
            int correct = lotto.countCorrect(numbers, bonus);
            if(correct == 3) lottoRank[5]++;
            if(correct == 4) lottoRank[4]++;
            if(correct == 5) lottoRank[3]++;
            if(correct == 7) lottoRank[2]++; // 2등이면 7
            if(correct == 6) lottoRank[1]++;
        }
        return lottoRank;
    }
}

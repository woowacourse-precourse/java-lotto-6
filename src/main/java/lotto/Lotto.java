package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        redundancyCheck(numbers);
        this.numbers = numbers;
        Collections.sort(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 정확하게 6개의 숫자가 입력되어야 합니다.");
        }
    }

    private void redundancyCheck(List<Integer> numbers){
        List<Integer> check = numbers.stream().distinct().collect(Collectors.toList());
        try {
            validate(check);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자는 모두 달라야 합니다.");
        }
    }
    
    public LottoRank rankJudgement(Lotto winning_numbers, int bonus_number){
        int cnt = 0;
        LottoRank lottoRank;
        for (Integer winning_num : winning_numbers.getNumbers()) {
            if (numberCheck(winning_num)){
                cnt += 1;
            }
        }
        lottoRank = intToLottoRank(cnt);
        if (lottoRank == LottoRank.THIRD && numberCheck(bonus_number)){
            lottoRank = LottoRank.SECOND;
        }
        return lottoRank;
    }

    private LottoRank intToLottoRank(int cnt){
        if (cnt == 6){
            return LottoRank.FIRST;
        }
        if (cnt == 5){
            return LottoRank.THIRD;
        }
        if (cnt == 4){
            return LottoRank.FOURTH;
        }
        if (cnt == 3){
            return LottoRank.FIFTH;
        }
        return LottoRank.OUT;
    }

    public boolean numberCheck(int target){
        if (numbers.contains(target)){
            return true;
        }
        return false;
    }

    public List<Integer> getNumbers(){
        return numbers;
    }
}

enum LottoRank{
    OUT("0", 0),
    FIFTH("3개 일치 (5,000원) - ", 5000), 
    FOURTH("4개 일치 (50,000원) - ", 50000), 
    THIRD("5개 일치 (1,500,000원) - ", 1500000), 
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - ", 30000000), 
    FIRST("6개 일치 (2,000,000,000원) - ", 2000000000);
    
    final private String comment;
    final private int prize;
    LottoRank(String comment, int prize) {
		this.comment = comment;
        this.prize = prize;
	}
	
	public String getComment() {
		return comment;
	}

    public int getPrize(){
        return prize;
    }
}

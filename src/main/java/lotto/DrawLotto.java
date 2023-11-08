package lotto;

import java.util.List;

public class DrawLotto {

    private final LottoList lottoList;
    private final CorrectLotto correct_lotto;

    public double getProfitPercentage() {
        return profitPercentage;
    }

    private double profitPercentage = 0;

    public DrawLotto(LottoList lottoList, CorrectLotto correct_lotto) {
        this.lottoList = lottoList;
        this.correct_lotto = correct_lotto;
    }

    public void countRank(int count, boolean check_bonus){
        if(!check_bonus && count >= 3){
            Rank.values()[count - 3].increaseCount();
            return;
        }

        if(check_bonus && count == 5){
            Rank.values()[count - 1].increaseCount();
        }
    }

    public void compareNumbers(List<Integer> target_numbers){
        int count = 0;
        boolean check_bonus = false;

        List<Integer> correct_numbers = correct_lotto.getCorrect_lotto().getNumbers();
        for(Integer target_number : target_numbers){
            if(correct_numbers.contains(target_number)){
                count++;
                continue;
            }
            if(target_number == correct_lotto.getBonus()){
                check_bonus = true;
            }
        }
        countRank(count, check_bonus);
    }

    public void draw() {
        for(Lotto lotto : lottoList.getLottoList()){
            compareNumbers(lotto.getNumbers());
        }
    }

    public void calculateProfitPercentage(int purchaseAmount){
        for (Rank rank : Rank.values()) {
            profitPercentage += rank.getCount() * rank.getPrize();
        }
        profitPercentage /= purchaseAmount;
        profitPercentage = Math.round(profitPercentage * 1000) / 10.0;
    }

    public void printStatistics(){
        System.out.println("\n당첨 통계\n---");

        for(int i = 0; i < 3; i++){
            System.out.println(Rank.values()[i].getExplanation() + " - " + Rank.values()[i].getCount() + "개");
        }
        for(int i = 4; i >= 3; i--){
            System.out.println(Rank.values()[i].getExplanation() + " - " + Rank.values()[i].getCount() + "개");
        }
        System.out.println("총 수익률은 " + profitPercentage + "%입니다.");
    }
}

package lotto;

import java.util.ArrayList;

public class GetResult {
    public double _purchaseAmount;
    public int rank1 = 0;
    public int rank2 = 0;
    public int rank3 = 0;
    public int rank4 = 0;
    public int rank5 = 0;
    public double totalMoney = 0;
    public double earningsRate = 0;

    GetResult(InputNumber input){
        calculateResult(input);
        calculate();
        printResult();
    }

    public void calculateResult(InputNumber input){
        int rank = 0;
        _purchaseAmount = input.purchaseAmount;
        ArrayList<Lotto> _manyLotto =  input.severalLotto.manyLotto;
        Lotto _lottoAnswer = input.lottoAnswer;

        for (Lotto lotto : _manyLotto){
            rank = calculateMatchNumber(lotto, _lottoAnswer, input.bonusNumber);
            if(rank == 1){
                rank1 += 1;
            }
            if(rank == 2){
                rank2 += 1;
            }
            if(rank == 3){
                rank3 += 1;
            }
            if(rank == 4){
                rank4 += 1;
            }
            if(rank == 5){
                rank5 += 1;
            }
        }
    }


    public int calculateMatchNumber(Lotto random, Lotto answer, int bonus){
        int match = 0;
        int rank = 0;

        for (int num : answer.returnNumbers()) {
            if(random.returnNumbers().contains(num)){
                match += 1;
            }
        }

        if(match == 5){
            if(random.returnNumbers().contains(bonus)){
                rank = 2;
            }
        }

        if(match == 6){
            rank = 1;
        }
        if(match == 5){
            rank = 3;
        }
        if(match == 4){
            rank = 4;
        }
        if(match == 3){
            rank = 5;
        }

        return rank;
    }

    public void calculate(){
        totalMoney = 5000*rank5 + 50000*rank4 + 1500000*rank3
                + 30000000*rank2 + 2000000000*rank1;

        earningsRate = Math.round(totalMoney/_purchaseAmount*100*100)/100.0;

    }

    public void printResult(){
        System.out.println(ConstantCollection.STATISTICS);
        System.out.println(ConstantCollection.RANK5 + rank5 + "개");
        System.out.println(ConstantCollection.RANK4 + rank4 + "개");
        System.out.println(ConstantCollection.RANK3 + rank3 + "개");
        System.out.println(ConstantCollection.RANK2 + rank2 + "개");
        System.out.println(ConstantCollection.RANK1 + rank1 + "개");
        System.out.print("총 수익률은 " + earningsRate + "%입니다.");
    }

}

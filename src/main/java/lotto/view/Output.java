package lotto.view;

import lotto.Domain.Lotto;
import lotto.Domain.LottoGrade;
import lotto.Domain.Message;
import lotto.service.Match;

import java.util.*;

public class Output {

    public void printHowManyLotto(){
        System.out.println(Message.HOWMANY_LOTTO.getContent());
    }
    public void howManyLotto(){
        System.out.println(Message.BUY_MESSAGE.getContent());
    }
    public static void printLine() {
        System.out.println();
    }

    public void printLottoList(List<Lotto> lottolist) {
        for (Lotto lotto : lottolist) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printWinNumber(){
        System.out.println(Message.INPUT_WINNER.getContent());
    }

    public void printBonusNumber(){
        System.out.println(Message.INPUT_BONUS.getContent());
    }

    public void printResultstart(){
        System.out.println(Message.WINNING_STATISTICS.getContent());
    }

    public void printLottoResult(Match match){
        Map<LottoGrade,Integer> match_s = match.getLottoResult();
        List<LottoGrade> lottoGrades = Arrays.asList(LottoGrade.values());
        for(LottoGrade lottoGrade : lottoGrades){
            if(lottoGrade.equals(lottoGrade.LOSING))
                continue;       //꽝이면 출력x

        System.out.print(lottoGrade.getMessage().getContent());
        System.out.println(match_s.get(lottoGrade) + "개");
        }
    }

    public void printRate(double rate){
        System.out.print(Message.TOTAL_RETURN.getContent()+String.format("%.1f",rate)+Message.TOTAL_RETURN_FINISH.getContent());
    }

}

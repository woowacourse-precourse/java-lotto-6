package lotto.view;

import lotto.dto.Bingo;

public class OutputResult {

    enum Result {
        BINGO3(Bingo.getBingo3().correctLotto,"3개 일치 (5,000원) - "),
        BINGO4(Bingo.getBingo4().correctLotto,"4개 일치 (50,000원) - "),
        BINGO5(Bingo.getBingo5().correctLotto,"5개 일치 (1,500,000원) - "),
        BINGO5WB(Bingo.getBingo5wB().correctLotto,"5개 일치, 보너스 볼 일치 (30,000,000원) - "),
        BINGO6(Bingo.getBingo6().correctLotto,"6개 일치 (2,000,000,000원) - ");

        final private int matchNum;

        final private String message;

        Result(int matchNum, final String message){
            this.matchNum = matchNum;
            this.message = message;
        }

        public String getMessage(){
            return message;
        }

        public int getMatchNum(){
            return matchNum;
        }
    }

    public static void printResult(){
        System.out.println("\n당첨통계\n---");
        for ( Result result : Result.values() ) {
            System.out.println(result.getMessage() + result.getMatchNum() + "개");
        }
    }

}


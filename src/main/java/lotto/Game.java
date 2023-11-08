package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Game {
    static final int LOTTO_PRICE = 1000;
    static final int LIMIT_LOTTO_NUMBER = 45;
    static final int LOWEST_RANK = 5;

    Lotto publishedLotto[];
    rank[] ranking = rank.values();
    int numOfLotto;
    int prizeWinNum[] = new int[LIMIT_LOTTO_NUMBER + 1];
    int winStat[] = new int[LOWEST_RANK];
    double prizeWinMoney = 0;
    double credit;

    double inputCredit() { //로또 구매 금액 입력


        System.out.println("구입금액을 입력해 주세요.");
        credit = Double.parseDouble(readLine());


        if (credit % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException();
        }

        return credit;
    }

    void buyLotto() { //로또 구매 시 예외 처리
        while (true) {
            try {
                numOfLotto = (int)inputCredit() / LOTTO_PRICE;
                publishedLotto = new Lotto[numOfLotto];
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 로또 구입 금액은 1000원 단위로 입력해야 합니다.\n");
            }
        }
    }

    List<Integer> createRandomNumber(){ //로또번호 생성
        List<Integer> randomNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        return randomNumber;
    }

    void publish(){ //로또 발행
        buyLotto(); //로또 구매
        for(int i = 0; i < publishedLotto.length; i++){// 번호 생성
            publishedLotto[i] = new Lotto(createRandomNumber());
        }
    }

    void printLotto(){ // 발행한 로또 출력
        System.out.println("\n" + numOfLotto + "개를 구매했습니다.");
        for(int i = 0; i < publishedLotto.length; i++){
            System.out.print("[");
            publishedLotto[i].printLotto();
            System.out.println("]");
        }
    }

    void initPrizeWinNum(){ //당첨 번호 배열 초기화
        for (int i = 1; i < LIMIT_LOTTO_NUMBER; i++){
            prizeWinNum[i] = 0;
        }
    }

    String[] inputNum(){ // 당첨 번호 입력
        String[] input;

        while (true) {
            try {
                System.out.println("\n당첨 번호를 입력해 주세요.");
                input = readLine().split(",");

                inputNumErrorCheck(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            } catch (IllegalStateException e){
                System.out.println("[ERROR] 로또 번호의 개수는 6개여야 합니다.");

            }
        }

        return input;
    }

    void setNum(String inputNum[]){ //당첨 번호 셋팅
        for(int i = 0; i < inputNum.length; i++){
            int num = Integer.parseInt(inputNum[i]);
            prizeWinNum[num] = 1;
        }
    }

    String inputBonusNum(){ //보너스 번호 입력
        String input;

        while (true) {
            try {
                System.out.println("\n보너스 번호를 입력해 주세요.");
                input = readLine();

                inputBonusErrorCheck(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }

        return input;
    }

    void setBounusNum(String inputNum){ //보너스 번호 2로 셋팅
        int num = Integer.parseInt(inputNum);
        prizeWinNum[num] = 2;
    }

    void setPrizeWinNum(){ //발행 번호 배열 셋팅
        initPrizeWinNum();
        setNum(inputNum());
        setBounusNum(inputBonusNum());
    }

    void initStat(){
        for(int i = 0; i < winStat.length; i++) {
            winStat[i] = 0;
        }
    }

    void statistics(Lotto published){ //각각의 로또 순위 확인
        published.checkLotto(prizeWinNum);

        if(published.ranking != null) {
            winStat[published.ranking.ordinal()]++;
        }
    }

    void stareStat(){ //모든 로또 순위 통계 저장
        for(int i = 0; i < publishedLotto.length; i++) {
            statistics(publishedLotto[i]);
        }
    }

    void calc(){ //당첨금 계산
        for(rank r : ranking){
            prizeWinMoney += r.getNumWinMoney() * winStat[r.ordinal()];
        }
    }

    void printPrizeWinStat(){
        System.out.println("당첨 통계");
        System.out.println("---");
        for(rank r : ranking){
            System.out.println(r.getAnsNum() + " " + r.getKorWinMoney() + " - " + winStat[r.ordinal()] + "개");
        }
        System.out.println("총 수익률은 " + prizeWinMoney / credit + "%입니다.");
    }

    void countCheck(String num[]){
        if(num.length != 6){
            throw new IllegalStateException();
        }
    }

    void rangeCheck(int i){
        if(i < 0 || i > 45) {
            throw new IllegalArgumentException();
        }
    }

    void inputNumErrorCheck(String num[]){

        countCheck(num);

        for(String s : num) {
            int i = Integer.parseInt(s);
            rangeCheck(i);
        }
    }

    void inputBonusErrorCheck(String num){
        int i = Integer.parseInt(num);

        if(i < 0 || i > 45) {
            throw new IllegalArgumentException();
        }
    }
}

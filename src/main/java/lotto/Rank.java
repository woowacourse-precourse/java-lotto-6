package lotto;

/**
 * Rank 열거형은 로또 등수와 해당 등수에 대한 상금을 정의.
 */
public enum Rank{
    FIRST("6개 일치 (2,000,000,000원)", 2000000000), // 1등
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000), // 2등
    THIRD("5개 일치 (1,500,000원)", 1500000), // 3등
    FOURTH("4개 일치 (50,000원)", 50000), // 4등
    FIFTH("3개 일치 (5,000원)", 5000), // 5등
    NEXT("", 0) // 미당첨
    ;

    private final String label; // 등수 레이블
    private final int reward; // 상금 금액

    /**
     * Rank 열거형의 생성자. 등수 레이블과 상금을 초기화한다.
     * @param label 등수 레이블
     * @param reward 상금 금액
     */
    Rank(String label, int reward){
        this.label = label;
        this.reward = reward;
    }

    /**
     * 등수의 레이블을 반환한다.
     * @return 등수 레이블
     */
    public String label(){
        return label;
    }

    /**
     * 등수에 해당하는 상금을 반환한다.
     * @return 상금 금액
     */
    public int reward(){
        return reward;
    }
}

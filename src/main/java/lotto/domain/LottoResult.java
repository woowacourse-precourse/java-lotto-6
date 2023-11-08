package lotto.domain;

/**
 * 로또 결과를 관리하는 클래스
 */
public class LottoResult {
    private Integer first = 0;
    private Integer second = 0;
    private Integer third = 0;
    private Integer fourth = 0;
    private Integer fifth = 0;

    public void addFirst() {
        first++;
    }

    public void addSecond() {
        second++;
    }

    public void addThird() {
        third++;
    }

    public void addFourth() {
        fourth++;
    }

    public void addFifth() {
        fifth++;
    }
}

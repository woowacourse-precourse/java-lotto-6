package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";
    enum Word{
        STRING("숫자가 아님"), SPACE(" ");

        private String word;

        private Word(String word){
            this.word = word;
        }

        public String getWord(){
            return word;
        }
    }

    enum Num{
        ZERO(0), TOPRANGE(46), MINUS(-100), FIVE(5), ENDRANGE(45);

        private int num;

        private Num(int num){
            this.num = num;
        }
        public int getNum(){return num;}
    }

    public static final List<Integer> criteria = Arrays.asList(4,5,9,8,1,2);

    @Test
    void 기능_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "8개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 8, 11, 31, 41, 42]",
                            "[13, 14, 16, 38, 42, 45]",
                            "[7, 11, 30, 40, 42, 43]",
                            "[2, 13, 22, 32, 38, 45]",
                            "[1, 3, 5, 14, 22, 45]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 62.5%입니다."
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 입력금액_정수변환(){
        String test = "1000";
        Assertions.assertEquals(1000, money_for_lotto.realMoney(test));
    }

    @Test
    void 숫자가_아닌_초기입력예외(){
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> money_for_lotto.moneyIsNumber(Word.STRING.getWord()));
    }

    @Test
    void 공백_초기입력예외(){
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> money_for_lotto.moneyIsNumber(Word.SPACE.getWord()));
    }

    @Test
    void 음수_초기입력예외(){
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> money_for_lotto.moneyIsOver0(Num.ZERO.getNum()));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> money_for_lotto.moneyIsOver0(Num.MINUS.getNum()));
    }

    @Test
    void 천의_배수_입력확인(){
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> money_for_lotto.multipleOfThousand(Num.TOPRANGE.getNum()));
    }

    @Test
    void 복권_개수_계산_테스트(){
        int test = 14000;
        Assertions.assertEquals(14, money_for_lotto.repeatTime(test));
    }

    @Test
    void 당첨숫자_정수리스트화_테스트(){
        String test = "4,5,9,8,1,2";
        Assertions.assertEquals(criteria,winning_number.splitInput(test));
    }

    @Test
    void 당첨숫자_정수확인_테스트(){
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> winning_number.checkIntOrNot(Word.STRING.getWord()));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> winning_number.checkIntOrNot(Word.SPACE.getWord()));
    }

    @Test
    void 보너스숫자_정수확인_테스트(){
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> bonus_number.intgerBonus(Word.STRING.getWord()));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> bonus_number.intgerBonus(Word.SPACE.getWord()));
    }

    @Test
    void 보너스숫자_범위확인_테스트(){
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> bonus_number.checkBonusRange(Num.ZERO.getNum()));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> bonus_number.checkBonusRange(Num.TOPRANGE.getNum()));
    }

    @Test
    void 보너스숫자_중복확인_테스트(){
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> bonus_number.circulationForCheck(criteria, Num.FIVE.getNum()));
    }

    @Test
    void checkBonus_테스트(){
        String test = "45";
        Assertions.assertEquals(Num.ENDRANGE.getNum(),bonus_number.checkBonus(criteria,test));
    }

    @Test
    void checkCorrection_테스트(){
        Assertions.assertEquals(1, lotto_result.checkCorrection(Num.FIVE.getNum(),criteria));
    }

    @Test
    void 보너스번호_일치_테스트(){
        Assertions.assertEquals(7, lotto_result.checkBonus(criteria, Num.FIVE.getNum()));
    }

    @Test
    void third_prize_테스트(){
        List<Integer> thirdPrize = new ArrayList<>(Arrays.asList(4,5,9,8,1,3));
        Assertions.assertEquals(5, lotto_result.eachLottoCheck(criteria,thirdPrize,Num.ENDRANGE.getNum()));
    }

    @Test
    void 이익률_계산_테스트(){
        int test = 10000;
        Assertions.assertEquals(15500, profit_margin_caculation.profitMargin(criteria,test));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

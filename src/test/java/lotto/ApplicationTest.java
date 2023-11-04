package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Input.Input;
import lotto.validator.Validator;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;


import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

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
    void 로또가_몇_개_맞았는지_확인(){
        LottoService lottoService=new LottoService();
        Lotto lotto1=new Lotto(List.of(1,2,3,4,5,6));
        Lotto lotto2=new Lotto(List.of(7,8,9,3,10,1));
        int result=lottoService.compare(lotto1,lotto2);
        assertThat(result).isEqualTo(2);
    }
    @Test
    void 보너스_숫자가_맞는지_확인1(){
        LottoService lottoService=new LottoService();
        Lotto lotto1=new Lotto(List.of(1,2,3,4,5,6));
        boolean check=lottoService.compareBonusNumber(lotto1,3);
        assertThat(check).isEqualTo(true);
    }

    @Test
    void 보너스_숫자가_맞는지_확인2(){
        LottoService lottoService=new LottoService();
        Lotto lotto1=new Lotto(List.of(1,2,3,4,5,6));
        boolean check=lottoService.compareBonusNumber(lotto1,7);
        assertThat(check).isEqualTo(false);
    }

    @Test
    void 로또_숫자_입력(){
        String lotto = "1,2,3,4,5,6";
        System.setIn(new ByteArrayInputStream(lotto.getBytes()));
        List<Integer> result=Input.makeAnswerNumber();
        assertThat(result).isEqualTo(List.of(1,2,3,4,5,6));
    }

    @Test
    void 보너스_숫자_입력(){
        String bonus="7";
        System.setIn(new ByteArrayInputStream(bonus.getBytes()));
        int num=Input.makeBonusNumber();
        assertThat(num).isEqualTo(7);
    }

    @Test
    void 로또_입력_예외1(){
        assertThrows(IllegalArgumentException.class,
                ()->Validator.checkAnswerNumber(new String[]{"1","2","3","4","5","46"}));
    }

    @Test
    void 로또_입력_예외2(){
        assertThrows(IllegalArgumentException.class,
                ()->Validator.checkAnswerNumber(new String[]{"1","2","A","4","5","44"}));
    }
    @Test
    void 로또_입력_예외3(){
        assertThrows(IllegalArgumentException.class,
                ()->Validator.checkAnswerNumber(new String[]{"1","2","3","4","5"}));
    }

    @Test
    void 로또_중복_입력(){
        assertThrows(IllegalArgumentException.class,
                ()->Validator.checkDuplication(List.of(1,2,3,4,5,2)));

    }

    @Test
    void 금액_입력_예외1(){
        assertThrows(IllegalArgumentException.class,()->Validator.checkPrice("15002"));
    }

    @Test
    void 금액_입력_예외2(){
        assertThrows(IllegalArgumentException.class,()->Validator.checkPrice("15a"));
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.controller.LottoController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ErrorTest {

    private LottoController controller;


    @BeforeEach
    void beforeEach() {
        this.controller = LottoController.getInstance();
    }
    //  금액을 넣었을 때 로또 반환
    @Test
    void 숫자_이외의_것(){
        String tempStr = "qwe";
        assertThatThrownBy(() -> controller.setLottoBudget(tempStr))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 천원_이하(){
        String tempStr = "900";
        assertThatThrownBy(() -> controller.setLottoBudget(tempStr))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 백의_자리_있음(){
        String tempStr = "1900";
        assertThatThrownBy(() -> controller.setLottoBudget(tempStr))
                .isInstanceOf(IllegalArgumentException.class);
    }
    // 유저 로또번호 출력
    @Test
    void 로또_번호에_겹치는_숫자(){
        String tempStr = "1,2,3,4,5,5";
        assertThatThrownBy(() -> controller.createUserLottoNumber(tempStr))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 숫자의_범위_이탈(){
        String tempStr = "1,2,3,4,5,55";
        assertThatThrownBy(() -> controller.createUserLottoNumber(tempStr))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 중간에_문자열(){
        String tempStr = "1,2,3,4,5,ㅈㄷㄱ5";
        assertThatThrownBy(() -> controller.createUserLottoNumber(tempStr))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 중간에_공백(){
        String tempStr = "1,2,3,4,,ㅈㄷㄱ5";
        assertThatThrownBy(() -> controller.createUserLottoNumber(tempStr))
                .isInstanceOf(IllegalArgumentException.class);
    }
    // 서비스 번호 생성
    @Test
    void 서비스_번호_숫자아님(){
        String bonus = "ㅂㅈㄷ";
        assertThatThrownBy(() -> controller.createBonusNumber(bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 서비스_번호_범위_이탈(){
        String bonus = "55";
        assertThatThrownBy(() -> controller.createBonusNumber(bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 제공번호와_서비스_번호_같음(){
        controller.createUserLottoNumber("1,2,3,4,5,45");
        String bonus = "45";
        assertThatThrownBy(() -> controller.createBonusNumber(bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

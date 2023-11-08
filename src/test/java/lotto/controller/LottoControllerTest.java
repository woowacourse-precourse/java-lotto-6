package lotto.controller;

import static lotto.util.TestUtil.ERROR_PREFACE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import lotto.dto.DatabaseDto;
import lotto.exception.LottoPriceUnitException;
import lotto.exception.NonPositiveAmountException;
import lotto.model.LottoBonusNumber;
import lotto.model.LottoWinningNumbers;
import lotto.model.Money;
import lotto.repository.LottoWinningRepository;
import lotto.repository.UserLottoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoControllerTest extends NsTest {

    UserLottoRepository userLottoRepository;
    LottoWinningRepository lottoWinningRepository;
    LottoController lottoController;

    @BeforeEach
    void setup() {
        this.userLottoRepository = new UserLottoRepository();
        this.lottoWinningRepository = new LottoWinningRepository();
        DatabaseDto dto = new DatabaseDto(userLottoRepository, lottoWinningRepository);
        this.lottoController = new LottoController(dto);
    }

    @DisplayName("사용자원 단위로 받아온다.")
    @Test
    void successGetAmount() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // given
        final String money = "1000";
        run(money);
        Method method = getAccessibleMethod("getAmount");

        // when
        Money moneyValue = (Money) method.invoke(lottoController);

        // then
        assertThat(moneyValue.getMoney())
                .isEqualTo(Integer.parseInt(money));
    }

    @DisplayName("값을 넣으면 예외 발생: 단위")
    @Test
    void getAmountThrowCase1() throws NoSuchMethodException {
        final String money = "1100";
        run(money);
        Method method = getAccessibleMethod("getAmount");

        assertThatThrownBy(() -> {
            method.invoke(lottoController);
        })
                .isInstanceOf(InvocationTargetException.class)
                .hasCauseInstanceOf(LottoPriceUnitException.class);
    }

    @DisplayName("잘못된 값을 넣으면 예외 발생: 음수")
    @Test
    void getAmountThrowCase2() throws NoSuchMethodException {
        final String money = "-1000";
        run(money);
        Method method = getAccessibleMethod("getAmount");

        assertThatThrownBy(() -> {
            method.invoke(lottoController);
        })
                .isInstanceOf(InvocationTargetException.class)
                .hasCauseInstanceOf(NonPositiveAmountException.class);
    }

    @DisplayName("잘못된 값을 넣으면 예외 발생: 0")
    @Test
    void getAmountThrowCase3() throws NoSuchMethodException {
        final String money = "0";
        run(money);
        Method method = getAccessibleMethod("getAmount");

        assertThatThrownBy(() -> {
            method.invoke(lottoController);
        })
                .isInstanceOf(InvocationTargetException.class)
                .hasCauseInstanceOf(NonPositiveAmountException.class);
    }

    @DisplayName("로또를 구입할 때 잘못된 값을 넣으면 다시 받는다.")
    @Test
    void retryBuyLotto() {
        run("1100", "1000");

        lottoController.buyLotto();

        assertThat(output()).contains("1개를 구매했습니다.");
    }

    @DisplayName("로또를 구입하고, 로또를 반환받는다.")
    @Test
    void buyLottoSuccess() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        final int count = 5;
        run(String.valueOf(count * 1000));
        Method method = getAccessibleMethod("buyLotto");
        method.invoke(lottoController);

        assertThat(output()).contains(count + "개");
    }

    @DisplayName("사용자로부터 1등 당첨 번호를 받아온다.")
    @Test
    void successGetLottoWinningNumbers()
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        run("1,2,3,4,5,6");
        Method method = getAccessibleMethod("getLottoWinningNumbers");

        LottoWinningNumbers winningNumbers = (LottoWinningNumbers) method.invoke(lottoController);
        assertThat(winningNumbers).isNotNull();
    }

    @DisplayName("잘못된 값을 입력하면 다시 입력되면 오류를 발생한다.: 1,2,3")
    @Test
    void getLottoWinningNumbersThrowCase1()
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        run("1,2,3", "1,2,3,4,5,6");
        Method method = getAccessibleMethod("getLottoWinningNumbers");

        method.invoke(lottoController);
        assertThat(output()).contains(ERROR_PREFACE);
    }

    @DisplayName("잘못된 값을 입력하면 다시 입력되면 오류를 발생한다.: 숫자 이외")
    @Test
    void getLottoWinningNumbersThrowCase2()
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        run("1,2,3,4,5,w", "1,2,3,4,5,6");
        Method method = getAccessibleMethod("getLottoWinningNumbers");

        method.invoke(lottoController);
        assertThat(output()).contains(ERROR_PREFACE);
    }

    @DisplayName("사용자로부터 보너스 번호를 받아오고 잘 저장된다.")
    @Test
    void getLottoBonusNumber() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        int number = 25;
        run(String.valueOf(number));
        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers("1,2,3,4,5,6");
        Method method = getAccessibleMethod("getLottoBonusNumber", LottoWinningNumbers.class);

        LottoBonusNumber outBonusNumber = (LottoBonusNumber) method.invoke(lottoController, lottoWinningNumbers);

        assertThat(outBonusNumber.getBonusNumber()).isEqualTo(number);
    }

    @DisplayName("잘못된 번호는 오류를 반환하고 다시 받는다.: 문자") // 이외 케이스는 LottoBonusNumber에서 처리
    @Test
    void getLottoBonusNumberThrowCase1()
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        run("w", "25");
        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers("1,2,3,4,5,6");
        Method method = getAccessibleMethod("getLottoBonusNumber", LottoWinningNumbers.class);

        LottoBonusNumber bonusNumber = (LottoBonusNumber) method.invoke(lottoController, lottoWinningNumbers);

        assertThat(output()).contains(ERROR_PREFACE);
        assertThat(bonusNumber)
                .isNotNull();
    }

    @DisplayName("중복된 번호는 오류를 반환하고 다시 받는다.") // 이외 케이스는 LottoBonusNumber에서 처리
    @Test
    void getLottoBonusNumberThrowCase2()
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        run("1", "25");
        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers("1,2,3,4,5,6");
        Method method = getAccessibleMethod("getLottoBonusNumber", LottoWinningNumbers.class);

        LottoBonusNumber bonusNumber = (LottoBonusNumber) method.invoke(lottoController, lottoWinningNumbers);

        assertThat(output()).contains(ERROR_PREFACE);
        assertThat(bonusNumber)
                .isNotNull();
    }

    @DisplayName("사용자로부터 1등 번호와 보너스 번호를 받고 서비스에 넘기고 저장된다.")
    @Test
    void saveLottoWinningAmount() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        run("1,2,3,4,5,6", "25");

        // when
        lottoController.saveLottoWinningAmount();

        // then
        assertThat(lottoWinningRepository.getLottoWinningNumbers())
                .isNotNull();
        assertThat(lottoWinningRepository.getLottoBonusNumber())
                .isNotNull();
    }

    private Method getAccessibleMethod(String methodName, Class<?>... parameterTypes)
            throws NoSuchMethodException {
        Method method = lottoController.getClass().getDeclaredMethod(methodName, parameterTypes);
        method.setAccessible(true);

        return method;
    }

    @Override
    public void runMain() {
    }
}
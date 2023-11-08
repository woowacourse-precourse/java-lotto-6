package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 아니면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 7);

        assertThatThrownBy(() ->{
            if(numbers.size() != 6) {
                throw new IllegalArgumentException("6자리가 아닌 로또번호 생성");
            }
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("6자리가 아닌 로또번호 생성");
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        List<Integer> numbers = Arrays.asList(1,2,2,3,4,5);
        Set<Integer> numSet = new HashSet<>(numbers);

        assertThatThrownBy(() -> {
            if(numbers.size() != numSet.size()){
                throw new IllegalArgumentException("로또 번호에 중복 존재");
            }
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호에 중복 존재");
    }

    @DisplayName("1~45 범위의 숫자가 아니면 예외가 발생한다.")
    @Test
    void checkNumberScope() {
        List<Integer> numbers = Arrays.asList(1,2,2,3,46,5);
        Collections.sort(numbers);

        assertThatThrownBy(() -> {
            if(numbers.get(0) < 1 || numbers.get(numbers.size()-1) > 45){
                throw new IllegalArgumentException("1~45 범위 밖의 숫자");
            }
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1~45 범위 밖의 숫자");
    }

    @DisplayName("정수가 입력되지않으면 예외가 발생한다.")
    @Test
    void checkInt() {
        String InputNumbers = "t,a,e,t,x,z";
        String[] changeToNumber = InputNumbers.split(",");

        assertThat(changeToNumber).contains("t","a","e","t","x","z");

        for (String s : changeToNumber) {
            checkInt2(s);
        }
    }

    @DisplayName("로또 번호가 정수인지 확인")
    @Test
    private void checkInt2(String s) {
        assertThatThrownBy(() ->{
            if( !isInteger(s) ) {
                throw new IllegalArgumentException("로또번호는 정수로 입력해주세요.");
            }
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또번호는 정수로 입력해주세요.");
    }

    @DisplayName("입력(문자열)이 정수인지 확인하기 위한 메소드")
    @Test
    public boolean isInteger(String strValue) {
        try {
            Integer.parseInt(strValue);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @DisplayName("구매 로또 번호와 당첨번호 비교")
    @Test
    private int compareNumber(String numbersOne) {
        String[] changeToNumber = numbersOne.split(",");
        List<String> changeToNumber2 = Arrays.stream(changeToNumber).collect(Collectors.toList());
        List<Integer> LottoNumber = changeToNumber2.stream()
                                                    .map(s -> Integer.parseInt(s))
                                                    .collect(Collectors.toList());

        List<Integer> inputNumber = new ArrayList<>(Arrays.asList(1,2,3,7,6,5));
        LottoNumber.retainAll(inputNumber);
        assertThat(LottoNumber).contains(1,2,3,5,6);

        return LottoNumber.size();
    }

    @DisplayName("로또 번호 당첨 숫자 갯수")
    @Test
    void HowMatchNumber() {
        int matchNumber = compareNumber("1,2,3,5,6,8");

        assertThat(matchNumber).isEqualTo(5);
    }

    @DisplayName("이익률 계산")
    @Test
    void getMoneyRatio() {

        int inputMoney = 8000;
        int getMoney = 5000;

        int inputMoney2 = 13000;
        int getMoney2 = 5000;


        double getMoneyRatio = Math.round(((double) getMoney / (double) inputMoney) * 1000) /10.0;
        double getMoneyRatio2 = Math.round(((double) getMoney2 / (double) inputMoney2) * 1000)/10.0;

        assertThat(getMoneyRatio).isEqualTo(62.5);
        assertThat(getMoneyRatio2).isEqualTo(38.5);
    }
}
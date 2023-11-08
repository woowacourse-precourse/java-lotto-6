package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {

    @ParameterizedTest
    @MethodSource("provideMoneyObject")
    @DisplayName("플레이어 로또 번호는 금액에 맞게 생성되어야 한다.")
    void createCorrectPlayerLottoCount(Money money, Integer answerCountLotto) {
        // given
        List<Lotto> playerLottos;
        // when
        playerLottos = LottoService.generatePlayerLotto(money);
        Integer countLotto = playerLottos.size();
        // then
        assertThat(countLotto).isEqualTo(answerCountLotto);
    }

    @ParameterizedTest
    @ValueSource(ints = {8000, 14000, 5000})
    @DisplayName("생성된 각 플레이어의 로또는 6개의 숫자를 가지고 있어야 한다.")
    void createCorrectPlayerLottoOfElementCount(Integer amount) {
        // given
        Money money = new Money(amount);
        List<Lotto> playerLottos;
        Boolean isAllElementSixNumber = false;
        // when
        playerLottos = LottoService.generatePlayerLotto(money);
        for(Lotto playerLotto : playerLottos){
            if(playerLotto.getNumbers().size() != 6){
                isAllElementSixNumber = true;
                break;
            }
        }
        // then
        assertThat(isAllElementSixNumber).isEqualTo(false);
    }

    @ParameterizedTest
    @ValueSource(ints = {3000, 4000, 5000})
    @DisplayName("플레이어 로또 번호는 오름차순이어야 한다.")
    void isPlayerLottoSorted(Integer amount) {
        // given
        Money money = new Money(amount);
        List<Lotto> playerLottos;
        Boolean isEqual = false;
        // when
        playerLottos = LottoService.generatePlayerLotto(money);
        for(Lotto playerLotto : playerLottos){
            List<Integer> originPlayerLottoNumbers = playerLotto.getNumbers();
            List<Integer> copyPlayerLottoNumbers = List.copyOf(originPlayerLottoNumbers);
            Collections.sort(originPlayerLottoNumbers);
            isEqual = areListsEqual(originPlayerLottoNumbers, copyPlayerLottoNumbers);
            if(!isEqual){
                break;
            }
        }
        // then
        assertThat(isEqual).isEqualTo(true);
    }

    private static Stream<Arguments> provideMoneyObject(){
        return Stream.of(
                Arguments.of(new Money(14000), 14),
                Arguments.of(new Money(5000), 5),
                Arguments.of(new Money(3000), 3)
        );
    }

    private static Boolean areListsEqual(List<Integer> origin, List<Integer> target){
        for(int i = 0;i < origin.size();i++){
            if(!(origin.get(i).equals(target.get(i)))){
                return false;
            }
        }
        return true;
    }
}
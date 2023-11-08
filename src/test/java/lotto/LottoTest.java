package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호와 당첨 번호가 3개 이하로 겹쳤을 때의 결과")
    @Test
    void compareWhenUnder3Overlap() {
    	Lotto testWinningNumbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    	List<List<Integer>> testLotto = new ArrayList<List<Integer>>();
    	List<Integer> testLottoNumbers = new ArrayList<>(Arrays.asList(1, 2, 7, 8, 9, 10));
    	testLotto.add(testLottoNumbers);
    	int testBouns = 11;
    	
    	List<Integer> result = testWinningNumbers.compare(testLotto, testBouns);

        assertThat(result.toString()).isEqualTo("[0, 0, 0, 0, 0]");
    }
    
    @DisplayName("로또 번호와 당첨 번호가 3개 겹쳤을 때의 결과")
    @Test
    void compareWhen3Overlap() {
    	Lotto testWinningNumbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    	List<List<Integer>> testLotto = new ArrayList<List<Integer>>();
    	List<Integer> testLottoNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 8, 9, 10));
    	testLotto.add(testLottoNumbers);
    	int testBouns = 11;
    	
    	List<Integer> result = testWinningNumbers.compare(testLotto, testBouns);

        assertThat(result.toString()).isEqualTo("[1, 0, 0, 0, 0]");
    }
    
    @DisplayName("로또 번호와 당첨 번호가 4개 겹쳤을 때의 결과")
    @Test
    void compareWhen4Overlap() {
    	Lotto testWinningNumbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    	List<List<Integer>> testLotto = new ArrayList<List<Integer>>();
    	List<Integer> testLottoNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 9, 10));
    	testLotto.add(testLottoNumbers);
    	int testBouns = 11;
    	
    	List<Integer> result = testWinningNumbers.compare(testLotto, testBouns);

        assertThat(result.toString()).isEqualTo("[0, 1, 0, 0, 0]");
    }
    
    @DisplayName("로또 번호와 당첨 번호가 5개 겹쳤을 때의 결과")
    @Test
    void compareWhen5Overlap() {
    	Lotto testWinningNumbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    	List<List<Integer>> testLotto = new ArrayList<List<Integer>>();
    	List<Integer> testLottoNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 10));
    	testLotto.add(testLottoNumbers);
    	int testBouns = 11;
    	
    	List<Integer> result = testWinningNumbers.compare(testLotto, testBouns);

        assertThat(result.toString()).isEqualTo("[0, 0, 1, 0, 0]");
    }
    
    @DisplayName("로또 번호와 당첨 번호가 5개 겹친 동시에 보너스 점수 포함 때의 결과")
    @Test
    void compareWhen5OverlapAndBonus() {
    	Lotto testWinningNumbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    	List<List<Integer>> testLotto = new ArrayList<List<Integer>>();
    	List<Integer> testLottoNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 11));
    	testLotto.add(testLottoNumbers);
    	int testBouns = 11;
    	
    	List<Integer> result = testWinningNumbers.compare(testLotto, testBouns);

        assertThat(result.toString()).isEqualTo("[0, 0, 0, 1, 0]");
    }
    
    @DisplayName("로또 번호와 당첨 번호가 6개 겹쳤을 때의 결과")
    @Test
    void compareWhen6Overlap() {
    	Lotto testWinningNumbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    	List<List<Integer>> testLotto = new ArrayList<List<Integer>>();
    	List<Integer> testLottoNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
    	testLotto.add(testLottoNumbers);
    	int testBouns = 11;
    	
    	List<Integer> result = testWinningNumbers.compare(testLotto, testBouns);

        assertThat(result.toString()).isEqualTo("[0, 0, 0, 0, 1]");
    }
}
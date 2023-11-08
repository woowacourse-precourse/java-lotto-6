package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

class BonusNumberTest {

	int []numbers = {1,2,3,4,5,6};
	List<Integer> lottoNumbers = Arrays.stream(numbers).boxed().collect(Collectors.toList());
	Lotto lotto = new Lotto(lottoNumbers);
	
	@Test
	void 보너스_번호가_유효한_번호인지_테스트() {
		int number = 7;
		
		BonusNumber bonusNumber = new BonusNumber(number, lotto);
        assertThat(bonusNumber.getNumber()).isEqualTo(7);
	}
	
	@Test
	void 보너스_번호가_당첨_번호와_중첩시_예외_발생() {
		int number = 1;

        assertThatThrownBy(() -> new BonusNumber(number, lotto))
                .isInstanceOf(IllegalArgumentException.class);
	}
}

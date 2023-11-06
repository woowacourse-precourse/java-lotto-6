package lotto;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import controller.Statistics;

public class StatisticsTest {

	/*@DisplayName("생성된 로또번호와 입력한 로또번호 간 정확한 일치 종류로 분류된다.")
    @Test
    void correctlyClassfied() {
		List<List<Integer>> lottery_list=new ArrayList<List<Integer>>();
		
		List<Integer> l1=List.of(8, 21, 23, 41, 42, 43);
		List<Integer> l2=List.of(1, 2, 43, 30, 44, 12);//4
		List<Integer> l3=List.of(24, 12, 29, 10, 30, 8);//3
		List<Integer> l4=List.of(6, 28, 16, 8, 44, 2);
		List<Integer> l5=List.of(8, 12, 4, 44, 30, 2);//3
		
		Lotto lotto=new Lotto(l5);
		
		Statistics stat=new Statistics(lottery_list, 7, lotto);
		
		lottery_list.add(l1);
		lottery_list.add(l2);
		lottery_list.add(l3);
		lottery_list.add(l4);
		
		int [] arr= {2,1,0,0,0};
    	assertArrayEquals(arr, stat.compareNumbers());
    }
	
	@DisplayName("당첨번호에 따라 정확한 수익률이 계산된다.")
	@Test
	void correctReturnRate() {
		List<List<Integer>> lottery_list2=new Vector<List<Integer>>();
		
		List<Integer> l12=List.of(8, 21, 23, 41, 42, 43);
		List<Integer> l22=List.of(1, 2, 43, 30, 44, 12);//4
		List<Integer> l32=List.of(24, 12, 29, 10, 30, 8);//3
		List<Integer> l42=List.of(6, 28, 16, 8, 44, 2);
		List<Integer> l52=List.of(8, 12, 4, 44, 30, 2);//3
		
		Lotto lotto=new Lotto(l52);
		
		Statistics stat=new Statistics(lottery_list2, 7, lotto);
		
		lottery_list2.add(l12);
		lottery_list2.add(l22);
		lottery_list2.add(l32);
		lottery_list2.add(l42);
		
		int [] classify=stat.compareNumbers();
		
		assertSame(1500.0, stat.getRateOfReturn(stat.getProfitAmount(classify)));
	}*/
}

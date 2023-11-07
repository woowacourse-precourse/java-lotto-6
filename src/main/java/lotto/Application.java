package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
    	List <Integer> a = new ArrayList<Integer>(1);
    	Lotto lotto = new Lotto(a);
    	System.out.println(lotto);
    }
}

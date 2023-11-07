package lotto.util.io.output.viewer;

import java.util.List;

public class UserScreen implements Viewer {
    @Override
    public void ViewPrint() {
        System.out.println();
    }

    public void ViewPrint(String data) {
        System.out.println(data);
    }

    public void ViewPrint(List<Integer> data) {
        System.out.println(data);
    }
}

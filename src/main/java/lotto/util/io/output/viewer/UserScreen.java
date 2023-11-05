package lotto.util.io.output.viewer;

public class UserScreen implements Viewer {
    @Override
    public void ViewPrint() {
        System.out.println();
    }
    public void ViewPrint(String data) {
        System.out.println(data);
    }
}

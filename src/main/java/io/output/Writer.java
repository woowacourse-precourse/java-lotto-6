package io.output;

/**
 * UNIX LIKE OS에서 모든 것은 파일로 취급되며, 바이트 열로 표현될 수 있습니다.
 * <p>
 * <p>
 * 장치 파일, 디스크 파일, 네트워크 소켓 등 다양한 파일로부터 데이터를 쓸 수 있기 때문에,
 * <p>
 * 이를 Reader로 추상화하여 필요에 따라 데이터를 쓸 소스를 변경할 수 있도록 유연한 구조로 만들 수 있습니다.
 */
public interface Writer {
    void write(String message);
}

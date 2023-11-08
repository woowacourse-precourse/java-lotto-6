## MVC 패턴

---

### Model

- **Lotto - 주어진 domain**
    - 로또 번호 한 세트
    - 로또 번호 유효성 검증
        - 6개의 숫자
        - 서로 다른 숫자
        - 1 - 45 사이의 숫자
- **LottoGame**
    - 로또 당첨 관련 Class.
        - Lotto 당첨 번호
        - int 보너스 번호
    - 보너스 번호 유효성 검증
        - 1 - 45 사이의 숫자
        - 당첨 번호와 다른 숫자
- **PurchaseLotto**
    - 로또 구매 Class
        - 구매 금액 → 로또 개수 계산
        - 구매한 로또 정보 저장
    - 구매 금액 유효성 검사
        - 0보다 큰 숫자
        - 1000으로 나누어 떨어지는 숫자
- **LottoMachine**
    - 로또 발행 Class
        - 발행 개수에 맞게 랜덤 넘버로 로또 발행
            - 1 - 45 사이의 숫자 6개 랜덤으로 뽑아 설정
            - 오름차순으로 정렬
- **WinningResult**
    - 로또 당첨 결과 Class
        - 등수 별 당첨 결과 카운트
        - 수익률 계산
            - 소수점 둘째 자리에서 반올림
- **Ranking - Enum**
    - 로또 등수 Enum
        - 등수, 일치 숫자 갯수, 상금, 관련 메시지로 구성
        - 일치 숫자 갯수, 보너스 번호 포함 여부로 해당 로또의 등수 판별


### View

- **InputView**
    - 사용자의 입력을 받는 Class
        - 구매 금액
        - 당첨 번호
        - 보너스 번호
    - 공백 입력 유효성 검사
- **OutputView**
    - 컴퓨터의 출력 관련 Class
        - 로또 구매 갯수
        - 구매한 로또 정보
        - 당첨 결과
        - 수익률

### Controller

- **LottoGameController**
    - 로또 게임 Controller

### Util

- **ExceptionMessage - Enum**
    - 예외 처리 관련 enum
        - 예외 메시지 출력
- **Parser**
    - String → Integer
    - (,) 기준 split → List<Integer>
    - 숫자 입력 유효성 검사
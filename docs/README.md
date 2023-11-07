## 기능 요구 사항

---

### Constant(상수)

- [x]  로또 1장의 가격은 1,000원이다.
- [x]  로또 번호의 숫자 범위는 1 ~ 45 까지이다.
- [x]  로또 번호 개수는 6개이다.
- [x]  로또 티켓 가격은 1,000원이다.

### Lotto Game(로또 게임)

- [x]  로또 구입 금액 입력
- [x]  자동 로또 구매 목록 출력
- [x]  당첨 번호 입력
- [x]  보너스 번호 입력
- [x]  당첨 번호 및 보너스 번호 WinningLotto 생성
- [x]  생성한 WinningLotto 당첨 번호 객체로 LottoStorage 생성
- [x]  로또 당첨 내역 및 수익률 출력

### Lotto(로또)

- [x]  로또 객체 생성 시 로또 번호 리스트 검증
- [x]  로또 넘버 자동 생성 정적 팩토리 메소드 구현
- [x]  로또 넘버 리스트 반환 메소드

- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생
    - 로또 번호 개수가 6개가 아닐 경우
    - 로또 번호가 1 - 45 사이의 수가 아닐 경우 (ex. `123`, `0`)
    - 로또 번호 가운데 중복된 수가 있을 경우
    - 로또 구입 금액 자료형이 숫자형이 아닐 경우


### Winning Lotto (당첨 번호)

- [x]  입력 받은 당첨 번호와 보너스 번호를 저장
- [x]  당첨 번호 및 보너스 번호 반환
- [x]  당첨 번호 객체 생성 정적 팩토리 메소드 구현
- [x]  주어진 숫자가 당첨 번호인지 확인하는 메소드 구현

### Lotto Storage(로또 저장소)

- [x]  입력 받은 당첨 번호 저장
- [x]  자동 로또와 당첨 로또 비교 결과 (DTO) 반환
- [x]  모든 자동 로또 번호와 당첨 로또 비교
- [x]  모든 자동 로또 비교 결과를 기반으로 로또 랭크 결과 반환

### Automatic Lotto(자동 로또)

- [x]  중복되지 않는 6개의 로또 번호를 발행
- [x]  구매한 로또 장수를 기반으로 자동 로또 리스트 생성

### Automatic Lotto Storage(자동 로또 저장소)

- [x]  자동 로또 리스트 및 총 구입 금액 저장
- [x]  구입 금액 기반으로 로또 발행 개수(=티켓) 반환
- [x]  티켓 개수만큼 자동 로또 리스트 저장
- [x]  총 구입 금액 반환

- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생
    - 로또 구입 금액이 1,000원으로 나누어 떨어지지 않는 경우

### LottoRank(로또 기준)

- [x]  당첨 기준 Enum 관리
- 당첨 개수, 보너스 포함 여부, 당첨 금액
- [x]  로또 번호 매칭 개수와 보너스 번호 포함 여부로 LottoRank 찾기

```
- 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
    - 1등: 6개 번호 일치 / 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - 3등: 5개 번호 일치 / 1,500,000원
    - 4등: 4개 번호 일치 / 50,000원
    - 5등: 3개 번호 일치 / 5,000원
```

### Util

- [x]  [`LottoNumberGenerator`] 1 - 45 사이 무작위의 6개의 로또 넘버 생성 메소드
- [x]  [`LottoNumberValidator`] 1- 45 사이의 로또 넘버 검증 메소드
  - [x]  [`LottoProfitCalculator`] 당첨 내역에 따른 수익률 계산 메소드
      - 수익률은 소수점 둘째 자리에서 반올림
      - 수익률 계산 알고리즘 구현

     ```java
        double roi = (double) (revenue * 100) / cost;
        return Math.round(roi * 100.0) / 100.0; // 소수점 둘째 자리에서 반올림
     ```

- [x]  [`TextBuilder`] 문자열 가공 역할의 **TextBuilder 라이브러리 구현**
    - Integer 파라미터 타입을 추가하는 메소드
    - Double 파라미터 타입을 추가하는 메소드


- [x]  [`KRWFormatter`] 화폐 단위를 적용 문자열 반환 메소드
    - 화폐 단위 적용 예시

        ```java
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        String result = decimalFormat.format(cash);
        ```


- [x]  [`LottoGameInputer`] 문자열 입력 메소드 구현
    - [x]  문자열 입력 Integer 반환
    - 사용자가 잘못된 값을 입력할 경우 올바른 값을 입력받을 때 까지 반복

        ```java
        try {
            return Integer.parseInt(input());
        } catch (NumberFormatException exception) {
        		LottoGamePrinter.println(LOTTO_PURCHASE_AMOUNT_INVALID_ERROR.getMessage());
            return inputToInteger();
        }
        ```


- [x]  [`LottoGamePrinter`] 문자열 출력 메소드 구현

### **✅ 프로그래밍 요구 사항**

- [x]  JDK 17 버전에서 실행 가능하는가
- [x]  Java Style Guide를 준수하는가
- [x]  ApplicationTest의 모든 테스트가 성공하는가
- [x]  indent(인덴트, 들여쓰기) depth가 3이 넘지 않은가 (2까지만 허용)
- [x]  함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들었는가
- [ ]  JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인했는가
- [x]  함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현했는가
- [x]  Java Enum을 적용했는가
- [ ]  도메인 로직에 단위 테스트를 구현했는가
- [x]  Randoms 및 Console API를 사용했는가
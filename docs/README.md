## 🚀 기능 명세

### 로또 게임 메인 로직
- [x] 로또 구매 가격 입력
- [x] 로또 발행
- [x] 로또 수량 출력
- [x] 로또 번호 출력
- [x] 당첨 번호 입력
- [x] 보너스 번호 입력
- [x] 당첨 내역 출력
- [x] 수익률 출력

### 클래스
- [x] 구입 금액 (Amount)
   - [x] 구입 금액에 따라 Lotto List 리턴.
   - [x] 구입 금액 Valid
     - [x] 1000원 단위로 나누어 떨어지지 않으면 예외 처리
     - [x] 가격으로 비정상적인 값을 받으면 예외 처리
     - [x] 가격으로 int 형태의 최댓값을 넘거나 음수를 받으면 예외 처리

- [x] 로또 (Lotto)
  - [x] 각 로또 번호 Valid
    - [x] 1 ~ 45 범위 이외의 값이 나오면 예외 처리
    - [x] int 이외의 값이 나오면 예외 처리
  - [x] 전체 로또 번호 Valid
    - [x] 중복 된 값이 나오면 예외 처리
    - [x] 6개 이상의 값이 나오면 예외 처리
  - [x] Lotto 번호 정렬
  - [x] Lotto 번호 출력

- [x] 당첨 번호 (WinningNumber)
  - [x] 보너스 번호 생성
  - [x] 보너스 번호 Valid
    - [x] 당첨 번호 중 중복된 값이 나오면 예외 처리
    - [x] 1 ~ 45 사이의 값이 들어오지 않았을 시 예외 처리
    - [x] int 값이 들어오지 않을 시 예외 처리
  - [x] 당첨 번호 생성
  - [x] 당첨 번호 Valid
    - [x] 중복 된 값이 나오면 예외 처리
    - [x] 공백은 trim 으로 처리
    - [x] int값이 들어오지 않았을 시 예외 처리
    - [x] 1 ~ 45 사이의 값이 들어오지 않았을 시 예외 처리
    - [x] 6개 이상의 값이 나오면 예외 처리

- [x] 당첨 내역 (WinningList)
  - [x] Lotto의 List와 WinningNumber를 입력 받아 당첨 여부 계산.
  - [x] 수익률 계산 및 ProfitRate 리턴
  - [x] 당첨 내역 출력

- [x] 수익률 (ProfitRate)
  - [x] 수익률 Valid
    - [x] 소수점 첫째 자리가 넘으면 예외 처리
    - [x] 원래 값과 비교하여 반올림 하지 않으면 예외 처리

- [x] 입력 뷰 (InputView)
  - [x] 로또 구매 가격 입력 및 컨트롤러로 전송
  - [x] 당첨 번호 입력 및 컨트롤러로 전송
  - [x] 보너스 번호 입력 및 컨트롤러로 전송

- [x] 출력 뷰 (OutputView)
  - [x] 로또 수량 출력
  - [x] 로또 번호 출력
  - [x] 당첨 내역 출력
  - [x] 수익률 출력

- [x] 로또 컨트롤러 (LottoController)
  - [x] 구매 가격에 따른 로또 생성 메소드 호출
  - [x] 로또 리스트 생성 및 저장
  - [x] 당첨 내역 계산 메소드 호출
  - [x] 당첨 내역 생성 및 저장
  - [x] 수익률 계산 메소드 호출
  - [x] 수익률 저장

- [x] 리팩토링 필요 내역
  - [x] 원시 값 포장 하기, 컬렉션 일급 컬렉션으로 만들기
  - [x] 하드 코딩 된 곳 상수로 빼기
  - [x] 상수로 뺀 것 enum으로 관리하기
  - [x] 컨트롤러의 시퀀스 부분 수정
  - [x] indent depth 2로 수정 및 메소드 분리
  - [x] 의존성 역전 (가능하면)

## 레퍼런스

- https://techblog.woowahan.com/2527/
- https://velog.io/@backfox/setter-%EC%93%B0%EC%A7%80-%EB%A7%90%EB%9D%BC%EA%B3%A0%EB%A7%8C-%ED%95%98%EA%B3%A0-%EA%B0%80%EB%B2%84%EB%A6%AC%EB%A9%B4-%EC%96%B4%EB%96%A1%ED%95%B4%EC%9A%94
- https://velog.io/@gudnr1451/%ED%85%8C%EC%BD%94%ED%86%A1-%EC%A0%95%EB%A6%AC-MVC-%ED%8C%A8%ED%84%B4
- https://tecoble.techcourse.co.kr/post/2020-04-26-Method-Naming/
- https://velog.io/@alsgus92/%EC%9D%BC%EA%B8%89-%EC%BB%AC%EB%A0%89%EC%85%98%EC%9D%84-%ED%99%9C%EC%9A%A9%ED%95%B4%EC%95%BC-%ED%95%98%EB%8A%94-%EC%9D%B4%EC%9C%A0
- https://velog.io/@kanamycine/Java-%EC%9B%90%EC%8B%9C%EA%B0%92-%ED%8F%AC%EC%9E%A5
- https://kimmayer.tistory.com/entry/1%EC%A3%BC%EC%B0%A8-%EB%AF%B8%EC%85%98-%EB%A1%9C%EB%98%90-%EC%9B%90%EC%8B%9C-%EA%B0%92-%ED%8F%AC%EC%9E%A5
- https://nauni.tistory.com/135
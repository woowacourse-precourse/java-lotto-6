# 미션 - 자동차 경주

## 🔍 기능 구현 목록

**구입 금액**
- [x] 구입 금액 입력 폼 출력
- [x] 구입 금액 입력
    - [x] 검증
        - [x] 빈 값인가?
        - [x] 1,000원 단위인가?
        - [x] 첫 숫자가 0으로 시작하는가?
        - [x] 문자가 들어있는가?

**로또 번호**
- [x] 구매 개수 출력
- [x] 로또 숫자 6개 랜덤 생성
    - [x] 검증
        - [x] 숫자가 6개가 맞는가?
        - [x] 중복 숫자가 있는가?
- [x] 오름차순 정렬

**당첨 번호, 보너스 번호**
- [x] 당첨 번호 입력 폼 출력
- [x] 당첨 번호 입력
    - [x] 파싱
        - [x] 입력 받은 문자열을 콤마(,) 기준으로 파싱하여 List 형태로 반환
    - [x] 검증
        - [x] 빈 값인가?
        - [x] 숫자 범위가 1 ~ 45 사이에 있는가?
        - [x] 콤마(,)가 문자열의 처음이나 끝에 있지 않는가?

- [x] 보너스 번호 입력 폼 출력
- [x] 보너스 번호 입력
    - [x] 검증
        - [x] 빈 값인가?
        - [x] 문자가 들어있는가?
        - [x] 숫자 범위과 1 ~ 45 사이에 있는가?
        - [x] 앞의 당첨 번호들과 중복되지 않는가?

**결과**
- [x] 당첨 내역
    - [x] 일치하는 번호 개수 계산
    - [x] 검증
        - [x] 5개 일치할 경우, 보너스 점수도 일치하는가?
    - [x] 당첨 금액 계산
    - [x] 로또 일치 번호 개수에 따른 당첨 내역 출력

- [x] 총 수익률
    - [x] 당첨 금액 / 구입 금액 * 100
        - [x] 파싱
            - [x] 소수점 둘째 자리에서 반올림
- [x] 총 수익률 출력

## 🗂️ 디렉터리 구조
📦src<br/>
 ┣ 📂main<br/>
 ┃ ┗ 📂java<br/>
 ┃ ┃ ┗ 📂lotto<br/>
 ┃ ┃ ┃ ┣ 📂constant<br/>
 ┃ ┃ ┃ ┃ ┗ 📜ConstantMessage.java<br/>
 ┃ ┃ ┃ ┣ 📂controller<br/>
 ┃ ┃ ┃ ┃ ┗ 📜LottoController.java<br/>
 ┃ ┃ ┃ ┣ 📂exception<br/>
 ┃ ┃ ┃ ┃ ┗ 📜ErrorMessage.java<br/>
 ┃ ┃ ┃ ┣ 📂model<br/>
 ┃ ┃ ┃ ┃ ┣ 📜EarnMoney.java<br/>
 ┃ ┃ ┃ ┃ ┣ 📜Lotto.java<br/>
 ┃ ┃ ┃ ┃ ┗ 📜Result.java<br/>
 ┃ ┃ ┃ ┣ 📂parser<br/>
 ┃ ┃ ┃ ┃ ┗ 📜Parser.java<br/>
 ┃ ┃ ┃ ┣ 📂validate<br/>
 ┃ ┃ ┃ ┃ ┗ 📜InputValidate.java<br/>
 ┃ ┃ ┃ ┣ 📂view<br/>
 ┃ ┃ ┃ ┃ ┗ 📜View.java<br/>
 ┃ ┃ ┃ ┗ 📜Application.java<br/>
 ┗ 📂test<br/>
 ┃ ┗ 📂java<br/>
 ┃ ┃ ┗ 📂lotto<br/>
 ┃ ┃ ┃ ┣ 📂model<br/>
 ┃ ┃ ┃ ┃ ┣ 📜EarnMoneyTest.java<br/>
 ┃ ┃ ┃ ┃ ┣ 📜LottoTest.java<br/>
 ┃ ┃ ┃ ┃ ┗ 📜ResultTest.java<br/>
 ┃ ┃ ┃ ┣ 📂parser<br/>
 ┃ ┃ ┃ ┃ ┗ 📜ParserTest.java<br/>
 ┃ ┃ ┃ ┗ 📜ApplicationTest.java<br/>
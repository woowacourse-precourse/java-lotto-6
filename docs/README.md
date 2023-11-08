
# 미션 - 로또
---
## 🕰️ 개발 기간
23.11.02(목) ~ 23.11.08(수)
---
## 패키지 구성
- lotto
    + Controller
        * InputController : 사용자 입력 세팅 및 예외 처리
        * LottoController : 로또 진행을 위한 연산 수행
    + Model
        * Lotto : 로또 클래스 사용에 대한 예외처리, 값 반환, 비교, 형 변환 수행
    + View
        * InputView : 구입 금액, 당첨 번호, 보너스 번호 입력 시에 보여질 출력 화면
        * OutputView : 구매 개수 및 구매 내역, 당첨 통계 출력 화면
    + Application : 로또를 실행하는 main도메인
    + Constants : 로또 진행을 위한 상수들의 집합 (숫자, 구분자, 문자열)
    + Util : Lotto로 형변환, 랜덤값 반환, 정렬에 관한 메소드 정의
---

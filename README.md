# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## To-Do - 로또(3단계)
* 당첨번호 생성
* 보너스 볼 입력
* 로또와 당첨번호, 보너스 일치 여부 판단
* 수익률 계산
* 구매 금액에 따른 구매 개수 계산
* 구매 개수만큼의 로또 생성
* 로또 생성 -> 중복 숫자가 있는지, 개수가 6개인지 확인, 로또 번호가 1~45 사이 값인지
* 로또 번호 -> int에서 LottoNumber 형태로 변경
* LottoMatch의 match 메소드에서 당첨번호&보너스번호 묶어서 한 클래스로 만듦으로써 인자 수 개선
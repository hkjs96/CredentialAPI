# CredentialAPI
CredentialRESTAPI

Spring boot + jpa 이용

AWS EC2 설치 과정에서 
java jdk 11 설치
gradle 설치
gradle 설치 후 gradle 관련 빌드 해야함.
이후 프로젝트 빌드

mysql 로컬 설치, docker 8.0.22 둘다 확인시 상관없이 잘 되었음.
도메인 구입해서 연결해보고 DNS 설정 해봄.

우분투에서 iptables를 통한 포트포워딩을 해보려 했으나 남들 처럼 잘 되지 않음
nginx를 통한 포트 포워딩을 해보려 했으나 80 -> 8080 성공
80 -> 443 -> 8080 은 실패, 현재는 시간이 부족해서 일단 했지만 다음에는 https를 해볼 수 있으면 좋겠음.

## 서버의 기존 DB 삭제 
- mysql
sudo apt-get purge mysql-server
sudo apt-get purge mysql-common

- mariadb
sudo apt-get purge mariadb-server
sudo apt-get purge mariadb-common

- 파일 삭제 
sudo rm -rf /var/log/mysql
sudo rm -rf /var/log/mysql.*
sudo rm -rf /var/lib/mysql
sudo rm -rf /etc/mysql

새로 설치
sudo apt-get update
sudo apt-cache serach mariadb 명령어를 입력해 관련 패키지 있는지 확인 
sudo apt-get install mariadb-server 


- 데몬 실행 
sudo systemctl start mysql

2002 (HY000): Can't connect to local MySQL server through socket '/var/run/mysqld/mysqld.sock' 
(2) 에러를 만났을때

1. MySQL데몬이 기동이 되어 있지 못할때
sudo /usr/bin/mysqld_safe --user=mysql&


- sql 접속 
sudo mysql -u root -p 


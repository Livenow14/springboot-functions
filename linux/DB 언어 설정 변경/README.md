
## 1. 오류 사항
1) mysql insert query 실행시 오류 메시지

mysql> ERROR 1366 (HY000) : incorrect string value : ''\xED\x95\x9C\xEC\x9A\xB0...' for column 'itemName' at row 1



2) application 내에서 insert query 실행시 오류 메시지

org.springframework.jdbc.UncategorizedSQLException: 

### Error updating database.  Cause: java.sql.SQLException: Incorrect string value: '\xED\x95\x9C\xEC\x9A\xB0...' for column 'itemName' at row 1

### The error may involve com.jworks.grevu.mapper.ItemMapper.addItem-Inline

### The error occurred while setting parameters

### SQL: INSERT INTO item (itemName, itemPrice, itemDesc, shopId) VALUES (?,?,?,?)

### Cause: java.sql.SQLException: Incorrect string value: '\xED\x95\x9C\xEC\x9A\xB0...' for column 'itemName' at row 1

; uncategorized SQLException for SQL []; SQL state [HY000]; error code [1366]; Incorrect string value: '\xED\x95\x9C\xEC\x9A\xB0...' for column 'itemName' at row 1; nested exception is java.sql.SQLException: Incorrect string value: '\xED\x95\x9C\xEC\x9A\xB0...' for column 'itemName' at row 1

## 2. 수정방법

1) database, table character set 설정

mysql> SHOW CREATE TABLE table_name;
mysql> ALTER TABLE table_name CONVERT TO character SET utf8; 


## 3. 완료 후 mysql 재시작
$ sudo systemctl restart mysql


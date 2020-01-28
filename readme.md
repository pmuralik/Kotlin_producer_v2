docker run -itd  --name mysql_db1 -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=test -e MYSQL_USERNAME=murali -e MYSQL_PASSWOhna -p 3036:3036 -d mysql:latest

docker exec -it mysql_db1 bash
mysql -u root -ppassword

use test

mysql> create table claim (
    -> created_by text,
    -> claim_id text,
    -> created_date timestamp,
    -> consumed boolean default false);
	
	
	curl -X POST \
  'http://localhost:8085/newClaim?=' \
  -H 'Accept: */*' \
  -H 'Accept-Encoding: gzip, deflate' \
  -H 'Authorization: Basic bXVyYWxpOmtyaXNo' \
  -H 'Cache-Control: no-cache' \
  -H 'Connection: keep-alive' \
  -H 'Content-Length: 41' \
  -H 'Content-Type: application/json' \
  -H 'Host: localhost:8085' \
  -H 'Postman-Token: 53e7bd4b-e5d0-45f9-918d-04edbd7fd17f,c6367394-5903-43de-8827-345a491de27b' \
  -H 'User-Agent: PostmanRuntime/7.20.1' \
  -H 'cache-control: no-cache' \
  -d '{
"createdBy":"Kiran",
"claimId" : "12"
}'

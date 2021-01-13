#TOO TEST APPLICATION USE FOLLOWING CURL

curl --location --request GET 'http://localhost:8080/Mapping2/map' \
--header 'Content-Type: application/json' \
--data-raw '{
"numbers": [1, 2, 3, 4]
}'

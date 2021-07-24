### Base 64 
echo  'user:password' | base64


### Fout wachtwoord 
curl -X GET -i -H "Content-Type: application/hal+json" -H "Authorization: Basic YXBpdXNlcjphcGlwd2Q=" http://localhost:8080

### Goed wachtwoord 
curl -X GET -i -H "Content-Type: application/hal+json" -H "Authorization: Basic dXNlcjpwYXNzd29yZA==" http://localhost:8080

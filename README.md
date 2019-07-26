# VivaCreditDemo
VivaCreditDemo

# Getting Started
/MONGODB/ sc.exe create MongoDB binPath= ""C:\Users\nandan.kelkar\Desktop\Work\Database\mongodb_installation\bin\mongod.exe" --service --config "mongod.cfg" DisplayName= "MongoDB" start= "auto"

/Mongo DB Config/

systemLog: destination: file path: C:\Users\nandan.kelkar\Desktop\Work\Database\test\mongodb\log\mongod.log storage: dbPath: C:\Users\nandan.kelkar\Desktop\Work\Database\test\mongodb\db **************/

db.createCollection("user")
db.createCollection("applicationUser")

db.users.insert({"id": 1, "name": "test user1","email": "test_user1@test.com","phonenumber": "123456789"})

db.applicationUser.insert({"username":"vivacredit","password":"demopassword"})

Also same can be setup using /sign-up post method

/Other Config/
Check application.properties.

Refer : VivaCreditDemo.postman_collection.json

Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)

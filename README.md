XML to PostgreSQL Table Generator (Spring Boot)  
This Spring Boot application dynamically reads an XML file, parses its structure, and creates corresponding PostgreSQL tables.  
It supports foreign keys, primary keys, unique constraints, and transactional execution to ensure data integrity.  
  
🚀 Features  
✅ Parse XML files and generate PostgreSQL tables dynamically  
✅ REST API to upload XML files  
✅ Supports Primary Keys, Foreign Keys, Unique, and Nullable constraints  
✅ Transactional execution (Rollback on failure)  
✅ Detailed error handling & logging  

📦 Tech Stack  
Java 17  
Spring Boot 3  
PostgreSQL Database  
JAXB (for XML Parsing)  
Spring JDBC (for database execution) 
 
⚙️ Setup Instructions  
1️⃣ Clone the Repository  
	git clone https://github.com/bodruddujach/xml-to-ddl.git  
	cd xml-to-ddl  
2️⃣ Configure PostgreSQL Database  
Ensure PostgreSQL is running and update src/main/resources/application.properties:  
  
properties (Copy/Edit)  

spring.datasource.url=jdbc:postgresql://localhost:5432/xml_db  
spring.datasource.username=postgres  
spring.datasource.password=yourpassword  
spring.datasource.driver-class-name=org.postgresql.Driver  
spring.datasource.platform=postgres  

3️⃣ Build & Run the Application  
sh  
Copy/Edit  
mvn clean install  
mvn spring-boot:run  
  
📄 API Endpoints  
🔹 Upload XML File  
Endpoint:  

bash  
Copy/Edit  
POST /api/xml/upload  
Request Type: multipart/form-data  
Request Parameter:  

file (XML file)  
📌 cURL Example  
sh  
Copy/Edit  
curl --location --request POST 'http://localhost:8080/api/xml/upload' \
--form 'file=@"/path/to/schema.xml"'

OR  

curl -X POST "http://localhost:8080/api/xml/upload" \
     -H "Content-Type: multipart/form-data" \
     -F "file=@/path/to/schema.xml"

📌 Postman Usage  
1️⃣ Open Postman  
2️⃣ Select POST request  
3️⃣ Enter URL: http://localhost:8080/api/xml/upload  
4️⃣ Go to Body → Select form-data  
5️⃣ Add key: file → Choose XML file  
6️⃣ Click Send  

📜 Sample Input XML (schema.xml)  
✅ Three sample XML files in the src/main/resources folder  
  
✅ Alternative testing method using CommandLineRunner in DynamicDdlGenerationApplication  
✅ Instructions on how to uncomment and use CommandLineRunner for direct execution  


📜 License
This project is open-source and available under the MIT License.


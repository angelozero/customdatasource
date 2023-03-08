# Custom Data Source 

### A simple solution to handle with custom data sources and multiples database connections

---
- *What was the issue ?*
    - I dont know for sure but some how every time you did a communication with the DB, the DataSource Bean from the application always ignored some rules.
    
---

- *What rules ?*
    - So, in my application I wanted to read the data from a DataBase A and save the other data on DataBase B, but if you do this in a single proccess the datasource always will keep the first DataBase comunication in memory. If you communicate with DataBase A all the next requests will be made in DataBase A, ignoring any runtime configuration made in DataSource to do anything in another DataBase, like save something in DataBase B.

--- 
- *What was the solution ?*
    - To deal with this singleton issue I created two especifics custom datasources for each repository. With this, every time I did a request ( save / find / delete ) to a DataBase, the repository was with the correct configuration and goes to the correct DataBase do the request.

---

- You can see all the configuration in the 
    - [ReaderDataSourceConfig.class](https://github.com/angelozero/customdatasource/blob/main/src/main/java/com/angelozero/customdatasource/config/ReaderDataSourceConfig.java)
    - [WriterDataSourceConfig.class](https://github.com/angelozero/customdatasource/blob/main/src/main/java/com/angelozero/customdatasource/config/WriterDataSourceConfig.java)

---

- ### Diagram
![fluxogram](https://i.postimg.cc/KztMyWhp/Whats-App-Image-2023-03-08-at-19-54-23.jpg)
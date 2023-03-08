# Dynamic Data Source 

### A simple solution to handle dynamic data sources and multiple database connections

---
- *What was the issue?*
    - I do not know for sure, but somehow, every time a communication with the DB was made, the DataSource Bean from the application was ignoring some rules.
    
---

- *What rules?*
    - In my application, I wanted to read the data from DataBase A and save the other data on DataBase B, but if you do this in a single proccess, the datasource keeps the first DataBase communication in its memory. If you communicate with DataBase A, all the next requests will be made in DataBase A, ignoring any runtime configuration made in DataSource to do anything in another DataBase, like saving something in DataBase B, for example.

--- 
- *What was the solution?*
    - To deal with this singleton issue, I created two customized datasources for each repository. With this, every time I made a request ( save / find / delete ) to a DataBase, the repository had the correct configuration and went to the correct DataBase to execute it.

---

- ### Diagram
![fluxogram](https://i.postimg.cc/R08nnHBt/Whats-App-Image-2023-03-08-at-20-51-37.jpg)

--- 

Font: [Stackoverflow - Dynamic Datasource using SpringBoot](https://stackoverflow.com/questions/57224715/dynamic-datasource-using-springboot) ( *look for the Milton BO answer* )

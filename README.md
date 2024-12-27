# redis-lock-demo
Accessing a shared resource using redis lock mechanism

## How to Run the Application

### 1. Start Redis Server:
- Make sure Redis is running on `localhost:6379`. You can install Redis locally or use a cloud service.

### 2. Build and Run the Application:
- Use the following Maven command to build the application:

    ```bash
    mvn clean install
    ```

- Run the application:

    ```bash
    mvn spring-boot:run
    ```

### 3. Access the Application:
- The application should be running on [http://localhost:8080](http://localhost:8080).
- To trigger the lock mechanism, access [http://localhost:8080/execute](http://localhost:8080/execute).


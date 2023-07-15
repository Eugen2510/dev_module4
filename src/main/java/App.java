import com.eugene.feature.storage.Storage;

import java.sql.Connection;

public class App {
    public static void main (String [] args){
        Storage storage = Storage.getInstance();
        //Connection connection = Storage.getInstance().getConnection();
        int i = storage.executeUpdate("CREATE TABLE IF NOT EXISTS worker(\n" +
                "    id IDENTITY PRIMARY KEY,\n" +
                "    name VARCHAR(1000) NOT NULL,\n" +
                "    birthday DATE,\n" +
                "    level VARCHAR (7) NOT NULL,\n" +
                "    salary INT,\n" +
                "    CONSTRAINT check_worker_name\n" +
                "        CHECK (LENGTH(name) >= 2),\n" +
                "    CONSTRAINT check_birthday\n" +
                "        CHECK (YEAR(birthday) > 1900),\n" +
                "    CONSTRAINT check_level\n" +
                "        CHECK(level IN ('Trainee', 'Junior', 'Middle', 'Senior')),\n" +
                "    CONSTRAINT check_salary\n" +
                "        CHECK (salary >= 100 AND salary <= 100000)\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE IF NOT EXISTS client(\n" +
                "    id IDENTITY PRIMARY KEY,\n" +
                "    name VARCHAR(1000) NOT NULL,\n" +
                "    CONSTRAINT check_client_name\n" +
                "        CHECK (LENGTH(name) >= 2)\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE IF NOT EXISTS project(\n" +
                "    id IDENTITY PRIMARY KEY,\n" +
                "    client_id BIGINT,\n" +
                "    start_date DATE,\n" +
                "    finish_date DATE,\n" +
                "    CONSTRAINT check_interval\n" +
                "        CHECK (start_date < finish_date),\n" +
                "    FOREIGN KEY (client_id) REFERENCES client (id)\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE IF NOT EXISTS project_worker(\n" +
                "    project_id BIGINT,\n" +
                "    worker_id BIGINT,\n" +
                "    PRIMARY KEY (project_id, worker_id),\n" +
                "    FOREIGN KEY (project_id) REFERENCES project(id),\n" +
                "    FOREIGN KEY (worker_id) REFERENCES worker(id)\n" +
                ");");

        System.out.println("i = " + i);

    }
}

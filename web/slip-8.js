const mysql = require("mysql2");

// Create a connection to the MySQL server
const connection = mysql.createConnection({
  host: "localhost",
  user: "your_username",
  password: "your_password",
  database: "testdb", // Change to your desired database name
});

// Connect to the MySQL server
connection.connect((err) => {
  if (err) {
    console.error("Error connecting to MySQL:", err);
    return;
  }

  console.log("Connected to MySQL");

  // Create a new database
  connection.query("CREATE DATABASE IF NOT EXISTS testdb", (err) => {
    if (err) {
      console.error("Error creating database:", err);
      connection.end();
      return;
    }

    console.log("Database created or already exists");

    // Use the created database
    connection.query("USE testdb", (err) => {
      if (err) {
        console.error("Error using database:", err);
        connection.end();
        return;
      }

      console.log("Using database: testdb");

      // Create a new table
      const createTableQuery = `
                CREATE TABLE IF NOT EXISTS users (
                    id INT PRIMARY KEY AUTO_INCREMENT,
                    username VARCHAR(50) NOT NULL,
                    email VARCHAR(100) NOT NULL
                )
            `;

      connection.query(createTableQuery, (err) => {
        if (err) {
          console.error("Error creating table:", err);
        } else {
          console.log("Table created or already exists");
        }

        // Close the connection
        connection.end();
      });
    });
  });
});

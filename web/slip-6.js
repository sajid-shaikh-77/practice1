const http = require("http");
const fs = require("fs");
const path = require("path");

const server = http.createServer((req, res) => {
  // Extract the requested file path from the URL
  const filePath = path.join(__dirname, req.url);

  // Read the file
  fs.readFile(filePath, "utf8", (err, data) => {
    if (err) {
      // If file not found, send a 404 error
      if (err.code === "ENOENT") {
        res.writeHead(404, { "Content-Type": "text/plain" });
        res.end("404 Not Found");
      } else {
        // If other error, send a generic 500 error
        res.writeHead(500, { "Content-Type": "text/plain" });
        res.end("500 Internal Server Error");
      }
    } else {
      // If successful, send the file content
      res.writeHead(200, { "Content-Type": "text/plain" });
      res.end(data);
    }
  });
});

const PORT = 3000;
server.listen(PORT, () => {
  console.log(`Server is running on http://localhost:${PORT}`);
});

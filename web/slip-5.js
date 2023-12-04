const readline = require("readline");
const fs = require("fs");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

// Function to append contents of the first file into the second file
function appendFiles(firstFile, secondFile) {
  // Read contents of the first file
  fs.readFile(firstFile, "utf8", (err, data) => {
    if (err) {
      console.error(`Error reading ${firstFile}: ${err.message}`);
      rl.close();
      return;
    }

    // Append contents to the second file
    fs.appendFile(secondFile, data, (err) => {
      if (err) {
        console.error(`Error appending to ${secondFile}: ${err.message}`);
      } else {
        console.log(
          `Contents of ${firstFile} appended to ${secondFile} successfully.`
        );
      }
      rl.close();
    });
  });
}

// Read file names from the user
rl.question("Enter the name of the first file: ", (firstFile) => {
  rl.question("Enter the name of the second file: ", (secondFile) => {
    appendFiles(firstFile, secondFile);
  });
});

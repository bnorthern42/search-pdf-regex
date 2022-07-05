
const s = require("../index");
const assert = require('assert');

const result = s.SearchPDF("dummy.pdf", "Dummy" , function(output, exit_code) {
    console.log("Process Finished.");
    console.log('closing code: ' + exit_code);
    console.log('Full output of script: ', output);
   assert.equal(output, "Dummy");

});


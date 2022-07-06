
const Lib = require("../index");
const assert = require('assert');

Lib.SearchPDF("dummy.pdf", "Dummy", "--bool")
	.then(out => {
	console.log("assert Dummy is pulled");
	assert.equal(out, "True")
}).catch(err =>{
	  console.log(err);
});

Lib.SearchPDF("large.pdf", "lo*re*", "--bool")
	.then(out => {
	console.log("Assert with wild cards");
	assert.equal(out, "True")
}).catch(err =>{
	  console.log(err);
});




const s = require("../index");
const assert = require('assert');

s.SearchPDF("dummy.pdf", "Dummy")
	.then(out => {
	  console.log(out);
	})
	.catch(err =>{
	  console.log(err);
	});



const s = require("../index");
const assert = require('assert');

const dd =s.SearchPDF("dummy.pdf", "Dummy", "--bool")
.then(out => {
		//	console.log("he");
		console.log(out);

				assert.equal(out, "True")
})
	.catch(err =>{
	  console.log(err);
	});

const path = require('path');
const Aigle = require('aigle');
global.Promise = Aigle;
/** Simplification, now works perfectly 
 * @param filename file to search with
 * @searchTerm regex search
 * */
async function SearchPDF(filename,searchTerm, options=""){
const jarfile = path.join(__dirname , 'javaJar/parsePDF.jar');
var spawn = require('child_process').spawnSync;
var child = spawn('java', ['-jar',jarfile,filename, searchTerm, options]);
  var scriptOutput = "";
		scriptOutput+=child.stdout.toString().trim();

		if(child.stderr)
				scriptOutput+=child.stderr;

 const promise = new Aigle((resolve, reject) => resolve(scriptOutput));
     const out =  await promise;
	    return out.toString();


}

module.exports = {SearchPDF};



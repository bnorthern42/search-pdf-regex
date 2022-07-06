const path = require('path');

/** 
 * @param filename file to search with
 * @searchTerm regex search
 * */
async function SearchPDF(filename,searchTerm){
const jarfile = path.join(__dirname , 'javaJar/parsePDF.jar');
var spawn = require('child_process').spawn;
var child = spawn('java', ['-jar',jarfile,filename, searchTerm]);
  var scriptOutput = "";
    child.stdout.setEncoding('utf8');
    child.stdout.on('data', function(data) {
        console.log('stdout: ' + data);

        data=data.toString();
        scriptOutput+=data;
    });

    child.stderr.setEncoding('utf8');
    child.stderr.on('data', function(data) {
        console.log('stderr: ' + data);

        data=data.toString();
        scriptOutput+=data;
    });

    child.on('close', function(code) {
    
    });

 const promise = new Promise(resolve => resolve(scriptOutput));
     const out =  await promise;
	    return out;


}

module.exports = {SearchPDF};
/**
 * not even gonna deny it, code adapted from: 'Stuck'Overflow 
 * https://stackoverflow.com/questions/14332721/node-js-spawn-child-process-and-get-terminal-output-live
 * added promise stuff
 * */

